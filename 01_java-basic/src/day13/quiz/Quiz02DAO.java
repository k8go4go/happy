package day13.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public abstract class Quiz02DAO {
	
	protected void loadingFile() throws FileNotFoundException  {
		Scanner sc = new Scanner(new File("iodata/day13/quiz02.txt"));
		while (sc.hasNextLine()) {
			setData(sc.nextLine().split(":"));
		}
	}
	abstract void setData(String[] arr);
	public abstract List<?> select();
}
