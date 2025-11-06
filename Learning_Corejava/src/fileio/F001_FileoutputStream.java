package fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class F001_FileoutputStream {
	public static void main(String[] args) {
		
		
		FileOutputStream fos=null;
		try 
		{
			 fos = new FileOutputStream("D:\\files\\text.txt");
			
			String str = "This is my first io practical";
			byte b[] = str.getBytes();
			fos.write(b);
			System.out.println("Done");		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
