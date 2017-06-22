package jsp.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/jsp/file/Upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		// 실제 톰켓이 인식하는 웹어플리케이션의 경로를 반환
		String uploadPath = context.getRealPath("/upload");
		System.out.println("uploadPath : " + uploadPath);
		
		// upload 하위에 모듈별 날짜 형태의 디렉토리 생성후 저장
		SimpleDateFormat sdf = new SimpleDateFormat(
			"/yyyy/MM/dd"	
		);
		String datePath = sdf.format(new Date());
		System.out.println(datePath);
		
		uploadPath += datePath;
		
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		// cos.jar 업로드 사용 클래스
		// 객체 생성시 요청 스트림의 데이터를 파싱하고 서버에 파일을 저장
		// 서버상에 파일의 저장 위치 지정
//		String uploadPath = 
//			"D:/git/bit-java94/lecture/06_servletjsp/WebContent/upload";
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadPath, 
				1024 * 1024 * 10, 
				"utf-8", 
//				new DefaultFileRenamePolicy()
				new BitFileRenamePolicy()
		); 
		
//		String msg = request.getParameter("msg");
		String msg = multi.getParameter("msg");
		System.out.println("msg : " + msg);
		
		// 원본파일명, 시스템파일명, 파일사이즈
		
		
		System.out.println("파일 저장 성공");
		
		// 여러개의 파일이 넘어올 경우 file 속성의 name 값들을 가져온다.
		Enumeration<String> fNames = multi.getFileNames();
		while (fNames.hasMoreElements()) {
			// attachFile1, attachFile2
			String fileName = fNames.nextElement();
			// 사용자가 선택한 file의 name 속성의 값을 입력
			// 만약, file 이 null 이라면 사용자가 파일을 첨부하지 않은 경우이다.
			File file = multi.getFile(fileName);
			// 사용자가 파일을 선택한 경우
			if (file != null) {
				// 파일의 byte 크기
				long size = file.length();
				// 사용자가 첨부한 파일명
				String orgName = 
						multi.getOriginalFileName(fileName);
				// UUID 로 변경한 시스템에 저장된 파일명
				String systemName = 
						multi.getFilesystemName(fileName);
				System.out.println("-------------------------");
				System.out.println("크기 : " + size);
				System.out.println("원본파일명 : " + orgName);
				System.out.println("시스템파일명 : " + systemName);
			}			
		}
		
	}
	/*
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 화면에 읽은 내용을 보내기 위해..
		PrintWriter out = response.getWriter();
		
		// 요청 body에 들어온 내용을 확인
		InputStream in = request.getInputStream();
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			out.println(sc.nextLine());
		}
		out.close();
	}
	*/
}












