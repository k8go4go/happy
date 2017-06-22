package day13.quiz;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Quiz02UI {
	
	private Quiz02DAO dao;
	
	public Quiz02UI() throws FileNotFoundException {
		dao = new Quiz02MapDAO();
//		dao = new Quiz02VoDAO();
	}

	public void service() {
		showSingerByMap();
//		showSingerByVO();
	}
	
	private void showSingerByMap() {
		List<Map<String, String>> list = (List<Map<String, String>>)dao.select();
		System.out.println("가수정보");
		System.out.println("---------------------");
		for (Map<String, String> map : list) {
			System.out.println(
					map.get("name" ) + "\t" +
							map.get("age"  ) + "\t" +
							map.get("genre") + "\t" +
							map.get("gender")
					);
		}
		System.out.println("---------------------");
	}
	private void showSingerByVO() {
		List<Quiz02VO> list = (List<Quiz02VO>)dao.select();
		System.out.println("가수정보");
		System.out.println("---------------------");
		for (Quiz02VO vo : list) {
			System.out.println(
					vo.getName() + "\t" +
					vo.getAge() + "\t" +
					vo.getGenre() + "\t" +
					vo.getGendar()
			);
		}
		System.out.println("---------------------");
	}
}
