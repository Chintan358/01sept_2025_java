package operators;

public class O001_Unary {
	public static void main(String[] args) {
		
		// ++pre --pre post++ post--
		
		
		int a = 17;
		int b = --a + --a - a++ + ++a;


		System.out.println(a);
		System.out.println(b); 
		
		
		
		
	}
}
