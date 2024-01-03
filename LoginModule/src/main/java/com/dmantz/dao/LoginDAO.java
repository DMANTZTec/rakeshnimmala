package com.dmantz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	
	public boolean check(String username,String password) throws ClassNotFoundException, SQLException  {
		
		
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/demo";

			String username1 = "root";
			String password1 = "Rakesh@1999";
			Connection connection = DriverManager.getConnection(jdbcUrl, username1, password1);
		PreparedStatement statement=connection.prepareStatement("select * from login where uname=? and password=?");
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs=statement.executeQuery();
		
		while(rs.next()) {
			
			return true; 
			
		}
		return false;

		
		
	}

}
