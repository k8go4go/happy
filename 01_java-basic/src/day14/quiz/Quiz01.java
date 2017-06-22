package day14.quiz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
 *   현재 시간에 대한 디렉토리 생성하기
 *   생성할 위치
 *   iodata/day14
 *   2017/04/27/09
 */
public class Quiz01 {
	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat(
//			"yyyy/MM/dd/HH"
//		);
//		String path = "iodata/day14/" + sdf.format(new Date());
//		File f = new File(path);
//		if (f.exists()) {
//			System.out.println("이미 존재하는 디렉토리임");
//		} else {
//			if (f.mkdirs()) System.out.println("생성 성공");
//			else System.out.println("생성 실패");
//		}	
		new File(
			"iodata/day14/" + 
			new SimpleDateFormat("yyyy/MM/dd/HH").format(new Date())
		).mkdirs();
	}
}











