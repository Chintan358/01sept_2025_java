package logical;

public class BTD {
	
	public static void main(String[] args) {
		
		int num = 1111001;
		int count = 0;
		int sum = 0;
		while(num!=0)
		{
			int rem = num%10;
			sum  = (int) (sum + (rem*Math.pow(2, count)));
			num=num/10;
			count++;
		}
		
		System.out.println(sum);
		
		
	}
}	
