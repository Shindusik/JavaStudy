package ch17;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		Label label = new Label();
		label.setText("Hello, JavaFX");
		label.setFont(new Font(50));
		
		Button button = new Button();
		button.setText("확인");
		button.setOnAction(event->Platform.exit());
		
//		root.getChildren().add(label);
//		root.getChildren().add(button);
		
		// 아래와 같이 처리 가능
		ObservableList<Node> list = root.getChildren();
		list.add(label);
		list.add(button);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("AppMain3");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
