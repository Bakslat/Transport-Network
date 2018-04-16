package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.WeightedMap;
import javafx.geometry.*;

public class SearchWindow {
	
	final static WeightedMap lines = new WeightedMap(82);
	
	public static void display(){
		
		lines.fillMap(lines);
		
		Stage searchWindow = new Stage();
		
		searchWindow.setTitle("Start your search!");
		
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
		startSearch.setMaxWidth(100);
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
			
			searchResults.setText("The fastest route from: " + startLocation + " to " + endLocation + " is: " + "\n" + finalResult + "\n" + ""
					+ "Average time of the Journey:  " + costTime + " minutes");
			
		});
		
		Button backButton = new Button();
		backButton.setText("Back to Menu");
		backButton.setMaxWidth(100);
		backButton.setOnAction(e -> searchWindow.close());
		
		Label top = new Label("Choose starting a location and a destination:");
		top.getStyleClass().add("label-info");
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(top, startLoc, endLoc, startSearch, backButton, searchResults);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 800, 400);
		scene.getStylesheets().add("SearchWindow.css");
		
		searchWindow.setScene(scene);
		searchWindow.showAndWait();
		
	}
	
	private static String getChoice(ComboBox <String> comboBox){
		String input = comboBox.getValue();
		System.out.println(input);
		return input;
	}
	
	
}
