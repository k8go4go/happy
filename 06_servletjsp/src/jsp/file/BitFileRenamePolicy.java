package jsp.file;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class BitFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		// f가 가리키는 전체 파일 경로가 만약... 다음과 같다면
		// c:/java94/tomcat-work/06_servletjsp/upload/test.jpg
		
		// test.jpg
		String name = f.getName();
		
		// c:/java94/tomcat-work/06_servletjsp/upload
		String parent = f.getParent();
		
		// .jpg를 ext 변수에 저장
		String ext = "";
		int index = name.lastIndexOf(".");
		if (index != -1) {
			ext = name.substring(index);
		}
		
		// Unique 한 값을 추출하는 API 클래스 활용
		String fName = UUID.randomUUID().toString();
		return new File(parent, fName + ext);
	}

}










