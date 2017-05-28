package kr.heartof.filter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class KoreanLangageFilter implements Filter {
	private static final Pattern PAT_COMMA = Pattern.compile(",\\s*");

	private String inputEncodingParameterName = null;
	private final List<Charset> encodings = new ArrayList<Charset>();

	@Override
	public void init(FilterConfig config) throws ServletException {
		String encodingsStr = "UTF-8";

		Enumeration<String> en = config.getInitParameterNames();
		while (en.hasMoreElements()) {
			final String name = en.nextElement();
			final String value = config.getInitParameter(name);
			if (name.equals("encodings")) {
				encodingsStr = value;
			} else if (name.equals("inputEncodingParameterName")) {
				inputEncodingParameterName = value;
			} else {
				throw new IllegalArgumentException("Unknown parameter: " + name);
			}
		}

		for (String encoding : PAT_COMMA.split(encodingsStr)) {
			Charset charset = Charset.forName(encoding);
			encodings.add(charset);
		}
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain fc)
			throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) sreq;
		final HttpServletResponse res = (HttpServletResponse) sres;

		final Map<String, String[]> params;
		try {
			params = Util.decodeParameters(req.getParameterMap(), encodings, inputEncodingParameterName);
		} catch (IOException e) {
			res.sendError(400, e.getMessage());
			return;
		}

		HttpServletRequest wrapper = new ParametersWrapper(req, params);
		fc.doFilter(wrapper, res);
	}

	@Override
	public void destroy() {
		// nothing to do
	}

	static abstract class Util {

		static CharsetDecoder strictDecoder(Charset cs) {
			CharsetDecoder dec = cs.newDecoder();
			dec.onMalformedInput(CodingErrorAction.REPORT);
			dec.onUnmappableCharacter(CodingErrorAction.REPORT);
			return dec;
		}

		static int[] toCodePoints(String str) {
			final int len = str.length();
			int[] codePoints = new int[len];
			int i = 0, j = 0;
			while (i < len) {
				int cp = Character.codePointAt(str, i);
				codePoints[j++] = cp;
				i += Character.charCount(cp);
			}
			return j == len ? codePoints : Arrays.copyOf(codePoints, len);
		}

		public static String recode(String encoded, CharsetDecoder decoder) throws IOException {
			byte[] bytes = new byte[encoded.length()];
			int bytescount = 0;

			for (int i = 0; i < encoded.length(); i++) {
				char c = encoded.charAt(i);
				if (!(c <= '\u00FF'))
					throw new IOException("Invalid character: #" + (int) c);
				bytes[bytescount++] = (byte) c;
			}

			CharBuffer cbuf = decoder.decode(ByteBuffer.wrap(bytes, 0, bytescount));
			String result = cbuf.toString();
			return result;
		}

		static String ensureDefinedUnicode(String s) throws IOException {
			for (int cp : toCodePoints(s)) {
				if (!Character.isDefined(cp))
					throw new IOException("Undefined unicode code point: " + cp);
			}
			return s;
		}

		static Map<String, String[]> decodeParameters(Map<String, String[]> originalParams, List<Charset> charsets,
				String ieName) throws IOException {
			Map<String, String[]> params = new LinkedHashMap<String, String[]>();

			Charset ie = null;
			{
				String[] values = originalParams.get(ieName);
				if (values != null) {
					for (String value : values) {
						if (!value.isEmpty() && value.indexOf('%') == -1) {
							try {
								if (ie != null)
									throw new IOException("Duplicate value for input encoding parameter: " + ie
											+ " and " + value + ".");
								ie = Charset.forName(value);
							} catch (IllegalCharsetNameException e) {
								throw new IOException("Illegal input encoding name: " + value);
							} catch (UnsupportedCharsetException e) {
								throw new IOException("Unsupported input encoding: " + value);
							}
						}
					}
				}
			}

			Charset[] css = (ie != null) ? new Charset[] { ie } : charsets.toArray(new Charset[charsets.size()]);
			for (Charset charset : css) {
				try {
					params.clear();
					CharsetDecoder decoder = strictDecoder(charset);
					for (Map.Entry<String, String[]> entry : originalParams.entrySet()) {
						final String encodedName = entry.getKey();
						final String name = ensureDefinedUnicode(Util.recode(encodedName, decoder));
						for (final String encodedValue : entry.getValue()) {
							final String value = ensureDefinedUnicode(Util.recode(encodedValue, decoder));
							String[] oldValues = params.get(name);
							String[] newValues = (oldValues == null) ? new String[1]
									: Arrays.copyOf(oldValues, oldValues.length + 1);
							newValues[newValues.length - 1] = value;
							params.put(name, newValues);
						}
					}
					return params;
				} catch (IOException e) {
					continue;
				}
			}

			List<String> kvs = new ArrayList<String>();
			for (Map.Entry<String, String[]> entry : originalParams.entrySet()) {
				final String key = entry.getKey();
				for (final String value : entry.getValue()) {
					kvs.add(key + "=" + value);
				}
			}
			throw new IOException("Could not decode the parameters: " + kvs.toString());
		}
	}

	static class ParametersWrapper extends HttpServletRequestWrapper {

		private final Map<String, String[]> params;

		public ParametersWrapper(HttpServletRequest request, Map<String, String[]> params) {
			super(request);
			this.params = params;
		}

		@Override
		public String getParameter(String name) {
			String[] values = params.get(name);
			return (values != null && values.length != 0) ? values[0] : null;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			return Collections.unmodifiableMap(params);
		}

		@Override
		public Enumeration<String> getParameterNames() {
			return Collections.enumeration(params.keySet());
		}

		@Override
		public String[] getParameterValues(String name) {
			return params.get(name);
		}
	}
}
