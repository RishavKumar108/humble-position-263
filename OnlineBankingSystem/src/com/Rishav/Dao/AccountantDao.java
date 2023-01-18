package com.Rishav.Dao;

import java.util.List;

import com.Rishav.Exceptions.AccountantException;
import com.Rishav.Exceptions.CustomerException;
import com.Rishav.Model.Accountant;
import com.Rishav.Model.Customer;
import com.Rishav.Model.Transaction;

public interface AccountantDao {

	public boolean AccountantLogin(String email,int password) throws AccountantException;

	
	public int AddCustomer(Customer customer) throws CustomerException;
	
	
	public int UpdateExistingCustomer(String name,String email,int password,int AccountNo,int balance,int Customer_Id) throws CustomerException;
	
	
	
	
//	public int delectCustomer(int AccountNo) throws CustomerException;
//	public int veiwParticularAccount(int AccountNo) throws CustomerException;
//	public List<Customer> veiwAllCustomer() throws CustomerException;
//	public List<Transaction> takeCare() throws TransacationException;
	
}
