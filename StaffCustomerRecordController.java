package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StaffCustomerRecordController implements Initializable{

	public ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
	Customer customer;
	int autoCustomerid;
	@FXML
    private AnchorPane mainPane;

    @FXML
    private JFXTabPane main_tab;

    @FXML
    private JFXTextField firstnameTextfield;

    @FXML
    private JFXTextField idTextfield;

    @FXML
    private JFXTextField postcodeTextfield;

    @FXML
    private JFXTextField streetTextfield;

    @FXML
    private JFXTextField lastnameTextfield;

    @FXML
    private JFXTextField houseTextfield;

    @FXML
    private JFXComboBox<String> cityCombobox;

    @FXML
    private JFXTextField emailTextfield;
    
 
    
	  ObservableList<String> cityList=(ObservableList<String>) FXCollections.observableArrayList("London","Northampton","Milton Keyens");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cityCombobox.setItems(cityList);
//		idTextfield.setText("268");
		CustomerList customerList= new CustomerList();
		autoCustomerid= customerList.assignCustomerId();
		idTextfield.setText(Integer.toString(autoCustomerid));
		customerArrayList=customerList.setCustomerList(customerArrayList,customer);
		

		
		
	}
	
	@FXML
	   public void assignCustomerListener(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("AssignCustomerAlarm.fxml"));
			mainPane.getChildren().setAll(pane);
	    }
	@FXML
	   public void editCustomerListener(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("EditCustomerRecord.fxml"));
			mainPane.getChildren().setAll(pane);
	    }
	@FXML
	   public void trigerredListener(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("TrigerredAlarmStaff.fxml"));
			mainPane.getChildren().setAll(pane);
	    }
	 @FXML
	   public void addCustomerMenuListener(ActionEvent event) throws IOException {
		 ((Node)event.getSource()).getScene().getWindow().hide();

			
			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("StaffCustomerRecord.fxml")); 
			//Admin_Function ad_f=(Admin_Function)loader.getController();
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();
	    }
	 @FXML
	   public void homeButtonListener(ActionEvent event) throws IOException {
		 ((Node)event.getSource()).getScene().getWindow().hide();

			
			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("MianPage.fxml")); 
			//Admin_Function ad_f=(Admin_Function)loader.getController();
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();
	    }
	
	@FXML
    public void addCustomerListener(ActionEvent event) throws IOException {
		
		if(cityCombobox.getValue()==null || firstnameTextfield.getText().isEmpty() || lastnameTextfield.getText().isEmpty() || idTextfield.getText().isEmpty()
				
				|| streetTextfield.getText().isEmpty() || houseTextfield.getText().isEmpty() || postcodeTextfield.getText().isEmpty() || emailTextfield.getText().isEmpty()){
				
				  Alert addCustomerErrorAlert=new Alert(AlertType.ERROR);
				  addCustomerErrorAlert.setContentText("All Fields are not Filled");
				  addCustomerErrorAlert.showAndWait();
				
			}
		else{
			
			if( firstnameTextfield.getText().matches(".*\\d+.*") || lastnameTextfield.getText().matches(".*\\d+.*")){
						  Alert error_customer=new Alert(AlertType.ERROR);
						  error_customer.setContentText("Names cannot have numbers");
						  error_customer.showAndWait();
						
					}
		else{
			if(emailTextfield.getText().contains("@")  && emailTextfield.getText().contains(".com")){
		
				
				customerArrayList.add(new Customer(firstnameTextfield.getText(),lastnameTextfield.getText(),
						Integer.parseInt(idTextfield.getText()),streetTextfield.getText(),cityCombobox.getValue()
						,houseTextfield.getText(),postcodeTextfield.getText(),emailTextfield.getText()));

				CustomerList customerList= new CustomerList();
				customerList.addCustomerToFile( customerArrayList, customer);
				
				
				Alert confirm=new Alert(AlertType.CONFIRMATION);
				confirm.setContentText("Customer has been added");
				confirm.showAndWait();
				
				autoCustomerid= customerList.assignCustomerId();
				idTextfield.setText(Integer.toString(autoCustomerid));

				
				firstnameTextfield.setText("");
				lastnameTextfield.setText("");
				streetTextfield.setText("");
				houseTextfield.setText("");
				postcodeTextfield.setText("");
				emailTextfield.setText("");
				
			}
			
			else{
				  Alert emailErrorAlert=new Alert(AlertType.ERROR);
				  emailErrorAlert.setContentText("Wrong Email");
				  emailErrorAlert.showAndWait();
				
			}
			}
	}

}
}
