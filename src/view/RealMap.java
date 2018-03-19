package view;

import javafx.stage.*;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RealMap {
	
	public static void display(){
	
		Stage mapWindow = new Stage();
		mapWindow.setTitle("Map");
		
		StackPane layoutPicture = new StackPane();
		
	    Button backButton = new Button();
	    backButton.setText("Back to Main Screen");
	    backButton.setOnAction(e -> mapWindow.close());
	    
	    VBox bottomLayout = new VBox(1);
	    bottomLayout.getChildren().add(backButton);
	    bottomLayout.setAlignment(Pos.CENTER);
	    
		BorderPane mainLayout = new BorderPane();
	    mainLayout.setCenter(layoutPicture);
	    mainLayout.setBottom(bottomLayout);
	    mainLayout.setTop(null);
	    mainLayout.setPadding(new Insets(0,0,20,0));
	    
	    Image image = new Image("file:///C:/Users/PC-Admin/git/Transport-Network/MapReal.png");
	    //Image image = new Image("file:///home/k1502723/git/Transport-Network/MapReal.png");
	    ImageView imgview = new ImageView(image);
		
	    layoutPicture.getChildren().add(imgview);
		
		Scene scene = new Scene(mainLayout, 850, 900);
		scene.getStylesheets().add("MapWindow.css");
		
		mapWindow.setScene(scene);
		mapWindow.showAndWait();
		
		
	}
	
	
}
