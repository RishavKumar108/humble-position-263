package com.Rishav.Dao;

import java.util.List;

import com.Rishav.Exceptions.AccountantException;
import com.Rishav.Exceptions.CustomerException;
import com.Rishav.Exceptions.TransactionException;
import com.Rishav.Model.Accountant;
import com.Rishav.Model.Customer;
import com.Rishav.Model.Transaction;

public interface AccountantDao {

	//Login using his/her email and password
	public boolean AccountantLogin(String Username,int Password ) throws AccountantException;

	//Adding new account for customer
	public int AddCustomer(String name,String username, int password,int AccoNo,int Amount) throws CustomerException;
	
	//Editing already available account
	public int UpdateExistingCustomer(String name,String email, int password,int AccountNo,int Balance, int Customer_Id)  throws CustomerException;
	
	//Removing the account by using account number
	public int RemoveCustomer(int AccountNo) throws CustomerException;

	//Viewing particular account details by giving account number
	public int VeiwParticularAccount(int AccountNo) throws CustomerException;

    //Viewing all the account details
	public List<Customer> AllCustomerDetail() throws CustomerException;
	
	//Taking care of deposit and withdrawal operations
	public List<Transaction> TransactionList() throws TransactionException;



}
