// Author: Karina Winkelmann
// Date: October 29th, 2023
// Objective: Created a prototype that acts as a login screen
//            that prompts the user to correct company info 
//            and then acts as a dual authentication by asking
//		      the user for their role. This prototype is also
//            incredibly user friendly so a wide range of users
//			  can use no matter their technical knowledge.



package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application 
 {
	
	@Override
	
	public void start(Stage primaryStage) throws Exception
	 {
		try {
				GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
				Scene scene = new Scene(root, 500,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.setScene(scene);
				primaryStage.show();
			} 
		
		catch(Exception e) 
		 {
			
			e.printStackTrace();
			
		 }
     }
	
	public static void main(String[] args) 
	 {
		
		System.out.println("Opening Effort Logger Program....");
		launch(args);
		
	 }
 }
