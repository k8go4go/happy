package day13.quiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz02MapDAO extends Quiz02DAO {
	
	private List<Map<String, String>> list;
	
	public Quiz02MapDAO() throws FileNotFoundException {
		list = new ArrayList<>();
		loadingFile();
	}

	void setData(String[] arr) {
		Map<String, String> map = new HashMap<>();
		map.put("name", arr[0]);
		map.put("age", arr[1]);
		map.put("genre", arr[2]);
		map.put("gender", (arr[3].equals("1") ? "남성" : "여성"));
		list.add(map);
	}

	public List<Map<String, String>> select() {
		return list;
	}
}
