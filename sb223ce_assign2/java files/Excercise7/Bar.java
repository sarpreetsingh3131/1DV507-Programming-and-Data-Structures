package sb223ce_assign2.Excercise7;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sb223ce_assign2.Excercise7.ReadFile;

public class Bar extends Application {

	/* Fields */
	private ReadFile readFile = new ReadFile();
	private Text text = new Text("Incorrect Data");

	@Override
	public void start(Stage primaryStage) {
		/* Make panel and button */
		Group root = new Group();
		Button button = new Button("Select File");

		/* Set button on action */
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent event) {
				text.setVisible(false);

				/* Create file chooser and set extensions */
				FileChooser selector = new FileChooser();
				FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				selector.getExtensionFilters().add(extension);
				File file = selector.showOpenDialog(primaryStage);

				/* Set path */
				readFile.setPath(file.getAbsolutePath());

				/* Check if file have correct data */
				try {
					if (readFile.check() == true) {
						text.setVisible(true);
						text.setFont(Font.font(20));
						HBox box = new HBox();
						box.getChildren().add(text);
						primaryStage.setScene(new Scene(box, 200, 200));
						primaryStage.show();

					}
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}

				/* Run this, If data is correct */
				try {
					readFile.readFileText();

					/* Set Data */
					primaryStage.setTitle("Integer bar chart");
					CategoryAxis xAxis = new CategoryAxis();
					NumberAxis yAxis = new NumberAxis();
					BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
					chart.setTitle("Number of integers in the interval [1,100] = " + readFile.getFrom1To100());
					yAxis.setLabel("Number of Integers");
					Series<String, Number> values = new XYChart.Series<>();
					values.setName("Integers");

					/* Methods called */
					values.getData().add(new Data<String, Number>("1-10", readFile.getFrom1To10()));
					values.getData().add(new Data<String, Number>("11 - 20", readFile.getFrom11To20()));
					values.getData().add(new Data<String, Number>("21 - 30", readFile.getFrom21To30()));
					values.getData().add(new Data<String, Number>("31 - 40", readFile.getFrom31To40()));
					values.getData().add(new Data<String, Number>("41 - 50", readFile.getFrom41To50()));
					values.getData().add(new Data<String, Number>("51 - 60", readFile.getFrom51To60()));
					values.getData().add(new Data<String, Number>("61 - 70", readFile.getFrom61To70()));
					values.getData().add(new Data<String, Number>("71 - 80", readFile.getFrom71To80()));
					values.getData().add(new Data<String, Number>("81 - 90", readFile.getFrom81To90()));
					values.getData().add(new Data<String, Number>("91 - 100", readFile.getFrom91To100()));
					values.getData().add(new Data<String, Number>("Other", readFile.getOtherNumber()));

					/* Layout */
					chart.getData().addAll(values);
					Scene scene = new Scene(chart, 800, 500);
					primaryStage.setScene(scene);
					primaryStage.show();
				}

				catch (FileNotFoundException e) {

					e.printStackTrace();
				}
			}
		});

		/* Layout */
		button.setLayoutX(55);
		button.setLayoutY(170);
		root.getChildren().add(button);
		primaryStage.setScene(new Scene(root, 200, 200));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}