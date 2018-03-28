package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	
	static boolean answer;

	public static boolean dispay(String title){
		
		Stage alertWindow = new Stage();
		
		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		
		Label label = new Label();
		label.setText("Are you sure you want to close the program?");
		
		Button closeButton = new Button();
		closeButton.setText("Yes!");
		closeButton.setMaxWidth(50);
		closeButton.setOnAction(e -> {
			answer = true;
			alertWindow.close();
		});
		
		Button remainButton = new Button();
		remainButton.setText("No!");
		remainButton.setMaxWidth(50);
		remainButton.setOnAction(e -> {
			answer = false;
			alertWindow.close();
		});
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, closeButton, remainButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 300, 150);
		scene.getStylesheets().add("AlertBox.css");
		
		alertWindow.setScene(scene);
		alertWindow.showAndWait();
		
		return answer;
	}
	
	
}
