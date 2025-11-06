package exception;

public class E001_ExceptionDemo {
	public static void main(String[] args) {
		
		
		System.out.println("Program started...");
		try {
			
//			int a = 10;
//			int b = a/0;
//			System.out.println(b);
			
			int a[] = new int[5];
			a[5] = 45;
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		System.out.println("Program ended...");
		
		
		
	}
}
