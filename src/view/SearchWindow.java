package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import dijkstra.WeightedMap;
import javafx.geometry.*;

public class SearchWindow {
	
	final static WeightedMap lines = new WeightedMap(63);
	
	public static void display(){
		
		lines.fillMap(lines);
		
		Stage searchWindow = new Stage();
		
		searchWindow.setTitle("Start your search!");
		
		ComboBox <String> startLoc = new ComboBox<>();
		ComboBox <String> endLoc = new ComboBox<>();
		
		startLoc.getItems().addAll(
					"Charing Cross",
					"Embankment"
				);
		
		startLoc.setPromptText("From: ");
		
		endLoc.getItems().addAll(
				"Charing Cross",
				"Embankment"
			);
		
		endLoc.setPromptText("To: ");
		
		Button startSearch = new Button();
		startSearch.setText("Search!");
		startSearch.setOnAction(e -> {
			
			String startLocation = getChoice(startLoc);
			String endLocation = getChoice(endLoc);
			
			int origin = 0;
			int destination= 0;
			
			switch (startLocation) {
			
				case "Charing Cross": origin  = 1;
					break;
				case "Embankment": origin = 2;
					break;
			}
			
			switch (endLocation){
			
				case "Charing Cross": destination = 1;
					break;
				case "Embankment": destination = 2;
					break;
			}
			
		});
		
		Button backButton = new Button();
		backButton.setText("Back to Menu");
		backButton.setOnAction(e -> searchWindow.close());
		
		Label top = new Label("Choose start and destination:");
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(top, startLoc, endLoc, startSearch, backButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 600, 300);
		searchWindow.setScene(scene);
		searchWindow.showAndWait();
		
	}
	
	private static String getChoice(ComboBox <String> comboBox){
		String input = comboBox.getValue();
		System.out.println(input);
		return input;
	}
	
	
}
