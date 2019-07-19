package com.nucleus.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.nucleus.entity.Customer;

public interface CustomerDao {

	
	public void insert(ArrayList<Customer> list) throws SQLException;
}
