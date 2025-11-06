package fileio;

import java.io.Serializable;

public class Student implements Serializable {
		
	int id=11;
	String name="test";
	transient String email="test@gmail.com";
	
	public void display()
	{
		System.out.println(id+" "+name+" "+email);
	}
}
