package io.braver.dev.jfx.multimonitortest;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Monitor {
	
	public Stage stage;
	public Scene scene;
	public VBox root;
	public Label label;
	public Button button;
	
	public Monitor(Screen screen, String title){
		Rectangle2D bounds = screen.getBounds();
		
		this.label = new Label(title);
		
		double wH = bounds.getWidth()/2;
		double hH = bounds.getHeight()/2;
		
		double alertX = bounds.getMinX() + wH;
		double alertY = bounds.getMinY() + hH;
		
		this.button = new Button("Show Alert Box");
		String alertTitle = title + " Alert Box";
		String alertMsg = "This is the alert box for " + title + ". Press close to continue.";
		this.button.setOnAction(e -> AlertBox.display(alertTitle, alertMsg, alertX, alertY));
		
		this.root = new VBox(20);
		this.root.setAlignment(Pos.CENTER);
		this.root.getChildren().addAll(label,button);
		
		this.scene = new Scene(root,bounds.getWidth(),bounds.getHeight());
		
		this.stage = new Stage();
		this.stage.setX(bounds.getMinX());
		this.stage.setY(bounds.getMinY());
		this.stage.setTitle(title);
		this.stage.setMaximized(true);
		this.stage.setScene(this.scene);
		this.stage.setTitle(title);
	}
	
	public void show(){
		this.stage.show();
	}

}
