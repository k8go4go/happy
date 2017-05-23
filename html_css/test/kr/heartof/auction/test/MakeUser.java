package kr.heartof.auction.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class MakeUser {
	public static void main(String[] args) throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader(new File("C:/project/private/git/happy/html_css/doc/sql/usr_기업.sql")));
		
		FileWriter fw = new FileWriter(new File("C:/project/private/git/happy/html_css/doc/sql/usr_기업"+ System.currentTimeMillis() / 100+".txt"));
		
		String data = null;
		List<String> list = makeUUID(6082);
		int count = 0;
		while((data = fr.readLine()) != null) {
			data = data.replaceAll("8go4go", list.get(count++));
			fw.write(data + "\n");
		}

		fw.flush();
		fw.close();
		fr.close();
		
	}		
	
	public static List<String> makeUUID(int size) {
		try {
			List<String> uuid = new ArrayList<String>();
			
			for(int i=0 ; i < size; i++) {
				SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
				String randomNum = new Integer(prng.nextInt()).toString();
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				byte[] result = sha.digest(randomNum.getBytes());
				
				String uid = hexEncoding(result);
				System.out.println("Random number: " + randomNum);
				System.out.println("Message digest: " + uid);
				uuid.add(uid);
			}
			
			return uuid;
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private static String hexEncoding(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		char[] digits2 = { 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'q', 'r', 's', 't', 'u', 'v', 'w'};
		
		char[] digits = System.currentTimeMillis() % 2 == 0 ? digits1 : digits2;
		
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}
}
