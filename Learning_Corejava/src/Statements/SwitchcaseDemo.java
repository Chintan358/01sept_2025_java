package Statements;

import java.util.Scanner;

public class SwitchcaseDemo {
	public static void main(String[] args) {

		int choice = 0;
		do {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter choice : ");
		choice = sc.nextInt();

		switch (choice) {
		case 0 : 
			System.out.println("Exit");
			break;
		case 1:
			System.out.println("Gujarati");
			break;
		case 2:
			System.out.println("Hindi");
			break;
		case 3:
			System.out.println("English");
			break;
		default:
			System.out.println("Invalid input");
		}
		}while(choice!=0);

	}
}
