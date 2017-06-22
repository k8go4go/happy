import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Choice {
	public static void main(String[] args) throws Exception {
		
		List<Integer> list = 
				(List) Arrays.asList(new Integer[] {2, 3, 4, 5});
		
		System.out.println("발표순서");
		Collections.shuffle(list);
		for (Integer val : list) {
			Thread.sleep(1000);
			System.out.println(val + "조");
		}
	}
}













