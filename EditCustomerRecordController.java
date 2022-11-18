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
import javafx.scene.control.Tab;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EditCustomerRecordController implements Initializable{
	public ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
	public ArrayList<Alarm> alarmArrayList = new ArrayList<Alarm>();

	 Customer customer;
	 Alarm alarm;
	 boolean recordStatus=false;
	 
	 @FXML
	    private AnchorPane mainPane;

	    @FXML
	    private JFXTextField firstnameTextfield;

	    @FXML
	    private JFXTextField customeridTextfield;

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
	    private Pane passcodePane;

	    @FXML
	    private JFXTextField securitycodeTextfield;

	    @FXML
	    private JFXTextField cityTextfield;
	    
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			CustomerList customerList= new CustomerList();
			customerArrayList=customerList.setCustomerList(customerArrayList,customer);
			
			AlarmList alarmList= new AlarmList();
			alarmArrayList=alarmList.setAlarmList(alarmArrayList,alarm);
			
			//adjustAlarmButton.setVisible(false);
			//passcodePane.setVisible(false);

		}
		
		 @FXML
		   public void editCustomerListener(ActionEvent event) throws IOException {
			 
			 
			  for (int i = 0; i < customerArrayList.size( ); i++)
		      	{ 
			  
			  if(Integer.parseInt(searchTextfield.getText())==(customerArrayList.get(i).customerid)){
				  customerArrayList.get(i).setCity(cityTextfield.getText());
				  customerArrayList.get(i).setFirstname(firstnameTextfield.getText());
				  customerArrayList.get(i).setEmail(emailTextfield.getText());
				  customerArrayList.get(i).setStreet(streetTextfield.getText());
				  customerArrayList.get(i).setPostcode(postcodeTextfield.getText());
				  customerArrayList.get(i).setLastname(lastnameTextfield.getText());
				  customerArrayList.get(i).setHouseno(housenoTextfield.getText());


				  for (int j = 0; j < alarmArrayList.size( ); j++)
			      	{ 
					  
					  if(customerArrayList.get(i).customerid==alarmArrayList.get(j).customerid){
						  
						  alarmArrayList.get(j).setAlarmcode(Integer.parseInt(securitycodeTextfield.getText()));
						  AlarmList alarmList= new AlarmList();
						  alarmList.addAlarmToFile(alarmArrayList, alarm);
						  
						  CustomerList cusList= new CustomerList();
						  cusList.addCustomerToFile(customerArrayList, customer);
						  
						  Alert confirm=new Alert(AlertType.CONFIRMATION);
							confirm.setContentText("Customer Record has been Edited");
							confirm.showAndWait();

							 AnchorPane pane =FXMLLoader.load(getClass().getResource("EditCustomerRecord.fxml"));
								mainPane.getChildren().setAll(pane);
					  }
			      	}
				  
				  
			  }
			  
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
					// adjustAlarmButton.setVisible(true);
					  
					  for (int j = 0; j < alarmArrayList.size( ); j++)
				      	{ 
						  
						  if(customerArrayList.get(i).customerid==alarmArrayList.get(j).customerid){
							  
							  securitycodeTextfield.setText(Integer.toString(alarmArrayList.get(j).alarmcode));
							 // alarmArrayList.get(j).setAlarmcode(1233);
							//  System.out.println("New is "+alarmArrayList.get(j).alarmcode);
							//  AlarmList alarmList= new AlarmList();
							//  alarmList.addAlarmToFile(alarmArrayList, alarm);

						  }
				      	}

				  }
				  
				  else{
					  
//					  Alert error_customer=new Alert(AlertType.ERROR);
//					  error_customer.setContentText("Customer Record Not Found");
//					  error_customer.showAndWait();
					  
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
