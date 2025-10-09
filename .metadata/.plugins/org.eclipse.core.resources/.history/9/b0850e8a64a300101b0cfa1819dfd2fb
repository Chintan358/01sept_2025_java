package oops;


abstract class Abs
{
	public abstract void display();
	
	public void show()
	{
		System.out.println("runing show...");
	}
}

class AbsImpl extends Abs
{
	@Override
	public void display() {
		System.out.println("display calling...");
	}	
}

public class O010_abstractDemo {
	public static void main(String[] args) {
		
//		Abs abs = new Abs();
		AbsImpl abs = new AbsImpl();
		abs.display();
		abs.show();
	}
}
