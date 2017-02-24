package sb223ce_assign1.Question10;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sb223ce_assign1.LanguageTool.Error;

public class LanguageTool extends Application {

	/* Fields */
	private BorderPane root = new BorderPane();
	private Button selectFileButton = new Button("Select File");
	private Button exitButton = new Button("Exit");
	private Button messageButton = new Button("Show Short Messages");
	private Button suggestionButton = new Button("Show Suggestions");
	private Button issuesButton = new Button("Show Issues");
	private Button mainButton = new Button("Show All");
	private Label text = new Label("Text display");
	private Label mistakes = new Label("Errors display");
	private ScrollPane scroll1 = new ScrollPane(text);
	private ScrollPane scroll2 = new ScrollPane(mistakes);
	private StackPane pane1 = new StackPane();
	private StackPane pane2 = new StackPane();
	private HBox hbox = new HBox();
	private File file = null;
	private Stage scene;
	private Error error; // class

	@Override
	public void start(Stage primaryStage) {
		scene = primaryStage;

		paneSetting(); // methods
		HboxSetting();
		scrollPane();
		fileChooser();

		/* Set layout */
		root.setTop(pane1);
		root.setCenter(pane2);
		root.setBottom(hbox);

		/* First scene */
		Scene scene = new Scene(menu(), 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private void HboxSetting() {
		hbox.getChildren().addAll(selectFileButton, messageButton, suggestionButton, issuesButton, mainButton,
				exitButton);
		buttonSettings();
	}

	/* Button setting and their actions */
	private void buttonSettings() {
		selectFileButton.setTranslateX(300);

		messageButton.setTranslateX(310);
		messageButton.setOnMouseClicked(e -> {
			try {
				if (error.getNumberOfMistakes() > 0)
					mistakes.setText(error.getMessage());
			} catch (Exception e1) {
				mistakes.setText("No file selected.");
			}
		});

		suggestionButton.setTranslateX(320);
		suggestionButton.setOnMouseClicked(e -> {
			try {
				if (error.getNumberOfMistakes() > 0)
					mistakes.setText(error.getSuggestions());
			} catch (Exception e1) {
				mistakes.setText("No file selected.");
			}
		});

		issuesButton.setTranslateX(330);
		issuesButton.setOnMouseClicked(e -> {
			try {
				if (error.getNumberOfMistakes() > 0)
					mistakes.setText(error.getIssues());
			} catch (Exception e1) {
				mistakes.setText("No file selected.");
			}
		});

		mainButton.setTranslateX(340);
		mainButton.setOnMouseClicked(e -> {
			try {
				if (error.getNumberOfMistakes() > 0)
					mistakes.setText(error.getMistakes());
			} catch (Exception e1) {
				mistakes.setText("No file selected.");
			}
		});

		exitButton.setTranslateX(350);
		exitButton.setOnAction(e -> System.exit(0)); // just exit the program

	}

	private void paneSetting() {
		pane1.setPrefSize(1200, 250);
		pane1.setPadding(new Insets(10, 10, 10, 10));
		pane1.getChildren().addAll(text, scroll1);

		pane2.setPrefSize(1150, 250);
		pane2.setPadding(new Insets(10, 10, 10, 10));
		pane2.getChildren().addAll(mistakes, scroll2);

		text.setPrefWidth(1150);
		text.setPadding(new Insets(10, 10, 10, 10));
		text.setWrapText(true);
		text.setAlignment(Pos.TOP_LEFT);

		mistakes.setPadding(new Insets(10, 10, 10, 10));
		mistakes.setWrapText(true);
		mistakes.setAlignment(Pos.TOP_LEFT);

	}

	private void scrollPane() {
		scroll1.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll1.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll1.setFitToWidth(true);

		scroll2.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll2.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll2.setFitToWidth(true);
	}

	private void fileChooser() {

		selectFileButton.setOnMouseClicked(e -> {

			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extension);
			file = fileChooser.showOpenDialog(new Stage());

			try {
				error = new Error(file.getAbsolutePath()); // call the class
				error.check();
				text.setText(error.getCheckedText()); // update
				mistakes.setText(error.getNumberOfMistakes()
						+ " mistake/s found. Please press appropriate button to see the mistakes description.");
			} catch (Exception e1) {
				text.setText("No Text Selected"); // show error message
				mistakes.setText("No error to show");
				error = new Error();

			}
		});
	}

	/* Menu in the beginning of the program */
	private Parent menu() {
		Pane layout1 = new Pane();
		Rectangle rg = new Rectangle(1280, 720);

		Button start = new Button("Start Program");
		start.setFont(Font.font(70));
		start.setOnAction(event -> startApplication()); // change scene

		Button end = new Button("Exit Program");
		end.setFont(Font.font(70));
		end.setOnAction(event -> System.exit(0));

		VBox vbox = new VBox(50, start, end);
		vbox.setTranslateX(400);
		vbox.setTranslateY(200);
		layout1.getChildren().addAll(rg, vbox);

		return layout1;
	}

	/* Second Scene */
	private void startApplication() {
		Scene scene = new Scene(root, 1200, 600);
		this.scene.setScene(scene);
		this.scene.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
}