package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class SampleController 
 {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Parent root_1;
	private Scene scene_1;
	private Stage stage_1;
	
	@FXML
	private AnchorPane Scene_Pane; // Main Log-In Menu 
	
	@FXML
	private AnchorPane Role_Scene_Pane; // Role Log-In Menu
	
	//////////////////////////////////////
		
    @FXML
    private Button Exit_Button; // Closes out the application

    @FXML
    private Button Login_Button; // Switches to Role menu after checking log-in is correct
    
    @FXML
    private Button Confirm_Role_Button; // Allows user to submit their role to get checked

    @FXML
    private Button Return_To_Menu_Button; // Allows user to go back to login page
    
    //////////////////////////////////////
    
    @FXML
    private Label Login_Error_Message; // Appears if log-in is wrong

    @FXML
    private Label Roles_Error_Message; // Appears if role inputted doesn't match user's actual role in company
    
    @FXML
    private PasswordField Password_Password_Field; // Allows user to write a password
 
    @FXML
    private TextField Username_Text_Field; // Allows user to write their username
    
    @FXML
    private TextField Role_Text_Field; // Allows user to input their respective role
    
    /////////////////////////////////////

    // Closes the Application - acts as the x button on any website
    
	    public void Exit_Button_Clicked(ActionEvent event) 
	     {
	
	    	Stage stage = (Stage) Scene_Pane.getScene().getWindow();
	    	System.out.println("You have successfully logged out");
	    	stage.close();
	    	
	     }
	    
	// Closes the Application - acts as the x button on any website
	    
	    public void Return_Button_Clicked(ActionEvent event) throws IOException 
	     {
	
			   Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
			   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			   scene = new Scene(root);
			   stage.setScene(scene);
			   stage.show();
	    	
	     }   
   // This is where the user's login information is tested to keep those outside the company from looking at private files
	    
	   public void Login_Button_Clicked(ActionEvent event) throws IOException
	    {
		   
		   // If our username and password prompts are empty - prompts user to enter in a username and password again
		   
			   if (Username_Text_Field.getText().isEmpty() && Password_Password_Field.getText().isEmpty())
			    {
				   
				   Login_Error_Message.setText("Error: Please enter a username and password.");
				   
			    }
		   
		   // If our username and password prompts are correct - Prints out that you are logged in and shifts user to roles tab
			   
			   else if (Username_Text_Field.getText().equals("Karina") && Password_Password_Field.getText().equals("Password"))
			   	{
				   
				   System.out.println("One more security step before we let you in");
				   Login_Error_Message.setText(" ");
				   
				   root = FXMLLoader.load(getClass().getResource("Roles_Screen.fxml"));
				   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				   scene = new Scene(root);
				   stage.setScene(scene);
				   stage.show();
				   				   
			   	}
			   
		   // Otherwise our prompts must be wrong - tells user they didn't write the correct login information
			   
			   else
			    {
				   
				   Login_Error_Message.setText("Error: Incorrect Username or Password.");
				   
			    }
		   
	    }
   
	   public void Confirm_Button_Clicked(ActionEvent event) throws IOException
	    {
		   
		   // If our role prompt is empty - prompts user to enter in their role again
		   
			   if (Role_Text_Field.getText().isEmpty())
			    {
				   
				   Roles_Error_Message.setText("Error: Please enter a role.");
				   
			    }
		   
		   // If our role prompt is correct - Prints out that you are logged in and shifts user to information tab
			   
			   else if (Role_Text_Field.getText().equals("Manager") || Role_Text_Field.getText().equals("manager"))
			   	{
				   
				   System.out.println("You have successfully logged in!");
				   Roles_Error_Message.setText(" ");
				   
				   root_1 = FXMLLoader.load(getClass().getResource("Information_Screen.fxml"));
				   stage_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
				   scene_1 = new Scene(root_1);
				   stage_1.setScene(scene_1);
				   stage_1.show();
				   				   				   				   
			   	}
			   
		   // Otherwise our prompts must be wrong - tells user they didn't write the correct role information
			   
			   else
			    {
				   
				   Roles_Error_Message.setText("Error: Incorrect Role for User.");
				   
			    }
		   
	    }
 }
