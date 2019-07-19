package com.nucleus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nucleus.connection.Connectionclass;
import com.nucleus.entity.Customer;

public class CustomerRDBMSDaoImpl implements CustomerDao {
	Connectionclass connectionclass = new Connectionclass();
	Connection con = connectionclass.getDBConnection();

	@Override
	public void insert(ArrayList<Customer>customer) throws SQLException {
		for(int i =0;i<customer.size();i++)
		{
			//System.out.println("pppp");
		PreparedStatement preparedstmt = con.prepareStatement("insert into customer_priya (customer_code,customer_name,customer_address1,customer_address2,customer_pin_code,email_address,contact_number ,primary_contact_person,record_status,active_inactive_flag,create_date,created_by,modified_date, modified_by,authorized_date,authorized_by) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedstmt.setString(1,customer.get(i).getCustomercode());
		//System.out.println(customer.get(i).getCustomercode());
		preparedstmt.setString(2, customer.get(i).getCustomername());
		preparedstmt.setString(3, customer.get(i).getAddress1());
		preparedstmt.setString(4, customer.get(i).getAddress2());
		preparedstmt.setInt(5, customer.get(i).getCustomerpincode());
		preparedstmt.setString(6, customer.get(i).getEmailaddress());
		preparedstmt.setLong(7, customer.get(i).getContactno());
		preparedstmt.setString(8, customer.get(i).getPrimary_contact_person());
		preparedstmt.setString(9, customer.get(i).getRecord_status());
		preparedstmt.setString(10, customer.get(i).getActive_inactive_flag());
		java.util.Date date = customer.get(i).getCreate_date();
		if(date!=null)
		{
		java.sql.Date dt = new java.sql.Date(date.getTime());
		preparedstmt.setDate(11, dt);
		}
		else
		{
			preparedstmt.setDate(11,(Date) date);
		}
	
		preparedstmt.setString(12, customer.get(i).getCreated_by());
		
		java.util.Date date2 = customer.get(i).getModified_date();
		if(date2!=null)
		{
		java.sql.Date dt1 = new java.sql.Date(date2.getTime());
		preparedstmt.setDate(13, dt1);
		}
		else
		{
			preparedstmt.setDate(13,(Date) date2);
		}
		//java.sql.Date dt2 = new java.sql.Date(date2.getTime());
		
		//preparedstmt.setDate(13, (Date) date2);
		//System.out.println("ppoo");
		preparedstmt.setString(14, customer.get(i).getModified_by());
		//System.out.println("uyyt");
		
		java.util.Date date3 = customer.get(i).getAuthorized_date();
		if(date3!=null)
		{
		java.sql.Date dt2 = new java.sql.Date(date3.getTime());
		preparedstmt.setDate(15, dt2);
		}
		else
		{
			preparedstmt.setDate(15,(Date) date3);
		}
		//java.sql.Date dt3 = new java.sql.Date(date3.getTime());
		//preparedstmt.setDate(15, (Date) date3);
		//System.out.println("qqqq");
		preparedstmt.setString(16, customer.get(i).getAuthorized_by());
		//System.out.println("qqqq");
		preparedstmt.executeUpdate();
		
		
		}
		System.out.println("Record Inserted");
		connectionclass.closeDBConnection();
		
	}

}
