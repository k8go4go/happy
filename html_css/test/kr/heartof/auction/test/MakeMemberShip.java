package kr.heartof.auction.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeMemberShip {
	public static void main(String[] args) throws IOException {
		int MAX = 11616;
		BufferedReader bf = new BufferedReader(new FileReader("C:/project/private/git/happy/html_css/doc/usernumber.txt"));
		FileWriter fw = new FileWriter(new File("C:/project/private/git/happy/html_css/doc/sql/membership_card_"+ System.currentTimeMillis() / 100+".txt"));
		List<String> list = generate(16, MAX);
		String query = "INSERT INTO MEMBERSHIP (MEMB_NUM, MSHIP_CARD_NUM, NM, POINT, ISSUE_DATE, ISSUE_CNT, DEG) values (%s, \'%s\', \'SHINHAN\', 10000, sysdate, 1, \'1201\'); \n";
		
		String readStr = null;
		int index =0;
		while((readStr = bf.readLine()) != null) {
			String data = String.format(query, readStr, list.get(index++));
			fw.write(data);
		}
		fw.flush();
		fw.close();
		bf.close();
	}		

    public static List<String> generate(int length, int size) {
    	Random random = new Random(System.currentTimeMillis());
    	List<String> list = new ArrayList<String>();
    	for(int j=0; j < size; j++) {
	        StringBuilder builder = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int digit = random.nextInt(10);
	            builder.append(digit);
	        }
	        
	        list.add(builder.toString());
    	}
        return list;
    }
}
