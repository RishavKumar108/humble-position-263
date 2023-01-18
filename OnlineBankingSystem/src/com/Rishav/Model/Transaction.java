package com.Rishav.Model;

import java.security.Timestamp;

public class Transaction {
	
	private int Transaction_Id;
	private String  SenderName;
	private String RecieverName;
	private int Balance;
	private Timestamp transaction_time;
	
	public Transaction() {}

	public Transaction(int transaction_Id, String senderName, String recieverName, int balance,
			Timestamp transaction_time) {
		super();
		Transaction_Id = transaction_Id;
		SenderName = senderName;
		RecieverName = recieverName;
		Balance = balance;
		this.transaction_time = transaction_time;
	}

	public int getTransaction_Id() {
		return Transaction_Id;
	}

	public void setTransaction_Id(int transaction_Id) {
		Transaction_Id = transaction_Id;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getRecieverName() {
		return RecieverName;
	}

	public void setRecieverName(String recieverName) {
		RecieverName = recieverName;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public Timestamp getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Timestamp transaction_time) {
		this.transaction_time = transaction_time;
	}

	@Override
	public String toString() {
		return "Transaction [Transaction_Id=" + Transaction_Id + ", SenderName=" + SenderName + ", RecieverName="
				+ RecieverName + ", Balance=" + Balance + ", transaction_time=" + transaction_time + "]";
	};
	
	
}
