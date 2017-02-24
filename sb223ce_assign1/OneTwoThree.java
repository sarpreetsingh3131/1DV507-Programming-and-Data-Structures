package sb223ce_assign1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OneTwoThree extends Application {

	@Override
	public void start(Stage primaryStage) {

		/* Create VBox as a root where everything will go */
		VBox root = new VBox();

		/* Create three panes and set the height */
		Pane pane1 = new Pane();
		Pane pane2 = new Pane();
		Pane pane3 = new Pane();

		pane1.setPrefHeight(100);
		pane2.setPrefHeight(100);
		pane3.setPrefHeight(100);

		/* Create three text and set the font size */
		Text one = new Text(10, 40, "One");
		one.setFont(Font.font(40));

		Text two = new Text(350, 60, "Two");
		two.setFont(Font.font(40));

		Text three = new Text(680, 85, "Three");
		three.setFont(Font.font(40));

		/* Add all three texts in panes */
		pane1.getChildren().add(one);
		pane2.getChildren().add(two);
		pane3.getChildren().add(three);

		/* Set the color of the panes */
		pane1.setStyle("-fx-background-color: orange");
		pane2.setStyle("-fx-background-color: white");
		pane3.setStyle("-fx-background-color: green");

		/* Add all the panes in the root and create the scene */
		root.getChildren().addAll(pane1, pane2, pane3);
		Scene scene = new Scene(root, 800, 300);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}