package day14.quiz;

public class Quiz05 {
	public static void main(String[] args) {
		try {
			/*
			 *  iodata/day14/a.txt의 파일을 iodata/day14/a/b/acopy.txt로 복사한다.
			 *  만약, acopy.txt 파일이 복사될 iodata/day14/a/b 디렉토리가 존재하지 않는다면
			 *  디렉토리를 생성 후 파일을 복사한다. 
			 */
			FileUtil.copy("iodata/day14/a.txt", "iodata/day14/a/b/acopy.txt");
			System.out.println("복사성공");
			

			// iodata/day14/a.txt 파일의 내용을 iodata/day14/a/b가 디렉토리 일경우 해당 디렉토리 아래로 동일한 a.txt 이름으로 복사한다.
			FileUtil.copy("iodata/day14/a.txt", "iodata/day14/a/b");
			
		} catch (Exception e) {
			System.out.println("파일 복사중 오류 발생");;
		}
	}
}
