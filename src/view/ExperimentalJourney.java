package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class ExperimentalJourney {

	
	public static void display(){
		
		Stage Experimental = new Stage();
		
		Label infoLabel = new Label("This is an a fucntion in which the user can select predefined links to be inculed \n"
				+ "in the new Map which can help see how different new links can decrease or increase the time for a Journey");
		infoLabel.getStyleClass().add("label-tips");
		infoLabel.setTextAlignment(TextAlignment.CENTER);
		
		Button proceed = new Button();
		proceed.setText("Proceed");
		
		Button backToMain = new Button();
		backToMain.setText("Back to main menu");
		backToMain.setOnAction(e -> Experimental.close());
		
		VBox infoLayout = new VBox(20);
		infoLayout.getChildren().addAll(infoLabel, proceed, backToMain);
		infoLayout.setAlignment(Pos.CENTER);
		
		Scene infoPage = new Scene(infoLayout, 700, 300);
		infoPage.getStylesheets().add("ExperimentalMain.css");
		
		Label labelChoices = new Label("Choose which experimental links you want to add to the Journey Planner: ");
		labelChoices.getStyleClass().add("label-info");
		
		CheckBox choice1 = new CheckBox("King's Cross St. Pancras to London Bridge");
		CheckBox choice2 = new CheckBox("King's Cross St. Pancras to Liverpool Street");
		
		Button addChoices = new Button();
		addChoices.setText("Add and proceed");
		
		Button goBack = new Button();
		goBack.setText("Back");
		goBack.setOnAction(e -> Experimental.setScene(infoPage));
		
		VBox choicesLayout = new VBox (15);
		choicesLayout.getChildren().addAll(labelChoices, choice1, choice2, addChoices, goBack);
		choicesLayout.setAlignment(Pos.CENTER);
		
		Scene choices = new Scene(choicesLayout, 700, 300);
		choices.getStylesheets().add("ExperimentalMain.css");
		
		proceed.setOnAction(e -> Experimental.setScene(choices));
		
		Experimental.setScene(infoPage);
		Experimental.showAndWait();
		
	}
	
	
	
}
