package day14.quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {

	public static void copy(String ori, String dest) 
			throws Exception {
		File dFile = new File(dest);
		if (dFile.isDirectory()) {
			File oFile = new File(ori);
			dest += "/" + oFile.getName();
		} 
		else {
			File dir = new File(dFile.getParent());
			dir.mkdirs();
		}
		
		try (
			FileInputStream fis = new FileInputStream(ori);
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream(dest);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			while (true) {
				int ch = bis.read();
				if (ch == -1) break;
				
				bos.write(ch);
			}
		} 
		catch (Exception e) {
			throw e;
		}		
	}
}
