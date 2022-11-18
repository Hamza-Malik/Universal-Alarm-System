package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TriggeredAlarmStaffController implements Initializable{

	public ArrayList<TrigerredAlarm> trigerred_alarmArrayList = new ArrayList<TrigerredAlarm>();
	 TrigerredAlarm trigeralarm;
	 @FXML
		public  ObservableList<AlarmTable> alarmList=FXCollections.observableArrayList();
	   @FXML
	    private TableView<AlarmTable> alarmTable;

	    @FXML
	    private TableColumn<AlarmTable, String> AlarmIdColumn;

	    @FXML
	    private TableColumn<AlarmTable, String> customerIdColumn;

	    @FXML
	    private TableColumn<AlarmTable, String> trigerredZoneColumn;

	    @FXML
	    private TableColumn<AlarmTable,String> dateColumn;

	    @FXML
	    private TableColumn<AlarmTable, String> timeColumn;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		TrigerredAlarmList trialarmList= new TrigerredAlarmList();
		 trigerred_alarmArrayList=trialarmList.setTrigeredAlarmList(trigerred_alarmArrayList,trigeralarm);
		 setAlarmList();
		 populateTable();
		
	}
	public void populateTable() {
		AlarmIdColumn.setCellValueFactory(new PropertyValueFactory<AlarmTable,String>("alarmId"));
		customerIdColumn.setCellValueFactory(new PropertyValueFactory<AlarmTable,String>("customerId"));
		trigerredZoneColumn.setCellValueFactory(new PropertyValueFactory<AlarmTable,String>("trigerredZone"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<AlarmTable,String>("trigerredDate"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<AlarmTable,String>("trigerredTime"));
		
		alarmTable.setItems(alarmList);
	}
	public void setAlarmList() {
		 for (int i = 0; i < trigerred_alarmArrayList.size( ); i++)
	      	{ 
		
		alarmList.add(new AlarmTable(Integer.toString(trigerred_alarmArrayList.get(i).alarm.alarmid),Integer.toString(trigerred_alarmArrayList.get(i).alarm.customerid),
				trigerred_alarmArrayList.get(i).zonename ,  trigerred_alarmArrayList.get(i).trigerdate ,trigerred_alarmArrayList.get(i).trigertime ));
		
	      	}
	
	}

}
