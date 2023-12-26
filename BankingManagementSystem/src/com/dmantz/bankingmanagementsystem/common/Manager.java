package com.dmantz.bankingmanagementsystem.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Manager {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Manager addAccount(int accountnumber, String holderName,int mobileNumber,int adharnumber, int currentBalance)
 {
		Manager manager=new Manager();
		try {
			Connection connection=getConnection();

			PreparedStatement statement=connection.prepareStatement("insert into bankAccount values(?,?,?,?,?)");
			
			statement.setInt(1,accountnumber);
			statement.setString(2, holderName);
			statement.setInt(3, mobileNumber);
			statement.setInt(4, adharnumber);
			statement.setInt(5, currentBalance);
			
			statement.executeUpdate();
			System.out.println("Bank Account Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;
		
	}
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/BankingManagementSystem", "root",
					"Rakesh@1999");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getConnection();
	}
	

}
