package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TrigerredAlarmList {
	
	public ArrayList<TrigerredAlarm> setTrigeredAlarmList(ArrayList<TrigerredAlarm> trigeralarmList,TrigerredAlarm trigeralarm) {
		// TODO Auto-generated method stub

		try {

			FileInputStream fileInput = new FileInputStream("trigeralarm.dat");
			ObjectInputStream objectoutput = new ObjectInputStream(fileInput);
			TrigerredAlarm trigeralarmObject=null;
			
			while ((trigeralarmObject=(TrigerredAlarm)objectoutput.readObject())!=null) {

				trigeralarmList.add(trigeralarmObject);
	    	System.out.println("TrigerredAlarm ID is "+trigeralarmObject.trigeralarmid);
	    	System.out.println("Date is "+trigeralarmObject.trigerdate);
	    	System.out.println("Triggered zone is "+trigeralarmObject.zonename);


				
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
		
		return trigeralarmList;

	}
	
	public void addTrigerAlarmToFile(ArrayList<TrigerredAlarm> trigeralarmList,TrigerredAlarm trigeralarm) {
		// TODO Auto-generated method stub

		try {
			
			FileOutputStream fileOutput = new FileOutputStream("trigeralarm.dat");
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			for (int i = 0; i < trigeralarmList.size( ); i++)
	      	{ // write one object
				trigeralarm = (TrigerredAlarm)trigeralarmList.get(i);
				objectOutput.writeObject(trigeralarm); // this one line writes an entire object!!!!
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
	
public int assignTrigerId(){
		
		int trigeralarmLicence=0;
		try {

			FileInputStream fileInput = new FileInputStream("trigeralarm.dat");
			ObjectInputStream objectoutput = new ObjectInputStream(fileInput);
		    TrigerredAlarm alarmObject=null;
			
			while ((alarmObject=(TrigerredAlarm)objectoutput.readObject())!=null) {
			
				if(alarmObject.trigeralarmid>trigeralarmLicence){
					
					trigeralarmLicence=alarmObject.trigeralarmid;

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
		return trigeralarmLicence+1;
		
	}
}
