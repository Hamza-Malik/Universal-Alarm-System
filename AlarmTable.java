package application;

import javafx.beans.property.SimpleStringProperty;

public class AlarmTable {
	private  SimpleStringProperty alarmId;
	private  SimpleStringProperty customerId;
	private  SimpleStringProperty trigerredZone;
	private  SimpleStringProperty trigerredDate;
	private  SimpleStringProperty trigerredTime;
	
	
	public AlarmTable(String alarmId, String customerId,String trigerredZone,
			String trigerredDate, String trigerredTime) {
		super();
		
		this.alarmId = new SimpleStringProperty(alarmId);
		this.customerId = new SimpleStringProperty(customerId);
		this.trigerredZone = new SimpleStringProperty(trigerredZone);
		this.trigerredDate = new SimpleStringProperty(trigerredDate);
		this.trigerredTime = new SimpleStringProperty(trigerredTime);
	}
	public String getAlarmId() {
		return alarmId.get();
	}
	public void setAlarmId(SimpleStringProperty alarmId) {
		this.alarmId = alarmId;
	}
	public String getCustomerId() {
		return customerId.get();
	}
	public void setCustomerId(SimpleStringProperty customerId) {
		this.customerId = customerId;
	}
	public String getTrigerredZone() {
		return trigerredZone.get();
	}
	public void setTrigerredZone(SimpleStringProperty trigerredZone) {
		this.trigerredZone = trigerredZone;
	}
	public String getTrigerredDate() {
		return trigerredDate.get();
	}
	public void setTrigerredDate(SimpleStringProperty trigerredDate) {
		this.trigerredDate = trigerredDate;
	}
	public String getTrigerredTime() {
		return trigerredTime.get();
	}
	public void setTrigerredTime(SimpleStringProperty trigerredTime) {
		this.trigerredTime = trigerredTime;
	}



}
