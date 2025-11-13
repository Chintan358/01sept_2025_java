package collection;

import java.util.Comparator;

public class SortById implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		int currentId = o2.id;
		int newId = o1.id;	
		int i=0;
		if(newId>currentId)
		{
			i = 1;
		}
		else if(newId<currentId)
		{
			i = -1;
		}
		else
		{
			i=0;
		}
		return i;
	}

}
