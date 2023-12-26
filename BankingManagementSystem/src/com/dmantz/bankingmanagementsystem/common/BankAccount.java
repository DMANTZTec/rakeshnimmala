package com.dmantz.bankingmanagementsystem.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class BankAccount {

	private int accountnumber;
	private String holderName;
	private int mobileNumber;
	private int adharnumber;
	private int currentBalance;
	private List<TransactionHistory> listOfTransactionHistory;

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAdharnumber() {
		return adharnumber;
	}

	public void setAdharnumber(int adharnumber) {
		this.adharnumber = adharnumber;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<TransactionHistory> getListOfTransactionHistory() {
		return listOfTransactionHistory;
	}

	public void setListOfTransactionHistory(List<TransactionHistory> listOfTransactionHistory) {
		this.listOfTransactionHistory = listOfTransactionHistory;
	}

	public BankAccount deposite(int accountNumber, int amount) {

		BankAccount bank = new BankAccount();

		try {
			Connection connection = getConnection();

			PreparedStatement statement = connection
					.prepareStatement("insert into transaction_history(transactionType,accountNumber,lastUpdatedTime,currentBalance,ammount) \r\n"
							+ "values(?,?,?,?,?)");

			TransactionHistory trans = getTransactionDetaile(accountNumber);

			String transactionType = "Credited";
			int currentBalance = trans.getCurrentBalance() + amount;

			statement.setString(1, transactionType);
			statement.setInt(2, accountNumber);

			statement.setDate(3, new java.sql.Date(new Date().getTime()));
			statement.setInt(4, currentBalance);
			statement.setInt(5, amount);

			statement.executeUpdate();
			System.out.println("Successfully Credited");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return bank;

	}

	public BankAccount withdraw(int accountNumber, int amount) {
		BankAccount bank = new BankAccount();

		try {
			Connection connection = getConnection();

			PreparedStatement statement = connection
					.prepareStatement("insert into transaction_history(transactionType,accountNumber,lastUpdatedTime,currentBalance,ammount) \r\n"
							+ "values(?,?,?,?,?)");

			TransactionHistory trans = getTransactionDetaile(accountNumber);

			String transactionType = "Debited";
			int currentBalance = trans.getCurrentBalance() - amount;

			statement.setString(1, transactionType);
			statement.setInt(2, accountNumber);

			statement.setDate(3, new java.sql.Date(new Date().getTime()));
			statement.setInt(4, currentBalance);
			statement.setInt(5, amount);

			statement.executeUpdate();
			System.out.println("Successfully Debited");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return bank;

	}
	
	public BankAccount transfer(int fromAccountNumber,int toAccountNumber,int amount) {
		BankAccount bank=new BankAccount();
		try {
			Connection connection=getConnection();


			PreparedStatement statement = connection
					.prepareStatement("insert into transaction_history(transactionType,accountNumber,lastUpdatedTime,currentBalance,ammount) \r\n"
							+ "values(?,?,?,?,?)");

			TransactionHistory trans = getTransactionDetaile(fromAccountNumber);

			String transactionType = "Debited";
			int currentBalance = trans.getCurrentBalance() - amount;

			statement.setString(1, transactionType);
			statement.setInt(2, fromAccountNumber);

			statement.setDate(3, new java.sql.Date(new Date().getTime()));
			statement.setInt(4, currentBalance);
			statement.setInt(5, amount);

			statement.executeUpdate();
			
		
			
			

				PreparedStatement statement1 = connection
						.prepareStatement("insert into transaction_history(transactionType,accountNumber,lastUpdatedTime,currentBalance,ammount) \r\n"
								+ "values(?,?,?,?,?)");
				
				TransactionHistory trans1 = getTransactionDetaile(toAccountNumber);



				String transactionType1 = "Credited";
				int currentBalance1 = trans1.getCurrentBalance() + amount;

				statement.setString(1, transactionType1);
				statement.setInt(2, toAccountNumber);

				statement.setDate(3, new java.sql.Date(new Date().getTime()));
				statement.setInt(4, currentBalance1);
				statement.setInt(5, amount);

				statement.executeUpdate();
				System.out.println("Successfully Transfered");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bank;
		
			
	}

	public TransactionHistory getTransactionDetaile(int accountNumber) throws SQLException {
		TransactionHistory th = new TransactionHistory();

		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from transaction_history where accountNumber=? and\r\n"
				+ " transactionId =(select max(transactionId) from transaction_history)");
		statement.setInt(1, accountNumber);
		ResultSet rst = statement.executeQuery();

		while (rst.next()) {

			th.setTransactionId(rst.getInt("transactionId"));
			th.setAccountNumber(rst.getInt("accountNumber"));
			th.setCurrentBalance(rst.getInt("currentBalance"));
			th.setLastUpdatedTime(rst.getDate("lastUpdatedTime"));
			th.setTransactionType(rst.getString("transactionType"));
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
