package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		// 예외의 직접 처리
		/*
		 *   try : 예외가 발생할 수 있는 코드를 묶는다.
		 *       : 단독 사용 불가능
		 *       : try ~ catch(가장 많이 사용)
		 *       : try ~ finally, try ~ catch ~ finally 
		 *   
		 *   catch : try 블럭에서 예외가 발생하면 발생한 예외를
		 *         : 처리하는 코드를 작성한다.  
		 *         : try 블럭에서 발생한 예외를 받을 수 있는
		 *           타입을 명시  
		 */
		
		try {
			File f = new File("a.txt");
			// 예외가 발생할 수 있는 코드
			Scanner sc = new Scanner(f);
//			FileNotFoundException fnfe = new FileNotFoundException();
//			IOException ie = new FileNotFoundException();
//			Exception e = new FileNotFoundException();
//			Throwable e = new FileNotFoundException();
//			Object e = new FileNotFoundException();
			
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("파일이 없음..");
			String errMsg = fnfe.getMessage();
			System.out.println(errMsg);
			
			fnfe.printStackTrace();
		}
//		catch (FileNotFoundException fnfe) {
//		catch (IOException e) {
//		catch (Exception e) {
//		catch (Throwable e) {
		// Throwable 타입만 올 수 있다.
//		catch (Object e) {
//		}
		
		
	}
}











