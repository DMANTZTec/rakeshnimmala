package com.dmantz.bankingmanagementsystem.test;

import com.dmantz.bankingmanagementsystem.common.BankAccount;
import com.dmantz.bankingmanagementsystem.common.Manager;
import com.dmantz.bankingmanagementsystem.common.TransactionHistory;

public class BankingMain {
	public static void main(String[] args) {
		BankAccount ba=new BankAccount();
		//ba.deposite(2, 1500);
		//ba.withdraw(2, 200);
	//	ba.transfer(1, 2, 1000);
		
		TransactionHistory th=new TransactionHistory();
		//th.getAllTransactionHistory();
		//th.getTransactionDetailsById(1);
	//-------------------------------------------------------------------------------------------------	th.getTransactionHistoryByType("debited");
		 
		Manager manager=new Manager();
		manager.addAccount(4, "Ashwini", 1789354504, 223355668, 1000);
	}

}
