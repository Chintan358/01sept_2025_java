package Library;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryOpration {
	
	Connection cn = null;
	public LibraryOpration() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root"); 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	Scanner sc = new Scanner(System.in);
	public void addBook()
	{
		System.out.println("enter Book name");
		String name = sc.next();
		System.out.println("enter Qty : ");
		int qty = sc.nextInt();
		
		try {
			
			PreparedStatement ps1 = cn.prepareStatement("select * from book where name=?");
			ps1.setString(1, name);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				System.out.println("Book already exist !!!");
			}
			else {
				PreparedStatement ps = 
						cn.prepareStatement("insert into book values(?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, name);
				ps.setInt(3, qty);
				
				int i = ps.executeUpdate();
				if(i>0)
				{
					System.out.println("Book inserted !!!!");
				}
			}
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void viewBook()
	{
		try {
			PreparedStatement ps = cn.prepareStatement("select * from book");
			ResultSet rs  =ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteBook()
	{
		System.out.println("Enter book name");
		String name = sc.next();
		try {
			PreparedStatement ps = cn.prepareStatement("delete from book where name=?");
			ps.setString(1, name);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Book deleted");
			}
			else
			{
				System.out.println("Book not found");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Book not found");
		}
	}
	
	
	public void issueBook()
	{
		System.out.println("Enter book name");
		String name = sc.next();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from book where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int qty = rs.getInt(3);
				if(qty<=0)
				{
					System.out.println("Book is not available at the moment !!!!");
				}
				else
				{
					qty--;
					PreparedStatement ps1 = cn.prepareStatement("update book set qty=? where name=?");
					ps1.setInt(1, qty);
					ps1.setString(2, name);
					int i = ps1.executeUpdate();
					if(i>0)
					{
						System.out.println("Book issued !!!");
					}
					
				}
			}
			else
			{
				System.out.println("Book not available !!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
