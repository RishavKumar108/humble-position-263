package com.Rishav.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Rishav.Exceptions.AccountantException;
import com.Rishav.Exceptions.CustomerException;
import com.Rishav.Model.Accountant;
import com.Rishav.Model.Customer;
import com.Rishav.Utility.DBUtil;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public boolean AccountantLogin(String email, int password) throws AccountantException {
		
		boolean flag = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("select * from Accountant where email = ? and password = ?");
		
		    ps.setString(1, email);
		    ps.setInt(2, password);
		    
		    ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			
		}catch(SQLException e) {
			throw new AccountantException(e.getMessage());
		}
		

		return flag;
	}

	@Override
	public int AddCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateExistingCustomer(String name, String email, int password, int AccountNo, int balance,
			int Customer_Id) throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}


}
