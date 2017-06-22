/*
 *  stream.txt 파일의 내용을 읽어서 아래와 같이 실행하도록 프로그램 작성
 *  1. test.txt, abc.txt 파일이 생성되어야 한다.
 *  2. 생성된 test.txt 파일의 내용은 아래와 같아야 한다.
	   commons-fileupload
	   commons-fileupload
	   1.3.1
	3. 생성된 abc.txt 파일의 내용은 아래와 같아야 한다.
	   abcd
	   efg
	   hijk
	   
	        
 */
package day09.exam;

public class Exam03 {
	public static void main(String[] args) {
		
		// 실행 시 pom.xml 파일이 생성되고 해당 파일에 stream.txt 파일의
		// 일부 내용이 저장됨..
		MultipartRequest request = new MultipartRequest("stream.txt");
		
		String id = request.getParameter("id");
		// hong 이 출력됨
		System.out.println("id : " + id);
		
		String pass = request.getParameter("pass");
		// 1234 가 출력됨
		System.out.println("pass : " + pass);
		
		// test.txt, abc.txt 의 내용을 가지고 있는 배열을 반환
		MultipartFile[] files = request.getFiles();
		
		// 2 가 출력
		System.out.println(files.length);
		
		// test.txt 이 출력
		System.out.println(files[0].getName());
		/*
		commons-fileupload
		commons-fileupload   이 출력됨
		 */
		System.out.println(files[0].getContent());
		// abc.txt 이 출력
		System.out.println(files[1].getName());
		/*
		abcd
		efg
		hijk		이 출력됨
		 */
		System.out.println(files[1].getContent());
	}

}
