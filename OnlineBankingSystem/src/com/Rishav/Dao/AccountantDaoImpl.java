package com.Rishav.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Rishav.Exceptions.AccountantException;
import com.Rishav.Exceptions.CustomerException;
import com.Rishav.Exceptions.TransactionException;
import com.Rishav.Model.Customer;
import com.Rishav.Model.Transaction;
import com.Rishav.Utility.DBUtil;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public boolean AccountantLogin(String email, int Password) throws AccountantException {
		boolean t = false;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Accountant where email=? and Password=?");
			ps.setString(1, email);
			ps.setInt(2, Password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				t = true;
			}

		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());

		}

		return t;
	}

	@Override
	public int AddCustomer(String name, String email, int password, int AccoNo, int balance)
			throws CustomerException {

		int i = 0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into Customer (name,email,password,AccountNo,balance) values(?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, password);
			ps.setInt(4, AccoNo);
			ps.setInt(5, balance);
			int x = ps.executeUpdate();

			if (x > 0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return i;
	}

	@Override
	public int UpdateExistingCustomer(String name, String email, int password, int AccountNo, int Balance,
			int Customer_Id) throws CustomerException {
	
		int i = 0;
		
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"Update Customer set name = ? , email = ?,Password=?,AccountNo=?,Balance=? Customer_Id = ?");
			//name, email, Password, AccountNo, Amount, id

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, password);
			ps.setInt(4, AccountNo);
			ps.setInt(5, Balance);
			ps.setInt(6, Customer_Id);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
			
		}

		return i;
	}

	@Override
	public int RemoveCustomer(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub
		int i=0;
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("delete from Customer where AccountNo=?");
			
			ps.setInt(1,AccountNo);
			int x= ps.executeUpdate();
			
			if(x>0) {
				i++;
			}	
		}
		catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return i;
	}

	@Override
	public int VeiwParticularAccount(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub

		int i=0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where AccountNo=?");
			ps.setInt(1,AccountNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				i++;
				System.out.println("Customer_Id is "+rs.getInt("Customer_Id")
				+", name is : " + rs.getString("name") 
				+", Email is : " + rs.getString("email")
				+", password is : "+ rs.getString("password")
				+", AccountNo is : "+ rs.getInt("AccountNo") 
				+", Balance is : "+ rs.getInt("Balance"));
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return i;
	}

	@Override
	public List<Customer> AllCustomerDetail() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> detail = new ArrayList<>();
		try (Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from customer");
			ResultSet rs= ps.executeQuery();
			
				while(rs.next()) {
					int cid=rs.getInt("Customer_Id");
					String name=rs.getString("name");
					String username=rs.getString("email");
					int password=rs.getInt("password");
					int balance=rs.getInt("Balance");
					int AccountNo=rs.getInt("AccountNo");
					Customer cust=new Customer(cid,name,username,password,AccountNo, balance);
					detail.add(cust);
				}
		} 
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return detail;
	}

	@Override
	public List<Transaction> TransactionList() throws TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> transaction = new ArrayList<>();
		try (Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from Transaction");
			ResultSet rs= ps.executeQuery();
			
			 while(rs.next()) {
					int tid=rs.getInt("Transaction_Id");
					String Sender=rs.getString("SenderName");
					String Receiver=rs.getString("RecieverName");
					int Amount=rs.getInt("Balance");
					String date=rs.getString("date");
					
					Transaction trans=new Transaction(tid, Sender, Receiver, Amount, date);
					transaction.add(trans);
				}
		} 
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return transaction;
	}

	

}



