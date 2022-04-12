package ch17;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController36 implements Initializable {
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label lblWorkdone;
	@FXML
	private Button btnStart;
	@FXML
	private Button btnStop;

	private Task<Void> task;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(event -> handleBtnStart(event));
		btnStop.setOnAction(event -> handleBtnStop(event));
	}

	public void handleBtnStart(ActionEvent event) {
		task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				for (int i = 0; i <= 100; i++) {
					if (isCancelled()) {
						updateMessage("취소됨");
						break;
					}
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						if (isCancelled()) {
							updateMessage("취소됨");
							break;
						}
					}
				}
				return null;
			}
		};

		progressBar.progressProperty().bind(task.progressProperty());
		lblWorkdone.textProperty().bind(task.messageProperty());

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}

	public void handleBtnStop(ActionEvent event) {
		task.cancel();
	}

}
