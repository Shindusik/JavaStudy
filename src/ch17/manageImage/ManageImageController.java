package ch17.manageImage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ManageImageController implements Initializable {
	@FXML
	private ImageView imageView;
	@FXML
	private StackPane stackPane;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double posX = event.getX();
				double posY = event.getY();
				
				System.out.println(posX + ", " + posY);
				
				// image 삽입
//				ImageView imgView = new ImageView();
//				imgView.setImage(new Image(getClass().getResource("../images/duke.gif").toString()));
//				stackPane.getChildren().add(imgView);
//				imgView.setTranslateX(posX - stackPane.getWidth() / 2.0);
//				imgView.setTranslateY(posY - stackPane.getHeight() / 2.0);

				// Label 삽입
				Label label = new Label("검사");
				stackPane.getChildren().add(label);
				label.setTranslateX(posX - (stackPane.getWidth() - imageView.getImage().getWidth()) / 2.0);
				label.setTranslateY(posY - (stackPane.getHeight() - imageView.getImage().getHeight()) / 2.0);
			}
		});
	}

	public void handleLoadImage(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		if (selectedFile != null) {
			Image img = new Image(selectedFile.toString());
			imageView.setImage(img);
//			if (img.getWidth() >= img.getHeight()) {
//				imageView.setFitWidth(stackPane.getWidth());
//			} else {
//				imageView.setFitHeight(stackPane.getHeight());
//			}
		}
	}

	public void handleCaptureImage(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png"));
		File file = fileChooser.showSaveDialog(primaryStage);
		if (file != null) {
			saveFile(file);
		}
	}

	private void saveFile(File file) {
		WritableImage image = new WritableImage((int) stackPane.getWidth(), (int) stackPane.getHeight());
		stackPane.snapshot(null, image);
		File imageFile = file;
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
