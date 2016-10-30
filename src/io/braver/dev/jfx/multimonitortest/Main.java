package io.braver.dev.jfx.multimonitortest;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{
	ArrayList<Monitor> monitors = new ArrayList<Monitor>();
	public Stage movable;
	public Scene scene;
	public VBox root;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		root = new VBox();
		root.setAlignment(Pos.CENTER);
		movable = new Stage();
		
		int index = 1;
		for(Screen screen : Screen.getScreens()){
			Rectangle2D bounds = screen.getVisualBounds();
			
			String title = "Screen " + index++;			
			monitors.add(new Monitor(screen, title));
			
			Button btn = new Button("Move to " + title);
			btn.setOnAction(e -> {
				movable.setX(bounds.getMinX() + 200);
				movable.setY(bounds.getMinY() + 200);
			});
			
			root.getChildren().add(btn);
		}
		
		scene = new Scene(root, 250, 400);
		movable.setTitle("Screen Jumper");
        movable.setScene(scene);
        movable.show();
        
        for(Monitor m : monitors){
        	m.show();
        }
		
		
	}
	

}
