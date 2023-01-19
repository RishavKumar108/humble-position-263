//package com.Rishav.Dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.Rishav.Exceptions.AccountantException;
//import com.Rishav.Exceptions.CustomerException;
//import com.Rishav.Model.Accountant;
//import com.Rishav.Model.Customer;
//import com.Rishav.Utility.DBUtil;
//
//public class AccountantDaoImpl implements AccountantDao{
//
//	@Override
//	public Accountant AccountantLogin(String email, String password) throws AccountantException {
//		Accountant acc = null;
//
//		try (Connection conn = DBUtil.provideConnection()){
//			  PreparedStatement ps=  conn.prepareStatement("select * from student where email=? AND password=?");
//			  ps.setString(1, email);
//			  ps.setString(2, password);
//			  
//			  ResultSet rs = ps.executeQuery();
//			  
//			  if(rs.next()) {
//				  
//				  acc = new Accountant();
//				  
//				  acc.setAcc_Id(rs.getInt("Acc_Id"));
//				  acc.setName(rs.getString("name"));
//				  acc.setEmail(rs.getString("email"));
//				  acc.setPassword(rs.getString("password"));
//
//			  }else
//				  throw new AccountantException("Invalid Username or password");
//			  
//			  
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new AccountantException(e.getMessage());
//		}
//		
//		return acc;
//	}
//
//	@Override
//	public String AddCustomer(Customer customer) throws CustomerException {
//         String response ="Not Registered..";
//		
//		try (Connection conn = DBUtil.provideConnection()){
//			
//	    PreparedStatement ps =  conn.prepareStatement("insert into Customer (name,email,password,AccountNo,Balance)  values(?,?,?,?,?)");
//		ps.setString(1, customer.getName());
//		ps.setString(2, customer.getEmail());
//		ps.setString(3, customer.getPassword());
//		ps.setInt(4, customer.getAccountNo());
//		ps.setInt(5, customer.getBalance());
//		
//        int row = ps.executeUpdate();
//		if(row>0)
//			response =customer.getName()+", Customer is successfully registered.";
//		
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new CustomerException(e.getMessage());
//			
//		}
//		
//		return response;
//	}
//}
//
//
