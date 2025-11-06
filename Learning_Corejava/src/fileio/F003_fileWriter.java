package fileio;

import java.io.FileWriter;
import java.io.IOException;

public class F003_fileWriter {
	public static void main(String[] args) {
		
		FileWriter fw  =null;
		
		try {
			fw = new FileWriter("D:\\files\\home.txt");
			
			String str = "Hello java, Hello tops";
			fw.write(str);
			fw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
