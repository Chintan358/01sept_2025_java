package fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) {
		
		
		Student st = new Student();
		
		
		
		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		try {
			
			fos = new FileOutputStream("D://files//demo.ser");
			os = new ObjectOutputStream(fos);
			
			os.writeObject(st);
			
			System.out.println("done");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
