package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Toggle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerAlarmController implements Initializable{
	
	public ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
	
	public ArrayList<Alarm> alarmArrayList = new ArrayList<Alarm>();
	
	public ArrayList<TrigerredAlarm> trigerred_alarmArrayList = new ArrayList<TrigerredAlarm>();
	
	@FXML
	private ImageView onOffView;
	private Image on;
	private Image off;
	public boolean matchStatus=false;
	
	public boolean byPassTrigger=false;
	public String filepath="soundalarm.wav";
	public String byPassZone;
	public  Clip clip;
	public int autotriheralarmid;
	public String zonename;
	@FXML
    private JFXButton frontDoorbtn;

    @FXML
    private JFXButton backDoorbtn;

    @FXML
    private JFXButton garagebtn;

    @FXML
    private JFXButton windowbtn;


	 int sec,bySec;
	 public boolean disarmtrigger=false;
	
	 Timer timerEntry,timerbyPass;
	 Customer customer,trig_cus;
	 Alarm alarm,trig_alarm;
	 TrigerredAlarm trigeralarm;
	 TrigerredAlarmList trigeralarmlist;

	 	@FXML
	    private Text testingcodeText,matchText,systemworkingstatusText,alarmmodeText,timerText,zoneNumberText,numberText;
	 	@FXML
	    private JFXButton awayButton,okButton;
	 	@FXML
	    private Pane numberPane,numberingPane;

	    @FXML
	    private JFXButton stayButton;

	    @FXML
	    private JFXButton offButton,bypassButton;
	
	    
	   
	    
	 
	 
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
	    	on=new Image(getClass().getResourceAsStream("images/on.png"));
	    	off=new Image(getClass().getResourceAsStream("images/switch.png"));
			onOffView.setImage(off);


		AlarmList alarmList= new AlarmList();
		alarmArrayList=alarmList.setAlarmList(alarmArrayList,alarm);
		
		TrigerredAlarmList tal=new TrigerredAlarmList();
		autotriheralarmid= tal.assignTrigerId();	
		
		TrigerredAlarmList trialarmList= new TrigerredAlarmList();
		trigerred_alarmArrayList=trialarmList.setTrigeredAlarmList(trigerred_alarmArrayList,trigeralarm);
		
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		offButton.setDisable(true);
		bypassButton.setDisable(true);
		zoneNumberText.setVisible(false);
		numberText.setVisible(false);
		
		}
	    
	    @FXML
		   public void refreshListener(ActionEvent event) throws IOException {
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
		   public void backListener(ActionEvent event) throws IOException {
			 ((Node)event.getSource()).getScene().getWindow().hide();

				
				Stage primaryStage=new Stage();
				FXMLLoader loader=new FXMLLoader();
				Pane root =FXMLLoader.load(getClass().getResource("MianPage.fxml")); 
				//Admin_Function ad_f=(Admin_Function)loader.getController();
				Scene scene2 = new Scene(root);
				primaryStage.setScene(scene2);
				primaryStage.show();
		    }
	    
	    public void disbaleButtons(){
	    	
	    	frontDoorbtn.setDisable(true);;

	         backDoorbtn.setDisable(true);

	         garagebtn.setDisable(true);

	         windowbtn.setDisable(true);
	    	
	    	
	    }
	    @FXML
		   public void FrontDoor(ActionEvent event) {
	    	
	if(byPassTrigger){
	    		
		byPassTrigger=false;
	    	}
	    	else{
	    		zonename="Front Door";
		    	disbaleButtons();
		    	EnteryInHouse();
	    	}
	    	
	    }
	    @FXML
		   public void BackDoor(ActionEvent event) {
	    	
	    	
	    	if(byPassTrigger){
	    		
	    		byPassTrigger=false;
	    	    	}
	    	    	else{
	    		
	    		
	    	zonename="Back Door";
	    	disbaleButtons();
	    	EnteryInHouse();
	    	    	}
	    	
	    }
	    @FXML
		   public void Garage(ActionEvent event) {
	    	
	    	if(byPassTrigger){
	    		
	    		byPassTrigger=false;
	    	    	}
	    	    	else{
	    	zonename="Garage";
	    	disbaleButtons();
	    	EnteryInHouse();
	    }
	    }
	    @FXML
		   public void Window(ActionEvent event) {
	    	if(byPassTrigger){
	    		
	    		byPassTrigger=false;
	    	    	}
	    	    	else{
	    	zonename="Window";
	    	disbaleButtons();
	    	EnteryInHouse();
	    	    	}
	    }
	  
		   public void EnteryInHouse() {
	    	offButton.setDisable(false);
 			systemworkingstatusText.setText("Security Company will be contacted in  ");
	    	sec=20;
   	    	timerEntry = new Timer();
   	    	timerEntry.schedule(new TimerTask() {
   	    	    @Override
   	    	    public void run() {
   	    	       System.out.println("Sec is"+sec);
   	    	       timerText.setText(Integer.toString(sec)+" sec");
   	    	       sec--;
   	    	       if(sec==0){
   	    	    	disarmtrigger=true;
   	    	    	timerEntry.cancel();
   	    	    	awayButton.setDisable(true);
   	    	    	stayButton.setDisable(true);
   	    	    	bypassButton.setDisable(true);
   	    	    	okButton.setDisable(true);
   	    			//numberPane.setDisable(true);    	   		
   	    			systemworkingstatusText.setText("Security Company Has Been Contacted");
   	    			timerText.setText("");
   	    			
   	    		
   	    			trigerred_alarmArrayList.add(new TrigerredAlarm(autotriheralarmid,LocalDateTime.now().toLocalTime().toString(),LocalDateTime.now().toLocalDate().toString(),
   	    					true,trig_alarm,zonename));		

   	    			TrigerredAlarmList triggeredalarmList= new TrigerredAlarmList();
   	    			triggeredalarmList.addTrigerAlarmToFile(trigerred_alarmArrayList, trigeralarm);
   	    			try {
						activeAlarm();
					} catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
   	    	    	  // systemworkingstatusText.setText("Intrusion, Contacting thr company");
   	    	       }
   	    	    }
   	    	}, 0, 1000);
	    	
	    }
	    
	    @FXML
		   public void offListener(ActionEvent event) {
	    	 if(testingcodeText.getText().isEmpty()){
				  
				  Alert EmptyRecordError=new Alert(AlertType.ERROR);
				  EmptyRecordError.setContentText("No Passcode Entered");
				  EmptyRecordError.showAndWait();
				  
			  }
	    	 else{
	    		 
	    		 
	    		   if(checkpasscode()){
	    			
	   			    testingcodeText.setText("");
	   	    		timerEntry.cancel(); 
	   	    		awayButton.setDisable(false);
	   	    		stayButton.setDisable(false);
	   	    		bypassButton.setDisable(false);
	   	    		frontDoorbtn.setDisable(false);
	   	    		backDoorbtn.setDisable(false);
	   	    		garagebtn.setDisable(false);
	   	    		windowbtn.setDisable(false);

	   	    		alarmmodeText.setText("Stay");
	   	    		systemworkingstatusText.setText("Alarm System is Active");
	   	    		timerText.setText("");
	   	    		
	   	    		if(disarmtrigger){
	   	    			clip.stop();
	   	    			disarmtrigger=false;
	   	    			
	   	    		}
	   	    		
	    		 }
	   	    	
	   	    	
	   	    	else{
		   			systemworkingstatusText.setText("Alarm is activating in  ");
	   	    		testingcodeText.setText(" ");
	   	    		
	   	    		
	   	    	}
	   		  
	    			 
	    			 
	    			 
	    		 }
	    	 }
	    	
	    
	   
	    @FXML
		   public void awayListener(ActionEvent event) {
	  if(testingcodeText.getText().isEmpty()){
			  
			  Alert EmptyRecordError=new Alert(AlertType.ERROR);
			  EmptyRecordError.setContentText("No Passcode Entered");
			  EmptyRecordError.showAndWait();
			  
		  }
		  
		  else{
			  systemworkingstatusText.setText("Away Mode will be activated in ");
			  if(checkpasscode()){
				  testingcodeText.setText("");

	    	  sec=20;
	    	  Timer timerAway = new Timer();
	    	  timerAway.schedule(new TimerTask() {
	    		  @Override
	    	    public void run() {
	    	       System.out.println("Sec is"+sec);
	    	       timerText.setText(Integer.toString(sec)+" sec");
	    	       sec--;
	    	       if(sec==0){
	    	    	   
	    	    	   timerAway.cancel();
	    	    	   awayButton.setDisable(true);
	    	   		stayButton.setDisable(true);
	    	   		offButton.setDisable(true);
	    	   		bypassButton.setDisable(true);
	    	   		alarmmodeText.setText("Away");
	    	   		
	    	   	 systemworkingstatusText.setText("Security is Active");
	    	   	timerText.setText("");
	    	    	  // systemworkingstatusText.setText("Intrusion, Contacting thr company");
	    	       }
	    	    }
	    	}, 0, 1000);
			
	    }
	    	
	    	
	    	else{
	    		systemworkingstatusText.setText("Incorrect Passcode");
	    		testingcodeText.setText("");
	    		
	    		
	    	}
		  }
	    }
	    
	    public void timerBypass(){
	    	zoneNumberText.setVisible(true);
	    	zoneNumberText.setText("Zone is secured to cross");
			numberText.setVisible(true);
	    	awayButton.setDisable(true);
				stayButton.setDisable(true);
				offButton.setDisable(true);
	    	 systemworkingstatusText.setText("Bypass is Enabled for  ");
	    	 bySec=10;
	    	  Timer timerBPass = new Timer();
	    	  timerBPass.schedule(new TimerTask() {
	    		  @Override
	    	    public void run() {
	    	       System.out.println("Sec is"+bySec);
	    	       timerText.setText(Integer.toString(bySec)+" sec");
	    	       bySec--;
	    	       if(bySec==0){
	    	    	   
	    	    	   timerBPass.cancel();
	    	    	   systemworkingstatusText.setText("Security System Running");
	 				  awayButton.setDisable(false);
	 				  stayButton.setDisable(false);
	 				  offButton.setDisable(false);
	 				System.out.println("Matched");
	 				testingcodeText.setText("");
	 				alarmmodeText.setText("Stay");
	 				zoneNumberText.setVisible(false);
					numberText.setVisible(false);
		    		numberText.setText("");
		    		byPassTrigger=false;
		    		timerText.setText("");
		    		
	    	    	
	    	       }
	    	    }
	    	}, 0, 1000);
	    }
	    
	    

	
	    @FXML
	   public void oneListener(ActionEvent event) {
	    	
	 //   	clip.stop();
	    	
	    	if(byPassTrigger){
	    		backDoorbtn.setDisable(true);
	    		garagebtn.setDisable(true);
	    		windowbtn.setDisable(true);
	    		numberText.setText("1");
	    		timerBypass();
//	    		frontDoorbtn.setDisable(false);
//	    		backDoorbtn.setDisable(false);
//	    		garagebtn.setDisable(false);
//	    		windowbtn.setDisable(false);
	    	}
	    	else{
		testingcodeText.setText(testingcodeText.getText()+"1");
	    	}
		
	}
	    @FXML
	   public void twoListener(ActionEvent event) {
	    	
	    	if(byPassTrigger){
	    		
	    		frontDoorbtn.setDisable(true);
	    		garagebtn.setDisable(true);
	    		windowbtn.setDisable(true);
	    		numberText.setText("2");
	    		timerBypass();
//	    		frontDoorbtn.setDisable(false);
//	    		backDoorbtn.setDisable(false);
//	    		garagebtn.setDisable(false);
//	    		windowbtn.setDisable(false);
	    	}
	    	else{
		testingcodeText.setText(testingcodeText.getText()+"2");
	    	}
		
	}	
	    @FXML
	   public void threeListener(ActionEvent event) {
	    	
	    	if(byPassTrigger){
	    		frontDoorbtn.setDisable(true);
	    		backDoorbtn.setDisable(true);
	    		windowbtn.setDisable(true);
	    		numberText.setText("3");
	    		timerBypass();

	    	}
	    	else{
		testingcodeText.setText(testingcodeText.getText()+"3");
	    	}
		
	}	
	    @FXML
	   public void fourListener(ActionEvent event) {
	    	
	    	if(byPassTrigger){
	    		frontDoorbtn.setDisable(true);
	    		backDoorbtn.setDisable(true);
	    		garagebtn.setDisable(true);
	    		numberText.setText("4");
	    		timerBypass();

	    	}
	    	else{
		testingcodeText.setText(testingcodeText.getText()+"4");
	    	}
		
	}	
	    @FXML
	   public void fiveListener(ActionEvent event) {
		testingcodeText.setText(testingcodeText.getText()+"5");

		
	}	
	    @FXML
	   public void sixListener(ActionEvent event) {
		
		testingcodeText.setText(testingcodeText.getText()+"6");

	}	
	    @FXML
	   public void sevenListener(ActionEvent event) {
		
		testingcodeText.setText(testingcodeText.getText()+"7");

	}	
	    @FXML
	   public void eightListener(ActionEvent event) {
		testingcodeText.setText(testingcodeText.getText()+"8");

		
	}	
	    @FXML
	   public void nineListener(ActionEvent event) {
		
		testingcodeText.setText(testingcodeText.getText()+"9");

	}
	    @FXML
	   public void zeroListener(ActionEvent event) {
		testingcodeText.setText(testingcodeText.getText()+"0");

		
	}
	    
	    public boolean checkpasscode(){
	    		  
			  for (int i = 0; i < alarmArrayList.size( ); i++)
			      	{ 
				  
				  if(Integer.parseInt(testingcodeText.getText())==(alarmArrayList.get(i).alarmcode)){
					 
					  matchStatus= true;
					  trig_alarm=alarmArrayList.get(i);
					  break;
					//  System.out.println("This is "+trig_alarm);

				  }
				  
				  else{
					  
					  matchStatus= false;


					  
				  }
				  
				  
			      	}
			return matchStatus;
			  

		  
	    }
	    
	    @FXML
		   public void byPassButtonListener(ActionEvent event) {
				//showpaymentButton.setVisible(false);

			  
			  if(testingcodeText.getText().isEmpty()){
				  
				  Alert EmptyRecordError=new Alert(AlertType.ERROR);
				  EmptyRecordError.setContentText("Passcode is not entered");
				  EmptyRecordError.showAndWait();
				  
			  }
			  
			  else{
			  
			
				  
				  if(checkpasscode()){
					  byPassTrigger=true;
					  alarmmodeText.setText("ByPass");
					  zoneNumberText.setVisible(true);
						numberText.setVisible(true);
				

				  }
				  
				  else{
					  
					 // matchText.setText("Code Not Macthed");
					  systemworkingstatusText.setText("Security Not Running");
					  awayButton.setDisable(true);
						stayButton.setDisable(true);
						offButton.setDisable(true);
						testingcodeText.setText("");
						alarmmodeText.setText("None");


					  
				  }
				  
				  
			      	
			  
	}


		    }
	    
	    public void activeAlarm() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
	    	
	    	 File music=new File(filepath);
	         if(music.exists()){
	        	 
	        	 
	        	 
	        	 
	        	 AudioInputStream input = AudioSystem.getAudioInputStream(music);
	        	  clip = AudioSystem.getClip();
	        	 clip.open(input);
	        	 clip.start();
	        	
	        	 clip.loop(Clip.LOOP_CONTINUOUSLY);
	         }
	    }
	    
	    
	    @FXML
	   public void okButtonListener(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
    
		  
		  if(testingcodeText.getText().isEmpty()){
			  
			  Alert EmptyRecordError=new Alert(AlertType.ERROR);
			  EmptyRecordError.setContentText("Search field is Empty");
			  EmptyRecordError.showAndWait();
			  
		  }
		  
		  else{
		  
		
			  
			  if(checkpasscode()){
				 
				// matchText.setText("Code Macthed");
				  systemworkingstatusText.setText("Security System Running");
				  awayButton.setDisable(false);
					stayButton.setDisable(false);
					offButton.setDisable(false);					
					bypassButton.setDisable(false);

				System.out.println("Matched");
				testingcodeText.setText("");
				alarmmodeText.setText("Stay");
				onOffView.setImage(on);

				
			


			  }
			  
			  else{
				  
				 // matchText.setText("Code Not Macthed");
				  systemworkingstatusText.setText("Security Not Running");
				  awayButton.setDisable(true);
					stayButton.setDisable(true);
					offButton.setDisable(true);
					testingcodeText.setText("");
					alarmmodeText.setText("None");


				  
			  }
			  
			  
		      	
		  
}


	    }
	    
	    
	

	


}
