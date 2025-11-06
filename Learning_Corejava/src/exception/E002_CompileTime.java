package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class Demo
{
	public void test() throws FileNotFoundException
	{
//		try {
//			FileOutputStream fos = 
//					new FileOutputStream("D://test.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
		
		
		FileOutputStream fos = new FileOutputStream("D://test.txt");
	}
}
public class E002_CompileTime {
	public static void main(String[] args) {
		
		
		
		Demo d = new Demo();
		try {
			d.test();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
}
