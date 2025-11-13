package collection;

import java.util.Enumeration;
import java.util.Vector;

public class C007_VctorDemo {
	public static void main(String[] args) {
		
		
		Vector<Integer> v = new Vector<Integer>();
		v.addElement(10);
		v.addElement(20);
		v.addElement(30);
		
		Enumeration<Integer> en = v.elements();
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}
