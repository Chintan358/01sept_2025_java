package array;

public class A005_sorting {
	public static void main(String[] args) {
		
		
		
		int a[] = {10,40,5,68,64,45,98,12,36,98,12,70};
		
		for(int j=1;j<a.length;j++)
		{
			for(int i=1;i<a.length;i++)
			{
				if(a[i-1]>a[i])
				{
					int temp = a[i];
					a[i] = a[i-1];
					a[i-1] = temp;
				}
			}
			
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
}
