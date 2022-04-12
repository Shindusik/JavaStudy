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

public class RootController37 implements Initializable {
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label lblWorkdone;
	@FXML
	private Button btnStart;
	@FXML
	private Button btnStop;
	@FXML
	private Label lblResult;

	private Task<Integer> task;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(event -> handleBtnStart(event));
		btnStop.setOnAction(event -> handleBtnStop(event));
	}

	public void handleBtnStart(ActionEvent event) {
		task = new Task<Integer>() {
			@Override
			protected Integer call() throws Exception {
				int result = 0;
				for (int i = 0; i <= 100; i++) {
					if (isCancelled()) {
						break;
					}
					result += i;
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						if (isCancelled()) {
							break;
						}
					}
				}
				return result;
			}

			@Override
			protected void succeeded() {
				lblResult.setText(String.valueOf(getValue()));
			}

			@Override
			protected void cancelled() {
				lblResult.setText("취소됨");
			}

			@Override
			protected void failed() {
				lblResult.setText("실패");
			}
		};

		progressBar.progressProperty().bind(task.progressProperty());
		lblWorkdone.textProperty().bind(task.messageProperty());
		lblResult.setText("");

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}

	public void handleBtnStop(ActionEvent event) {
		task.cancel();
	}

}
