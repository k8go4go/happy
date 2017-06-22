package day13.quiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Quiz02VoDAO extends Quiz02DAO {
	
	private List<Quiz02VO> list;
	
	public Quiz02VoDAO() throws FileNotFoundException {
		list = new ArrayList<>();
		loadingFile();
	}

	void setData(String[] arr) {
		Quiz02VO vo = new Quiz02VO();
		vo.setName(arr[0]);
		vo.setAge(Integer.parseInt(arr[1]));
		vo.setGenre(arr[2]);
		vo.setGendar(arr[3].equals("1") ? "남성" : "여성");
		list.add(vo);
	}

	public List<Quiz02VO> select() {
		return list;
	}
}
