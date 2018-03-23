package view;

import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.WeightedMap;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class ExperimentalJourney {

	final static WeightedMap lines = new WeightedMap(82);
	
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
	
		lines.fillMap(lines);
		
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
		
		//Search Window
		ComboBox <String> startLoc = new ComboBox<>();
		ComboBox <String> endLoc = new ComboBox<>();
		
		startLoc.getItems().addAll(
					"Angel", 
					"Baker Street",
					"Bank",
					"Bond Street",
					"Borough",
					"Chancery Lane",
					"Charing Cross",
					"Covent Garden",
					"Elephant and Castle",
					"Embankment",
					"Euston",
					"Farrington",
					"Goodge Street",
					"Green Park",
					"Holborn",
					"Kennington",
					"King's Cross St. Pancras",
					"Lambeth North",
					"Leicester Square",
					"Liverpool Street",
					"London Bridge",
					"Moorgate",
					"Old Street",
					"Oxford Circus",
					"Paddington",
					"Piccadilly Circus",
					"Pimlico",
					"Regent's Park",
					"Russel Square",
					"Southwark",
					"St. Paul's",
					"Tottenham Court Road",
					"Vauxhall",
					"Victoria",
					"Warren Street",
					"Waterloo",
					"Westminster"
				);
		
		startLoc.setPromptText("From: ");
		
		endLoc.getItems().addAll(
				"Angel", 
				"Baker Street",
				"Bank",
				"Bond Street",
				"Borough",
				"Chancery Lane",
				"Charing Cross",
				"Covent Garden",
				"Elephant and Castle",
				"Embankment",
				"Euston",
				"Farrington",
				"Goodge Street",
				"Green Park",
				"Holborn",
				"Kennington",
				"King's Cross St. Pancras",
				"Lambeth North",
				"Leicester Square",
				"Liverpool Street",
				"London Bridge",
				"Moorgate",
				"Old Street",
				"Oxford Circus",
				"Paddington",
				"Piccadilly Circus",
				"Pimlico",
				"Regent's Park",
				"Russel Square",
				"Southwark",
				"St. Paul's",
				"Tottenham Court Road",
				"Vauxhall",
				"Victoria",
				"Warren Street",
				"Waterloo",
				"Westminster"
			);
		
		endLoc.setPromptText("To: ");
		
		TextArea searchResults = new TextArea();
		searchResults.setText("");
		searchResults.setPromptText("Your result");
		searchResults.setEditable(false);
		searchResults.setWrapText(true);
		searchResults.setPrefColumnCount(3);
		searchResults.setPrefRowCount(3);
		
		Button startSearch = new Button();
		startSearch.setText("Search!");
		startSearch.setOnAction(e -> {
			
			String startLocation = getChoice(startLoc);
			String endLocation = getChoice(endLoc);
			
			
			if (startLocation == null){
				System.out.println("Please insert a starting location");
			}
			
			if (endLocation == null){
				System.out.println("Please insert a destination");
			}
			
			
			int origin = -1;
			int destination= -1;
			
			switch (startLocation) {
			
				case "Angel": origin  = 52;
					break;
				case "Baker Street": origin = 69;
					break;
				case "Bank": origin = 77;
					break;
				case "Bond Street": origin = 72;
					break;
				case "Borough": origin = 47;
					break;
				case "Chancery Lane": origin = 27;
					break;
				case "Charing Cross": origin = 66;
					break;
				case "Covent Garden": origin = 19;
					break;
				case "Elephant and Castle": origin = 63;
					break;
				case "Embankment": origin = 65;
					break;
				case "Euston": origin = 80;
					break;
				case "Farrington": origin = 34;
					break; 
				case "Goodge Street": origin = 42;
					break;
				case "Green Park": origin = 71;
					break;
				case "Holborn": origin = 74;
					break;
				case "Kennington": origin = 79;
					break; 
				case "King's Cross St. Pancras": origin = 75;
					break;
				case "Lambeth North": origin = 1;
					break;
				case "Leicester Square": origin = 73;
					break;
				case "Liverpool Street": origin = 78;
					break; 
				case "London Bridge": origin = 70;
					break;
				case "Moorgate": origin = 50;
					break;
				case "Old Street": origin = 51;
					break;
				case "Oxford Circus": origin = 68;
					break;
				case "Paddington": origin = 31;
					break;
				case "Piccadilly Circus": origin = 67;
					break;
				case "Pimlico": origin = 56;
					break;
				case "Regent's Park": origin = 7;
					break;
				case "Russel Square": origin = 21;
					break;
				case "Southwark": origin = 10;
					break;
				case "St. Paul's": origin = 28;
					break;
				case "Tottenham Court Road": origin = 76;
					break;
				case "Vauxhall": origin = 55;
					break;
				case "Victoria": origin = 57;
					break;
				case "Warren Street": origin = 81;
					break;
				case "Waterloo": origin = 64;
					break;
				case "Westminster": origin = 12; 
					break;

			}
			
			switch (endLocation){
			
				case "Angel": destination  = 52;
					break;
				case "Baker Street": destination = 69;
					break;
				case "Bank": destination = 77;
					break;
				case "Bond Street": destination = 72;
					break;
				case "Borough": destination = 47;
					break;
				case "Chancery Lane": destination = 27;
					break;
				case "Charing Cross": destination = 66;
					break;
				case "Covent Garden": destination = 19;
					break;
				case "Elephant and Castle": destination = 63;
					break;
				case "Embankment": destination = 65;
					break;
				case "Euston": destination = 80;
					break;
				case "Farrington": destination = 34;
					break; 
				case "Goodge Street": destination = 42;
					break;
				case "Green Park": destination = 71;
					break;
				case "Holborn": destination = 74;
					break;
				case "Kennington": destination = 79;
					break; 
				case "King's Cross St. Pancras": destination = 75;
					break;
				case "Lambeth North": destination = 1;
					break;
				case "Leicester Square": destination = 73;
					break;
				case "Liverpool Street": destination = 78;
					break; 
				case "London Bridge": destination = 70;
					break;
				case "Moorgate": destination = 50;
					break;
				case "Old Street": destination = 51;
					break;
				case "Oxford Circus": destination = 68;
					break;
				case "Paddington": destination = 31;
					break;
				case "Piccadilly Circus": destination = 67;
					break;
				case "Pimlico": destination = 56;
					break;
				case "Regent's Park": destination = 7;
					break;
				case "Russel Square": destination = 21;
					break;
				case "Southwark": destination = 10;
					break;
				case "St. Paul's": destination = 28;
					break;
				case "Tottenham Court Road": destination = 76;
					break;
				case "Vauxhall": destination = 55;
					break;
				case "Victoria": destination = 57;
					break;
				case "Warren Street": destination = 81;
					break;
				case "Waterloo": destination = 64;
					break;
				case "Westminster": destination = 12; 
					break;
			}
			
			
			if(origin == destination){
				System.out.println("You are already here");
			} else if (origin == -1 && destination == -1){
				System.out.println("Please enter: Start and Finish");
			} else {
				final int [] previous = Dijkstra.dijkstra(lines, origin);
				Dijkstra.printJourney(lines, previous, origin, destination);
			}
			
			final int [] previous = Dijkstra.dijkstra(lines, origin);
			ArrayList result = Dijkstra.getPath(lines, previous, origin, destination);
			int costTime = Dijkstra.getCost(lines, previous, origin, destination);
			
			String finalResult = String.valueOf(result);
			System.out.println(finalResult);
			System.out.println(costTime);
			
			searchResults.setText("The path from: " + startLocation + " to " + endLocation + " is: " + "\n" + finalResult + "\n" + ""
					+ "With time:  " + costTime);
			
		});
		
		Button backButton = new Button();
		backButton.setText("Back to Menu");
		backButton.setOnAction(e -> Experimental.setScene(choices));
		
		Label topSearch = new Label("Choose starting location and destination:");
		topSearch.getStyleClass().add("label-info");
		
		VBox searchLayout = new VBox(20);
		searchLayout.getChildren().addAll(topSearch, startLoc, endLoc, startSearch, backButton, searchResults);
		searchLayout.setAlignment(Pos.CENTER);
		
		Scene searchScene = new Scene(searchLayout, 800, 400);
		searchScene.getStylesheets().add("SearchWindow.css");
		
		addChoices.setOnAction(e -> {
					
					if(choice1.isSelected() == true){
						System.out.println("First option is selected");
						lines.addOption1(lines);
					}
					
					if(choice2.isSelected() == true){
						System.out.println("Second option is selected");
						lines.addOption2(lines);
					}
					
					lines.print();
					
					Experimental.setScene(searchScene);
					
				});
		
		Experimental.setScene(infoPage);
		Experimental.showAndWait();
		
	}
	
	private static String getChoice(ComboBox <String> comboBox){
		String input = comboBox.getValue();
		System.out.println(input);
		return input;
	}
}
