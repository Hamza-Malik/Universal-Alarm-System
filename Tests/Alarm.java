package application.Tests;

import java.io.Serializable;

public class Alarm extends Customer implements Serializable{
	public int alarmcode;
	public int alarmid;
	public boolean frontgate;
	public boolean backgate;
	public boolean garage;
	public boolean window;
	public boolean alarmstatus;

	public Alarm(String firstname, String lastname, int customerid, String street, String city, String houseno,
			String postcode, String email,int alarmcode,int alarmid,boolean frontgate,boolean backgate,boolean garage,boolean window, boolean alarmstatus) {
		super(firstname, lastname, customerid, street, city, houseno, postcode, email);
		this.alarmcode=alarmcode;
		this.alarmid=alarmid;
		this.frontgate=frontgate;
		this.backgate=backgate;
		this.garage=garage;
		this.window=window;	
		this.alarmstatus=alarmstatus;
		
	}
	public boolean isAlarmstatus() {
		return alarmstatus;
	}
	public void setAlarmstatus(boolean alarmstatus) {
		this.alarmstatus = alarmstatus;
	}
	public int getAlarmcode() {
		return alarmcode;
	}
	public void setAlarmcode(int alarmcode) {
		this.alarmcode = alarmcode;
	}
	public int getAlarmid() {
		return alarmid;
	}
	public void setAlarmid(int alarmid) {
		this.alarmid = alarmid;
	}
	public boolean isFrontgate() {
		return frontgate;
	}
	public void setFrontgate(boolean frontgate) {
		this.frontgate = frontgate;
	}
	public boolean isBackgate() {
		return backgate;
	}
	public void setBackgate(boolean backgate) {
		this.backgate = backgate;
	}
	public boolean isGarage() {
		return garage;
	}
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	public boolean isWindow() {
		return window;
	}
	public void setWindow(boolean window) {
		this.window = window;
	}
	
	
	
	
	
	

}
