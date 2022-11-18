package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StaffLoginController implements Initializable{

	

	@FXML
    private JFXTextField usernameTextfield;

    @FXML
    private JFXPasswordField passwordTextfield;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


	}
	
	@FXML
    public void checkLogin(ActionEvent event) throws IOException {
		
		
   if(usernameTextfield.getText().isEmpty() || passwordTextfield.getText().isEmpty()){
			  
			  
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Username or Password Field is Empty");
			  error_customer.showAndWait();
			  
		  }
  
  else{
		
		if(usernameTextfield.getText().equals("staff") && passwordTextfield.getText().equals("staff")){
			
			  ((Node)event.getSource()).getScene().getWindow().hide();

				Stage primaryStage=new Stage();
				FXMLLoader loader=new FXMLLoader();
				Pane root =FXMLLoader.load(getClass().getResource("StaffCustomerRecord.fxml")); 
				Scene scene2 = new Scene(root);
				primaryStage.setScene(scene2);
				primaryStage.show();
		}
		else{
			
			 Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Username or Password is Incorrect");
			  error_customer.showAndWait();
		}
		
	}
		
    }

}
