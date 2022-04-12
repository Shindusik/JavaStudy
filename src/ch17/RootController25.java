package ch17;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RootController25 implements Initializable {
	@FXML
	private TextArea textArea;
	@FXML
	private ComboBox<String> comboBox;
	
	private Stage primaryStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.setItems(FXCollections.observableArrayList("공개", "비공개"));
		comboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.equals("공개")) {
					textArea.appendText("공개를 선택하셨습니다.\n");
				} else {
					textArea.appendText("비공개를 선택하셨습니다.\n");
				}
			}
		});
	}

	public void handleNew(ActionEvent e) {
		textArea.appendText("New\n");
	}

	public void handleOpen(ActionEvent e) {
		textArea.appendText("Open\n");
	}

	public void handleSave(ActionEvent e) {
		textArea.appendText("Save\n");
	}

	public void handleDelete(ActionEvent e) {
//		textArea.deleteText(textArea.getSelection());
		textArea.setText(null);
	}

	public void handleExit(ActionEvent e) {
		Platform.exit();
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}
