package logical;

public class DTH {
	public static void main(String[] args) {
		
		
		int num = 1234;
		
		String result="";
		String val[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		while(num!=0)
		{
			
			int rem = num%16;
			result = val[rem]+result;
			num = num/16;
			
		}
		
		System.out.println(result);
		
		
		
	}
}
