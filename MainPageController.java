package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainPageController {

	 @FXML
	   public void CustomerMenuListener(ActionEvent event) throws IOException {
		 ((Node)event.getSource()).getScene().getWindow().hide();

			
			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("CustomerAlarmDesign.fxml")); 
			//Admin_Function ad_f=(Admin_Function)loader.getController();
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();
	    }
	 
	 @FXML
	   public void StaffMenuListener(ActionEvent event) throws IOException {
		 ((Node)event.getSource()).getScene().getWindow().hide();

			
			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("StaffLoginPage.fxml")); 
			//Admin_Function ad_f=(Admin_Function)loader.getController();
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();
	    }
}
