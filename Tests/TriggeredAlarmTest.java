package application.Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriggeredAlarmTest {
	
private TrigerredAlarm triger_alarm;
	@Before
	public void setUp() throws Exception {
		this.triger_alarm=new TrigerredAlarm(0,null,null,false,null,null);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void alarmTrigerTest() {
		triger_alarm.setTrigerstatus(true);
		assertEquals(true, triger_alarm.isTrigerstatus());
	}

}
