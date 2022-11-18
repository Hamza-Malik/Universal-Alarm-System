package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AlarmList {
	
	public ArrayList<Alarm> setAlarmList(ArrayList<Alarm> alarmList,Alarm alarm) {
		// TODO Auto-generated method stub

		try {

			FileInputStream fileInput = new FileInputStream("alarm.dat");
			ObjectInputStream objectoutput = new ObjectInputStream(fileInput);
		    Alarm alarmObject=null;
			
			while ((alarmObject=(Alarm)objectoutput.readObject())!=null) {

				alarmList.add(alarmObject);
	    	System.out.println("Alarm is "+alarmObject.alarmcode);
	    	System.out.println("Id is "+alarmObject.alarmid);

				
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
		
		return alarmList;

	}
	
	public void addAlarmToFile(ArrayList<Alarm> alarmList,Alarm alarm) {
		// TODO Auto-generated method stub

		try {
			
			FileOutputStream fileOutput = new FileOutputStream("alarm.dat");
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			for (int i = 0; i < alarmList.size( ); i++)
	      	{ // write one object
				alarm = (Alarm)alarmList.get(i);
				objectOutput.writeObject(alarm); // this one line writes an entire object!!!!
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
	
public int assignAlarmLicence(){
		
		int alarmLicence=0;
		try {

			FileInputStream fileInput = new FileInputStream("alarm.dat");
			ObjectInputStream objectoutput = new ObjectInputStream(fileInput);
		    Alarm alarmObject=null;
			
			while ((alarmObject=(Alarm)objectoutput.readObject())!=null) {
			
				if(alarmObject.alarmid>alarmLicence){
					
					alarmLicence=alarmObject.alarmid;

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
		return alarmLicence+1;
		
	}
}
