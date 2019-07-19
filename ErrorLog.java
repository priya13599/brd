import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.nucleus.entity.Customer;

public class ErrorLog {
	
	
	public void savedata(Customer customer)
	{
		
		
		try {
			FileWriter filewriter = new FileWriter("file1.txt",true);
			//BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			//bufferedwriter.write(string);
			//bufferedwriter.close();
			PrintWriter printwriter = new PrintWriter(filewriter);
			printwriter.println(customer.toString());
			printwriter.close();
			
			filewriter.close();
			System.out.println("Data Writtern in file in Error Log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
