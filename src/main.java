
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.AlertBox;
import view.RealMap;
import view.SearchWindow;
import javafx.scene.control.Label;

import dijkstra.Dijkstra;
import dijkstra.TubeMap;
import dijkstra.WeightedMap;

public class main extends Application implements EventHandler<ActionEvent> {
	
	Button startSearchButton;
	Scene secondPage;
	
	final static WeightedMap lines = new WeightedMap(82);

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
		
		//Close Button
		Button closeButton = new Button();
		closeButton.setText("Close the Application");
		closeButton.setOnAction(e -> {
			boolean result = AlertBox.dispay("Confirmation");
			if (result == true){
				window.close();
			} 
		});
		
		
		Label mainLabel = new Label("Welcome to Burrow Map");
		Label infoCreator = new Label("The program is created by Kristiyan Kalchev");
		infoCreator.getStyleClass().add("label-info");
		
		
		BorderPane mainPane = new BorderPane();
		
		VBox centreMain = new VBox(20);
		centreMain.getChildren().addAll(mainLabel, goToSearchButton, closeButton);
		centreMain.setAlignment(Pos.CENTER);
		
		HBox bottMain = new HBox (1);
		bottMain.getChildren().add(infoCreator);
		
		mainPane.setCenter(centreMain);
		mainPane.setBottom(bottMain);
		mainPane.setPadding(new Insets(0,10,10,10));
		
		Scene mainPage = new Scene(mainPane, 600, 300);
		
		startSearchButton = new Button();
		startSearchButton.setText("Start the Search!");
		
		startSearchButton.setOnAction(e -> {
			window.hide();
			SearchWindow.display();
			window.show();
		});
		
		//Back Button
		Button backToMain = new Button();
		backToMain.setText("Return to Main Screen");
		backToMain.setOnAction(e -> window.setScene(mainPage));
		
		//Map Button
		Button mapShow = new Button();
		mapShow.setText("Show Map");
		mapShow.setOnAction(e -> {
			window.hide();
			RealMap.display();
			window.show();
		});
		
		Label secondLabel = new Label ("Search screen");
		
		VBox layoutSecond = new VBox(20);
		layoutSecond.getChildren().addAll(secondLabel, startSearchButton, mapShow, backToMain);
		layoutSecond.setAlignment(Pos.CENTER);
		secondPage = new Scene(layoutSecond, 600, 300);
		
		window.setOnCloseRequest(e -> {
			e.consume();
			boolean result = AlertBox.dispay("Confirmation");
			if (result == true){
				window.close();
			}
		});	
		
		mainPage.getStylesheets().add("MainTheme.css");
		secondPage.getStylesheets().add("MainTheme.css");
		
		window.setScene(mainPage);
		window.setTitle("Burrow Map");
		window.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}