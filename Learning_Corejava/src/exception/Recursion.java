package exception;

class Calc
{
	public void square(int i)
	{
		
		System.out.println(i*i);
		i++;
		if(i<20)
		{
			square(i);
		}
	}
}

public class Recursion {
	public static void main(String[] args) {
		
		
		Calc c = new Calc();
		c.square(10);
		
		
	}
}
