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

public class MakeElecWallet {
	public static void main(String[] args) throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader(new File("C:/project/private/git/happy/html_css/doc/sql/elec_wallet_old.txt")));
		
		FileWriter fw = new FileWriter(new File("C:/project/private/git/happy/html_css/doc/sql/elec_wallet_export.txt"));
		
		String data = null;
		while((data = fr.readLine()) != null) {
			data = reserve(data, "100000");
			fw.write(data + "\n");
		}

		fw.flush();
		fw.close();
		fr.close();
	}		
	
	public static String reserve(String data, String replaceWorld) {
		String first = data.substring(0, data.indexOf(",")+1);
		String second = replaceWorld + ");";
		return first + second;
	}
}
