package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class C002_ArraylistDemo {
	public static void main(String[] args) {
		
		
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(10);
		al1.add(20);
		al1.add(30);
		
		
		ArrayList<Integer> al2 = new ArrayList<Integer>(al1);
		al2.add(100);
		al2.add(200);
		al2.add(300);
		al2.addAll(al1);
		al2.removeAll(al1);
		
//		for(int i : al2)
//		{
//			System.out.println(i);
//		}
		
		
		Iterator<Integer> itr = al2.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
