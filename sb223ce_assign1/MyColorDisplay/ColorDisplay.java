package sb223ce_assign1.MyColorDisplay;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ColorDisplay {

	/* Fields */
	private BorderPane root = new BorderPane();
	private Pane top = new Pane();
	private HBox middle = new HBox();
	private Pane bottom = new Pane();
	private Button btn = new Button("Display Color");
	private VBox partOne = new VBox();
	private VBox partTwo = new VBox();
	private VBox partThree = new VBox();
	private Text redText = new Text("Red");
	private Text greenText = new Text("Green");
	private Text blueText = new Text("Blue");
	private Text error = new Text("Incorrect Value");
	private TextField red = new TextField("");
	private TextField green = new TextField("");
	private TextField blue = new TextField("");
	private int redInput;
	private int blueInput;
	private int greenInput;
	private Label label = new Label("Color Display");

	/* Constructor */
	public ColorDisplay() {

		/* set text fields */
		red.setPrefWidth(100);
		green.setPrefWidth(100);
		blue.setPrefWidth(100);
		error.setFont(Font.font(20));
		error.setFill(Color.RED);

		/* Methods calling */
		paneSettings();
		buttonSettings();
		vboxSettings();
		takeAction();

		/* Setting the root pane */
		root.setPrefSize(300, 250);
		root.setTop(top);
		root.setCenter(middle);
		root.setBottom(bottom);

	}

	public Parent getParent() {
		return root;
	}

	private void paneSettings() {

		/* Fix the size and color of panes */
		top.setPrefSize(300, 100);
		label.setFont(Font.font(20));
		top.getChildren().add(label);
		label.setLayoutX(80);
		label.setLayoutY(30);

		middle.setPrefSize(300, 100);
		bottom.setPrefSize(200, 50);
		bottom.getChildren().add(error); // add error text in the bottom pane

		error.setLayoutX(75);
		error.setLayoutY(-20);
		error.setVisible(false); // set invisible in the beginning
	}

	private void buttonSettings() {

		/* Fix the button setting and add it in the bottom pane */
		btn.setFont(Font.font(14));
		btn.setLayoutX(100);
		btn.setLayoutY(15);
		bottom.getChildren().add(btn);
	}

	private void vboxSettings() {

		/*
		 * These boxes will go in middle pane, these panes contains text fields
		 * and text
		 */
		partOne.getChildren().addAll(redText, red);
		partOne.setPadding(new Insets(0, 0, 0, 10));

		partTwo.getChildren().addAll(greenText, green);
		partTwo.setPadding(new Insets(0, 0, 0, 60));

		partThree.getChildren().addAll(blueText, blue);
		partThree.setPadding(new Insets(0, 0, 0, 70));

		middle.setPadding(new Insets(5, 5, 5, 5));
		middle.getChildren().addAll(partOne, partTwo, partThree);

	}

	private void takeAction() {
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				try {

					/* Check if text fields only contain digits */
					if (checkValue(red.getText()) && checkValue(green.getText())
							&& checkValue(blue.getText()) == true) {

						/* Assign their values to the field variables */
						redInput = Integer.valueOf(red.getText());
						greenInput = Integer.valueOf(green.getText());
						blueInput = Integer.valueOf(blue.getText());

						/* Again check if their value is in the limit */
						if (redInput >= 0 && redInput <= 255 && greenInput >= 0 && greenInput <= 255 && blueInput >= 0
								&& blueInput <= 255) {
							error.setVisible(false);

							/* display color */
							top.setBackground(new Background(
									new BackgroundFill(Color.rgb(redInput, greenInput, blueInput), null, null)));

						} else
							error.setVisible(true);
					} else
						error.setVisible(true);
				}

				catch (Exception q) {
					error.setVisible(true);
				}
			}

		});
	}

	/* Check if the input value carry any alphabetic */
	private boolean checkValue(String a) {
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (Character.isAlphabetic(c)) {
				return false;
			}
		}
		return true;

	}

}