package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CustomerList {
	
	public ArrayList<Customer> setCustomerList(ArrayList<Customer> customerList,Customer customer) {
		// TODO Auto-generated method stub

		try {

			FileInputStream fileInput = new FileInputStream("customer.dat");
			ObjectInputStream objectoutput = new ObjectInputStream(fileInput);
		    Customer customerObject=null;
			
			while ((customerObject=(Customer)objectoutput.readObject())!=null) {

				customerList.add(customerObject);
				
				
	    	System.out.println("Name is "+customerObject.firstname);
	    	System.out.println("Customer Id is "+customerObject.customerid);

				
			}
		
			objectoutput.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
		return customerList;

	}
	
	public void addCustomerToFile(ArrayList<Customer> customerList,Customer customer) {
		// TODO Auto-generated method stub

		try {
			
			FileOutputStream fileOutput = new FileOutputStream("customer.dat");
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			for (int i = 0; i < customerList.size( ); i++)
	      	{ // write one object
				customer = (Customer)customerList.get(i);
				objectOutput.writeObject(customer); // this one line writes an entire object!!!!
	      	} 
			objectOutput.close();

			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 

	}
	
public int assignCustomerId(){
		
		int customerId=0;
		try {

			FileInputStream fileInput = new FileInputStream("customer.dat");
			ObjectInputStream objectoutput = new ObjectInputStream(fileInput);
		    Customer customerObject=null;
			
			while ((customerObject=(Customer)objectoutput.readObject())!=null) {
			
				if(customerObject.customerid>customerId){
					
					customerId=customerObject.customerid;

				}
	
				
			}

			
			objectoutput.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		return customerId+1;
		
	}
}
