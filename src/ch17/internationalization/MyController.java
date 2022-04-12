package ch17.internationalization;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyController implements Initializable {
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private Button korButton;
	@FXML
	private Button engButton;

	private ResourceBundle bundle;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bundle = resources;
		label1.setText(bundle.getString("key1"));
		label2.setText(bundle.getString("key2"));
	}

	public void handleKor(ActionEvent e) throws Exception {
		ResourceBundle bundle = ResourceBundle.getBundle("ch17.internationalization.Lang", new Locale("ko", "KR"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyView.fxml"), bundle);
		Parent root = fxmlLoader.load();

		MyController controller = fxmlLoader.getController();
		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setTitle(bundle.getString("multi")); // 다국어 적용
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void handleEng(ActionEvent e) throws Exception {
		ResourceBundle bundle = ResourceBundle.getBundle("ch17.internationalization.Lang", new Locale("en", "US"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyView.fxml"), bundle);
		Parent root = fxmlLoader.load();

		MyController controller = fxmlLoader.getController();
		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setTitle(bundle.getString("multi")); // 다국어 적용
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
