package ch17.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@FXML
	private TableView tableView;
	@FXML
	private Button btnAdd;
	@FXML
	private Button barGraph;

	private ObservableList<Student> list;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = FXCollections.observableArrayList();

		TableColumn tc = (TableColumn) tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc.setStyle("-fx-alignment: CENTER");

		tc = (TableColumn) tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("korean"));
		tc.setStyle("-fx-alignment: CENTER");

		tc = (TableColumn) tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("math"));
		tc.setStyle("-fx-alignment: CENTER");

		tc = (TableColumn) tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("english"));
		tc.setStyle("-fx-alignment: CENTER");

		tableView.setItems(list);
		tableView.setOnMouseClicked(event -> handleTableViewMouseClicked(event));

		btnAdd.setOnAction(event -> handleBtnAddAction(event));
		barGraph.setOnAction(event -> handleBtnBarGraphAction(event));
	}

	private void handleTableViewMouseClicked(MouseEvent event) {
		if (event.getClickCount() != 2) {
			return;
		}
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Piechart.fxml"));

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(tableView.getScene().getWindow());
			dialog.setTitle("파이 그래프");

			PieChart piechart = (PieChart) root.lookup("#piechart");

			Student student = (Student) tableView.getSelectionModel().getSelectedItem();
			piechart.setData(FXCollections.observableArrayList(new PieChart.Data("국어", student.getKorean()),
					new PieChart.Data("수학", student.getMath()), new PieChart.Data("영어", student.getEnglish())));

			Button btnClose = (Button) root.lookup("#btnClose");
			btnClose.setOnAction(e -> dialog.close());

			Scene secne = new Scene(root);
			dialog.setScene(secne);
			dialog.setResizable(false);
			dialog.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleBtnBarGraphAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Barchart.fxml"));

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("막대 그래프");

			BarChart barchart = (BarChart) root.lookup("#barchart");

			XYChart.Series seriesKorean = new XYChart.Series<>();
			seriesKorean.setName("국어");
			ObservableList koreanList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				Student student = list.get(i);
				koreanList.add(new XYChart.Data(student.getName(), student.getKorean()));
			}
			seriesKorean.setData(koreanList);
			barchart.getData().add(seriesKorean);

			XYChart.Series seriesMath = new XYChart.Series<>();
			seriesMath.setName("수학");
			ObservableList mathList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				Student student = list.get(i);
				mathList.add(new XYChart.Data(student.getName(), student.getMath()));
			}
			seriesMath.setData(mathList);
			barchart.getData().add(seriesMath);

			XYChart.Series seriesEnglish = new XYChart.Series<>();
			seriesEnglish.setName("영어");
			ObservableList englishList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				Student student = list.get(i);
				englishList.add(new XYChart.Data(student.getName(), student.getEnglish()));
			}
			seriesEnglish.setData(englishList);
			barchart.getData().add(seriesEnglish);

			Button btnClose = (Button) root.lookup("#btnClose");
			btnClose.setOnAction(e -> dialog.close());

			Scene scene = new Scene(root);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleBtnAddAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("추가");

			Button btnFormAdd = (Button) root.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(e -> {
				TextField txtName = (TextField) root.lookup("#txtName");
				TextField txtKorean = (TextField) root.lookup("#txtKorean");
				TextField txtMath = (TextField) root.lookup("#txtMath");
				TextField txtEnglish = (TextField) root.lookup("#txtEnglish");
				list.add(new Student(txtName.getText(), Integer.parseInt(txtKorean.getText()),
						Integer.parseInt(txtMath.getText()), Integer.parseInt(txtEnglish.getText())));
				dialog.close();
			});

			Button btnFormCancel = (Button) root.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e -> dialog.close());

			Scene scene = new Scene(root);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
