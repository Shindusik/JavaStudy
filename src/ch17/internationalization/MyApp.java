package ch17.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp extends Application {
	private Locale locale = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 시스템 Locale 정보를 이용해서 초기화
		String userLanguage = System.getProperty("user.language");
		if (userLanguage.equals("ko")) {
			locale = new Locale("ko", "KR");
		} else {
			locale = new Locale("en", "US");
		}
		ResourceBundle bundle = ResourceBundle.getBundle("ch17.internationalization.Lang", locale);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyView.fxml"), bundle);
		Parent root = fxmlLoader.load();

		MyController controller = fxmlLoader.getController();
		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setTitle(bundle.getString("multi"));
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
