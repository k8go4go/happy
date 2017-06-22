package day13.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz05 {
	public static void main(String[] args) {
		List<Data> list = new ArrayList<>();
		list.add(new Data(3));
		list.add(new Data(9));
		list.add(new Data(5));
		
		Collections.sort(list);
		System.out.println(list);

		Collections.reverse(list);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
	}
}










