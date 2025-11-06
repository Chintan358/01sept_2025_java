package impclasses;

class A
{
	int id = 10;
	
	@Override
	public String toString() {
		
		return "Hello"+id;
	}
}


public class I006_ObjectDemo {
	public static void main(String[] args) {
		
		
		A a = new A();
		//System.out.println(a.getClass());
		
		System.out.println(a);
		
		
	}
}
