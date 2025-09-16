package logical;

public class Factorial {
	public static void main(String[] args) {
		
		int num = 5;
		
		int fact = 1;
//		for(int i=1;i<=num;i++)
//		{
//			fact = fact*i;
//		}
		
		
		while(num!=0)
		{
			fact = fact*num;
			num--;
		}
		
		
		
		System.out.println(fact);
		
	}
}
    



