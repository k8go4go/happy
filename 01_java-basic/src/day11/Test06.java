package day11;

public class Test06 {
	public static void main(String[] args) {
		try {
			String msg = null;
			// NullPointerException
			System.out.println(msg.length());
			
			// ArithmeticException
			System.out.println(1 / 0);
		} 
		// 1.7 버전부터 가능함
		catch (NullPointerException | ArithmeticException e) {
			System.out.println("예외발생");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
