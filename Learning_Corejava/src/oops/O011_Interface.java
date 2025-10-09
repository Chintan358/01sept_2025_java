package oops;

interface I1
{
	public static final int a = 10;
	 void display();
}

interface I2
{
	public void display();
}

class InterImpl implements I1,I2
{

	@Override
	public void display() {
		System.out.println("display calling");
	}
	
}

public class O011_Interface {
	public static void main(String[] args) {
		
		InterImpl i = new InterImpl();
		i.display();
		
		
	}
}
