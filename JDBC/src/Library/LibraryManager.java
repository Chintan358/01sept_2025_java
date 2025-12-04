package Library;

import java.util.Scanner;

public class LibraryManager {
	public static void main(String[] args) {
		
		int choice=0;
		do {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Operation : ");
		System.out.println("1 : Add Book");
		System.out.println("2 : View Book");
		System.out.println("3 : Delete Book");
		System.out.println("4 : IssueBook");
		System.out.println("0 : Exit");
		choice = sc.nextInt();
		
		LibraryOpration lp = new LibraryOpration();
		if(choice==1)
		{
			System.out.println("*****ADD BOOK*****");
			lp.addBook();
			
		}
		else if(choice==2)
		{
			System.out.println("*****VIEW BOOK*****");
			lp.viewBook();
		}
		else if(choice==3)
		{
			System.out.println("*****DELETE BOOK*****");
			lp.deleteBook();
		}
		else if(choice==4)
		{
			System.out.println("*****ISSUE BOOK*****");
			lp.issueBook();
		}
		else if(choice==0)
		{
			System.out.println("***** THANK YOU*****");
		}
		else
		{
			System.out.println("Invalid Choice");
		}
		}while(choice!=0);
		
	}
}
