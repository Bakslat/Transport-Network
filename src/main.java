
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.AlertBox;
import javafx.scene.control.Label;

import dijkstra.Dijkstra;
import dijkstra.TubeMap;
import dijkstra.WeightedMap;
import view.AlertBox;

public class main extends Application implements EventHandler<ActionEvent> {
	
	Button startSearchButton;
	Scene secondPage;
	
	final static WeightedMap lines = new WeightedMap(55);

	public static void main(String[] args) throws FileNotFoundException {
		
		lines.fillMap(lines);
		TubeMap map = new TubeMap("Map.txt");
		System.out.println(map.getLines());
		
		//Print the map
		lines.print();
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Stage window = primaryStage;
		
		Button goToSearchButton = new Button();
		goToSearchButton.setText("Start using our Search!");
		goToSearchButton.setOnAction(e -> window.setScene(secondPage));
		Button closeButton = new Button();
		closeButton.setText("Close the Application");
		
		closeButton.setOnAction(e -> {
			boolean result = AlertBox.dispay("Confirmation");
			if (result == true){
				window.close();
			} 
		});
		
		Label mainLabel = new Label("Welcome to Burrow Map");
		
		VBox layoutMain = new VBox(20);
		layoutMain.getChildren().addAll(mainLabel, goToSearchButton, closeButton);
		Scene mainPage = new Scene(layoutMain, 800, 600);
		
		startSearchButton = new Button();
		startSearchButton.setText("Start the Search!");
		startSearchButton.setOnAction(this);
		Button backToMain = new Button();
		backToMain.setText("Return to Main Screen");
		backToMain.setOnAction(e -> window.setScene(mainPage));
		Label secondLabel = new Label ("Search screen");
		
		VBox layoutSecond = new VBox(20);
		layoutSecond.getChildren().addAll(secondLabel, startSearchButton, backToMain);
		secondPage = new Scene(layoutSecond, 600, 300);
		
		window.setOnCloseRequest(e -> {
			e.consume();
			boolean result = AlertBox.dispay("Confirmation");
			if (result == true){
				window.close();
			}
		});
		
		window.setScene(mainPage);
		window.setTitle("Burrow Map");
		window.show();
	}
	
	//Scanner scan = new Scanner(System.in);
	int start = 25; // Tottenham Court Road
	int end = 11; //Waterloo
	
	@Override
	public void handle(ActionEvent event){
		if(event.getSource() == startSearchButton){
			final int [] previous = Dijkstra.dijkstra(lines, start);
			System.out.println("Searching: ````````````````````````````````````````````````");
			for(int nodes = 0; nodes < 55; nodes++){
				Dijkstra.printJourney(lines, previous, start, nodes);
				
			//Dijkstra.printJourney(lines, previous, start, end);
			}
		}
	}

}