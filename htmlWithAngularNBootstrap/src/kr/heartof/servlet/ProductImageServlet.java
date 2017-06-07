package kr.heartof.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import kr.heartof.vo.member.UsrFileVO;
import kr.heartof.vo.member.UsrVO;

public class ProductImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsrVO user = (UsrVO)request.getSession().getAttribute("user");
		UsrFileVO fileVO = user.getUSR_FILE();
		if(fileVO == null) return;
		
		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		try {
			in = new BufferedInputStream(
					new FileInputStream(new File(fileVO.getFILE_PATH() + fileVO.getFILE_NM())));
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}
			
			response.setContentType("image/jpeg");
			response.setContentLength(bStream.toByteArray().length);
			bStream.writeTo(response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bStream != null) 
				try { bStream.close(); } catch (Exception est) {}
			
			if (in != null) 
				try { in.close(); } catch (Exception ei) {}
		}

	}
}
