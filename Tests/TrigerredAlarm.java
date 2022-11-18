package application.Tests;

import java.io.Serializable;

public class TrigerredAlarm  implements Serializable{
	public int trigeralarmid;
	public String trigertime;
	public String trigerdate;
	public boolean trigerstatus;
	public Alarm alarm;
	public String zonename;
	
	public TrigerredAlarm(int trigeralarmid, String trigertime, String trigerdate, boolean trigerstatus, Alarm alarm, String zonename) {
		super();
		this.trigeralarmid = trigeralarmid;
		this.trigertime = trigertime;
		this.trigerdate = trigerdate;
		this.trigerstatus = trigerstatus;
		this.alarm = alarm;
		this.zonename=zonename;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public int getTrigeralarmid() {
		return trigeralarmid;
	}
	public void setTrigeralarmid(int trigeralarmid) {
		this.trigeralarmid = trigeralarmid;
	}
	public String getTrigertime() {
		return trigertime;
	}
	public void setTrigertime(String trigertime) {
		this.trigertime = trigertime;
	}
	public String getTrigerdate() {
		return trigerdate;
	}
	public void setTrigerdate(String trigerdate) {
		this.trigerdate = trigerdate;
	}
	public boolean isTrigerstatus() {
		return trigerstatus;
	}
	public void setTrigerstatus(boolean trigerstatus) {
		this.trigerstatus = trigerstatus;
	}

	public Alarm getAlarm() {
		return alarm;
	}
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
}
