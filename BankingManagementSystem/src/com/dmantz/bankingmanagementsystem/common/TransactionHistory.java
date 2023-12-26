package com.dmantz.bankingmanagementsystem.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionHistory {

	private int transactionId;
	private String transactionType;
	private int accountNumber;
	private Date lastUpdatedTime;
	private int currentBalance;
	private int amount;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date date) {
		this.lastUpdatedTime = date;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", accountNumber=" + accountNumber + ", lastUpdatedTime=" + lastUpdatedTime + ", currentBalance="
				+ currentBalance + ", amount=" + amount + "]";
	}

	public TransactionHistory getAllTransactionHistory() {
		TransactionHistory th=new TransactionHistory();
		
		try {
			Connection connection=getConnection();
			
			

			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from transaction_history");
			
			while(result.next()) {
				th.setTransactionId(result.getInt("transactionId"));
			th.setTransactionType(	result.getString("transactionType"));
				th.setAccountNumber(result.getInt("accountNumber"));
			th.setLastUpdatedTime(	result.getDate("lastUpdatedTime"));
			th.setCurrentBalance(result.getInt("currentBalance"));	
			th.setAmount(result.getInt("ammount"));	
			System.out.println(th.getTransactionId()+" "+th.getTransactionType()+" "+th.getAccountNumber()+" "+
			th.getLastUpdatedTime()+" "+th.getCurrentBalance()+" "+th.getAmount());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return th;
	}
	
	public TransactionHistory getTransactionDetailsById(int id) {
TransactionHistory th=new TransactionHistory();
		
		try {
			Connection connection=getConnection();
			
			

			PreparedStatement statement=connection.prepareStatement("select * from transaction_history where accountNumber=?");
			statement.setInt(1, id);
			ResultSet result=statement.executeQuery();
			
			while(result.next()) {
				th.setTransactionId(result.getInt("transactionId"));
			th.setTransactionType(	result.getString("transactionType"));
				th.setAccountNumber(result.getInt("accountNumber"));
			th.setLastUpdatedTime(	result.getDate("lastUpdatedTime"));
			th.setCurrentBalance(result.getInt("currentBalance"));	
			th.setAmount(result.getInt("ammount"));	
			System.out.println(th.getTransactionId()+" "+th.getTransactionType()+" "+th.getAccountNumber()+" "+
			th.getLastUpdatedTime()+" "+th.getCurrentBalance()+" "+th.getAmount());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return th;
	}
	
	public TransactionHistory getTransactionHistoryByType(String type) {
		
TransactionHistory th=new TransactionHistory();
		
		try {
			Connection connection=getConnection();
			
			

			PreparedStatement statement=connection.prepareStatement("select * from transaction_history where transactionType=?");
			statement.setString(1, type);
			ResultSet result=statement.executeQuery();
			
			while(result.next()) {
				th.setTransactionId(result.getInt("transactionId"));
			th.setTransactionType(	result.getString("transactionType"));
				th.setAccountNumber(result.getInt("accountNumber"));
			th.setLastUpdatedTime(	result.getDate("lastUpdatedTime"));
			th.setCurrentBalance(result.getInt("currentBalance"));	
			th.setAmount(result.getInt("ammount"));	
			System.out.println(th.getTransactionId()+" "+th.getTransactionType()+" "+th.getAccountNumber()+" "+
			th.getLastUpdatedTime()+" "+th.getCurrentBalance()+" "+th.getAmount());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return th;
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
