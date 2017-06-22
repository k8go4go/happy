package day07.exam;

public class MethodUtil {

	public boolean isLowerChar(char c) {
		return c >= 'a' && c <= 'z';
	}

	public boolean isUpperChar(char c) {
		return c >= 'A' && c <= 'Z';
	}

	public int max(int i, int j) {
		return i > j ? i : j;
	}

	public int min(int i, int j) {
		return i < j ? i : j;
	}

	public String reverse(String data) {
		String result = "";
		for (int i = data.length() - 1; i >= 0; i--) {
			result += data.charAt(i);
		}
		return result;
	}

	public String toUpperString(String data) {
		String result = "";
		int gap = 'a' - 'A';
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			result += isLowerChar(ch) ? (char)(ch - gap) : ch;
		}
		return result;
	}

	public String toLowerString(String data) {
		String result = "";
		int gap = 'a' - 'A';
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			result += isUpperChar(ch) ? (char)(ch + gap) : ch;
		}
		return result;
	}
}
