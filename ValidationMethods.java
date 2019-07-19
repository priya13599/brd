package com.nucleus.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nucleus.entity.Customer;

public class ValidationMethods {

	Customer c=new Customer();
	public boolean CheckCustomerName(String customername)
	{ int flag =0;
	String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
		//System.out.println(customername);
		/*Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = pattern.matcher(customername);
		boolean b = m.find();
		if(b==true)
		{
			
		}
		else
			
		{
			c.setCustomername(customername);
		}*/
		
	String str1[] = specialCharacters.split("");
	   String str2[]=customername.split("[ ]+");
	   for(int k =0;k<str2.length;k++)
	   {
	   String str3[] = str2[k].split("");
	   

	    for (int i=0;i<str3.length;i++)
	    {
	    	for(int j=0;j<str1.length;j++)
	    	{
	    if (str1[j].contains(str3[i]))
	    {
	    	flag =1;
	    	break;
	    }
	    
	    }
	    }
	   }
	
		if(flag ==1)
		{
			return true;
		}
		else
		
			return false;
		
		
	
	}
	
	
	public boolean CheckPincode(String pincode)
	{
		int flag =0;
		String str[] = pincode.split("");
		if(str.length!=6)
		{
			flag =1;
		}
		
		if(flag ==1)
		{
			return true;
		}
		else
		
			return false;
		
	}
	
	public boolean CheckEmailAddress(String email)
	{
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = pattern.matcher(email);
		boolean b = m.find();
		if(b==true)
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean CheckRecordStatus(String status)
	{ boolean b=false;
		if(status.equals("N")||status.equals("M")||status.equals("D")||status.equals("A")||status.equals("R"))
		{
			b=true;
		}
		
		if(b==true)
		{
			return true;
		}
		else
			return false;
	}
	public boolean CheckFlag(String flag)
	{ boolean b=false;
		if(flag.equals("A")||flag.equals("I"))
		{
			b=true;
		}
		
		if(b==true)
		{
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		 
		ValidationMethods validationMethods = new ValidationMethods();
		//boolean b = validationMethods.CheckCustomerName("Nsbt%  pvt   Ltd");
		//boolean b = validationMethods.CheckPincode("20130777");
		//boolean b = validationMethods.CheckEmailAddress("nsbt@nucleussoftware.com");
		boolean b = validationMethods.CheckFlag("I");
		System.out.println(b);
		
	}
	
}
