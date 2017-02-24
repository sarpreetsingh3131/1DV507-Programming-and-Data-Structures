package sb223ce_assign2.Bouncing;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BouncingMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// call the class
		MovingBall ball = new MovingBall();

		// set the panes
		BorderPane pane = new BorderPane();
		Button btn = new Button("More Balls");
		HBox hBox = new HBox(10);

		hBox.getChildren().addAll(btn);
		hBox.setAlignment(Pos.CENTER);

		// set action event to the button
		btn.setOnAction(e -> ball.addBall());

		pane.setCenter(ball);
		pane.setBottom(hBox);

		// Create scene
		Scene scene = new Scene(pane, 700, 500);
		stage.setTitle("Bounce the ball");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
