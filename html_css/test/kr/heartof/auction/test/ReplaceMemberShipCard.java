package kr.heartof.auction.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReplaceMemberShipCard {
	public static void main(String[] args) throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader(new File("C:/project/private/git/happy/html_css/doc/sql/membership_card_old.txt")));
		
		FileWriter fw = new FileWriter(new File("C:/project/private/git/happy/html_css/doc/sql/membership_card_export.txt"));
		
		String data = null;
		int count = 1;
		while((data = fr.readLine()) != null) {
			data = reserve(data, String.valueOf(count++));
			fw.write(data + "\n");
		}

		fw.flush();
		fw.close();
		fr.close();
	}		
	
	public static String reserve(String data, String replaceWorld) {
		String first = data.substring(0, data.indexOf("VALUES (") + 8);
		String second = data.substring(data.indexOf("VALUES (") + 13, data.length());
		return first + replaceWorld + second;
	}
}
