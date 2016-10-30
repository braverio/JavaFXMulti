package io.braver.dev.jfx.multimonitortest;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	public static void display(String title, String message, double x, double y){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Label label = new Label(message);
		Button btn = new Button("Close");
		btn.setOnAction(e -> window.close());
		
		VBox layout = new VBox(15);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label,btn);
		
		double width = 400;
		double height = 150;
		
		Scene scene = new Scene(layout, width, height);
		window.setX(x - width/2);
		window.setY(y - height/2);
		window.setScene(scene);
		window.show();
	}
}
