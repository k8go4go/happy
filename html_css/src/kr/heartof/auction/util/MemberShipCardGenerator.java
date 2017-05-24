package kr.heartof.auction.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemberShipCardGenerator {
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
