package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class ExperimentalJourney {

	
	public static void display(){
		
		Stage Experimental = new Stage();
		
		Label infoLabel = new Label("This is an a fucntion in which the user can select predefined links to be inculed \n"
				+ "in the new Map which can help see how different new links can decrease or increase the time for a Journey");
		
		Button proceed = new Button();
		proceed.setText("Proceed");
		//proceed.setOnAction(e -> Experimental.setScene(mainPage));
		
		Button backToMain = new Button();
		backToMain.setText("Back to main menu");
		backToMain.setOnAction(e -> Experimental.close());
		
		VBox infoLayout = new VBox(20);
		infoLayout.getChildren().addAll(infoLabel, proceed, backToMain);
		infoLayout.setAlignment(Pos.CENTER);

		Scene infoPage = new Scene(infoLayout, 600, 300);
		infoPage.getStylesheets().add("MainTheme.css");
		
		Experimental.setScene(infoPage);
		Experimental.showAndWait();
		
	}
	
	
	
}
