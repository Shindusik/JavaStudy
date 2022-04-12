package ch17;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class RootController20 implements Initializable {
	@FXML
	private TextField txtTitle;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private ComboBox<String> comboPublic;
	@FXML
	private DatePicker dateExit;
	@FXML
	private TextArea txtContent;

	private ObservableList<String> list = FXCollections.observableArrayList("공개", "비공개");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboPublic.setItems(list);

		String pattern = "yyyy-MM-dd";
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};
		dateExit.setConverter(converter);
		dateExit.setValue(LocalDate.now());
	}

	public void handleBtnRegAction(ActionEvent e) {
		String title = txtTitle.getText();
		System.out.println("title: " + title);

		String password = txtPassword.getText();
		System.out.println("password: " + password);

		String strPublic = comboPublic.getValue();
		System.out.println("public: " + strPublic);

		LocalDate localDate = dateExit.getValue();
		if (localDate != null) {
			System.out.println("dateExit: " + localDate.toString());
		}

		String content = txtContent.getText();
		System.out.println("content: " + content);

	}

	public void handleBtnCancelAction(ActionEvent e) {
		Platform.exit();
	}

}
