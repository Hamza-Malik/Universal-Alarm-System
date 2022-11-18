package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AssignCustomerAlarmController implements Initializable{

	public ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
	public ArrayList<Alarm> alarmArrayList = new ArrayList<Alarm>();

	 Customer customer;
	 Alarm alarm;
	 boolean recordStatus=false;
		int autoalarmid;

	
		@FXML
		private AnchorPane mainPane;

		@FXML
		private Pane passcodePane;
	    @FXML
	    private JFXTabPane main_tab;

	    @FXML
	    private Tab searchcustomerTab;

	    @FXML
	    private JFXTextField firstnameTextfield,licenceTextfield;

	    @FXML
	    private JFXTextField customeridTextfield,cityTextfield;

	    @FXML
	    private JFXTextField postcodeTextfield;

	    @FXML
	    private JFXTextField streetTextfield;

	    @FXML
	    private JFXTextField lastnameTextfield;

	    @FXML
	    private JFXTextField housenoTextfield;

	    @FXML
	    private JFXTextField emailTextfield;

	    @FXML
	    private JFXTextField searchTextfield;

	    @FXML
	    private JFXTextField securitycodeTextfield;
	    
	    @FXML
	    private JFXButton adjustAlarmButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		CustomerList customerList= new CustomerList();
		customerArrayList=customerList.setCustomerList(customerArrayList,customer);
		
		AlarmList alarmList= new AlarmList();
		alarmArrayList=alarmList.setAlarmList(alarmArrayList,alarm);
		
		adjustAlarmButton.setVisible(false);
		passcodePane.setVisible(false);

	}
	
	@FXML
	   public void assignGatesListener(ActionEvent event) {

		passcodePane.setVisible(true);
		AlarmList alarmList= new AlarmList();
		autoalarmid= alarmList.assignAlarmLicence();
		licenceTextfield.setText(Integer.toString(autoalarmid));

	}
	
	@FXML
	   public void assignAlarmListener(ActionEvent event) throws IOException {

   if(securitycodeTextfield.getText().isEmpty() || licenceTextfield.getText().isEmpty()){
	   
	   
	   Alert EmptyRecordError=new Alert(AlertType.ERROR);
		  EmptyRecordError.setContentText("Search field is Empty");
		  EmptyRecordError.showAndWait();
	   
   }
   
   else{
	   
	   alarmArrayList.add(new Alarm(firstnameTextfield.getText(),lastnameTextfield.getText(),Integer.parseInt(customeridTextfield.getText()),
				streetTextfield.getText(),cityTextfield.getText(),housenoTextfield.getText(),postcodeTextfield.getText(),emailTextfield.getText()
				,Integer.parseInt(securitycodeTextfield.getText()),Integer.parseInt(licenceTextfield.getText()),false,false,false,false,false));

	   AlarmList alarmList= new AlarmList();
	   alarmList.addAlarmToFile(alarmArrayList, alarm);
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("AssignCustomerAlarm.fxml"));
			mainPane.getChildren().setAll(pane);
	   
	   
   }
	}
	
	 @FXML
	   public void customerSearchListener(ActionEvent event) {
			//showpaymentButton.setVisible(false);

		  
		  if(searchTextfield.getText().isEmpty()){
			  
			  Alert EmptyRecordError=new Alert(AlertType.ERROR);
			  EmptyRecordError.setContentText("Search field is Empty");
			  EmptyRecordError.showAndWait();
			  
		  }
		  
		  else{
		  
		  for (int i = 0; i < customerArrayList.size( ); i++)
		      	{ 
			  
			  if(Integer.parseInt(searchTextfield.getText())==(customerArrayList.get(i).customerid)){
				  
				  
				  firstnameTextfield.setText(customerArrayList.get(i).firstname);
				  lastnameTextfield.setText(customerArrayList.get(i).lastname);
				  customeridTextfield.setText(String.valueOf(customerArrayList.get(i).customerid));
				  streetTextfield.setText(customerArrayList.get(i).street);
				  postcodeTextfield.setText(customerArrayList.get(i).postcode);
				  cityTextfield.setText(customerArrayList.get(i).city);
				  housenoTextfield.setText(customerArrayList.get(i).houseno);
				  emailTextfield.setText(customerArrayList.get(i).email);
				  recordStatus=true;
				 adjustAlarmButton.setVisible(true);

			  }
			  
			  else{
				  
//				  Alert error_customer=new Alert(AlertType.ERROR);
//				  error_customer.setContentText("Customer Record Not Found");
//				  error_customer.showAndWait();
				  
			  }
			  
			  
		      	}
		  
		  if(recordStatus){
			  recordStatus=false;
		  }
		  
		  else
		  {

				firstnameTextfield.setText("");
				lastnameTextfield.setText("");
				customeridTextfield.setText("");
				streetTextfield.setText("");
				postcodeTextfield.setText("");
				housenoTextfield.setText("");
				emailTextfield.setText("");
			  Alert customerNotFoundError=new Alert(AlertType.ERROR);
			  customerNotFoundError.setContentText("Customer Record Not Found");
			  customerNotFoundError.showAndWait();
			  recordStatus=false;
		  }
		  }

	    }

}
