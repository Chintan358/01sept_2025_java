/**
 * This Java class compares the performance of StringBuffer and StringBuilder by appending a string in
 * a loop.
 */
package impclasses;

public class I004_StrngBuffervsBuilder {
	public static void main(String[] args) {
		
		
		//sync - slow
		
		double startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer("Hello");
		for(int i=1;i<=1000000;i++)
		{
			sb.append("Python");
		}
		
		double endTime = System.currentTimeMillis();
		
		//async - fast
		double startTime1 = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder("Hello");
		for(int i=1;i<=1000000;i++)
		{
			sb1.append("Python");
		}
		
		double endTime1 = System.currentTimeMillis();
		
		System.out.println("time taken by bugffer : "+(endTime-startTime));
		System.out.println("time taken by builder : "+(endTime1-startTime1));
		
	}
}
