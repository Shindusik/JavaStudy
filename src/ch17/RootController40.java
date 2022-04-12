package ch17;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController40 implements Initializable {
	@FXML
	private Button btnLogin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction(e -> handleBtnLogin(e));
	}

	public void handleBtnLogin(ActionEvent e) {
		// 로그인 화면으로 이동
		try {
			Parent login = FXMLLoader.load(getClass().getResource("Login2.fxml"));
			StackPane root = (StackPane) btnLogin.getScene().getRoot();
			root.getChildren().add(login);

			login.setTranslateX(350); // 시작값을 350으로 설정(로그인 화면의 폭)

			// 종료값을 0으로 설정하고 0.5초간 지속
			Timeline timeline = new Timeline();
			KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
