
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.nucleus.dao.CustomerDao;
import com.nucleus.dao.CustomerRDBMSDaoImpl;
import com.nucleus.entity.Customer;
import com.nucleus.validation.ValidationMethods;

public class FileuploadDemo {
	int flag =0;
	ArrayList<Customer> list=new ArrayList<>();
	ValidationMethods validationmethods = new ValidationMethods();
	public void readdata()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the File :");
		String filepath = sc.next();
		try {
			
			
			File file = new File(filepath);
			FileReader filereader = new FileReader(file);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			try {
				String str = bufferedreader.readLine();
			while(str!=null)
				{
				System.out.println(str);
				Customer c=new Customer();
				String[] strarr = str.split("~",16);
			if(strarr[0].isEmpty())
			{
				c.setCustomercode(null);
			}
			else
			{
				c.setCustomercode(strarr[0]);
				
			}
			if(strarr[1].isEmpty())
			{
				
				c.setCustomername(null);
			}
			else
			{
				//c.setCustomername(strarr[1]);
				boolean b = validationmethods.CheckCustomerName(strarr[1]);
				if(b==false)
				{
					c.setCustomername(strarr[1]);
				}
				else
				{
					flag =1;
					System.out.println(flag);
				}
				
			}
			if(strarr[2].isEmpty())
			{
				c.setAddress1(null);
			}
			else
			{
				c.setAddress1(strarr[2]);
			}
			if(strarr[3].isEmpty())
			{
				c.setAddress2(null);
			}
			else
			{
				c.setAddress2(strarr[3]);
			}
			if(strarr[4].isEmpty())
			{
				c.setCustomerpincode(0);
			}
			else
			{
				boolean b = validationmethods.CheckPincode(strarr[4]);
				if(b==false)
				{
					c.setCustomerpincode(Integer.parseInt(strarr[4]));
				}
				else
				{
					flag =1;
				}
			}
			
			if(strarr[5].isEmpty())
			{
				c.setEmailaddress(null);
				
			}
			else
			{
				boolean b = validationmethods.CheckEmailAddress(strarr[5]);	
				if(b==true)
				{
					c.setEmailaddress(strarr[5]);	
				}
				else
				{
					flag =1;
				}
			}

			if(strarr[6].isEmpty())
			{
				
				c.setContactno(0);
			}
			else
			{
				c.setContactno(Long.parseLong(strarr[6]));
				
			}
			if(strarr[7].isEmpty())
			{
				
				c.setPrimary_contact_person(null);
				
			}
			else
			{
				c.setPrimary_contact_person(strarr[7]);
				
			}
			if(strarr[8].isEmpty())
			{
				
				c.setRecord_status(null);
				
			}
			else
			{

				boolean b = validationmethods.CheckRecordStatus(strarr[8]);	
				if(b==true)
				{
					c.setRecord_status(strarr[8]);	
				}
				else
				{
					flag =1;
				}
				
				
				
			}
			
			
			if(strarr[9].isEmpty())
			{
				
				c.setActive_inactive_flag(null);
			}
			else
			{
				boolean b = validationmethods.CheckFlag(strarr[9]);	
				if(b==true)
				{
					c.setActive_inactive_flag(strarr[9]);
					
				}
				else
				{
					flag =1;
				}
				
			}
			
			if(strarr[10].isEmpty())
			{
				
				c.setCreate_date(null);
			}
			else
			{
				try {
					c.setCreate_date(new SimpleDateFormat("dd/MMM/yyyy").parse(strarr[10]));
				} catch (ParseException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(strarr[11].isEmpty())
			{
				
				c.setCreated_by(null);
			}
			else
			{
				
				c.setCreated_by(strarr[11]);
			}
			if(strarr[12].isEmpty())
			{
				
				c.setModified_date(null);
			}
			else
			{
				try {
					c.setModified_date(new SimpleDateFormat("dd/MMM/yyyy").parse(strarr[12]));
				} catch (ParseException e) {
					
						e.printStackTrace();
					}

				
			}
			if(strarr[13].isEmpty())
			{
				
				c.setModified_by(null);
			}
			else
			{
				c.setModified_by(strarr[13]);
				
			}
			if(strarr[14].isEmpty())
			{
				c.setAuthorized_date(null);
			}
			else
			{
				
				try {
					c.setAuthorized_date(new SimpleDateFormat("dd/MMM/yyyy").parse(strarr[14]));
				} catch (ParseException e) {
						
						e.printStackTrace();
					}
				
				
			}
		
			if(strarr[15].isEmpty())
			{
				c.setAuthorized_by(null);			
			}
			else
			{
				c.setAuthorized_by(strarr[15]);	
				
			}
		if(flag ==1)
		{
			System.out.println("call");
			ErrorLog errorlog = new ErrorLog();
			errorlog.savedata(c);
			
		}
		else
		{
		
		          list.add(c);
		}
		         
		   System.out.println(c.toString());
		   str = bufferedreader.readLine();
			
				}
			 
		    CustomerDao customerdao = new CustomerRDBMSDaoImpl();
			try {
				
				//System.out.println("pppp");
				customerdao.insert(list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
							
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fileupload fileupload  = new Fileupload();
		fileupload.readdata();
		
		
		
	}

}
