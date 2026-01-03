package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	
	Connection cn = null;
	public UserDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int addUser(User user) {
		
		int i=0;
		try {
			PreparedStatement ps = 
					cn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPass());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getLang());
			ps.setString(7, user.getCountry());
			ps.setString(8, user.getAddress());
			
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	
	public boolean isEmailExist(String email)
	{
		boolean b = false;
		try {
			PreparedStatement ps = 
					cn.prepareStatement("select * from user where email=?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public User loginCheck(User u) {
		
		User user = null;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user where email=? and pass=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPass());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setLang(rs.getString(6));
				user.setCountry(rs.getString(7));
				user.setAddress(rs.getString(8));
				
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
