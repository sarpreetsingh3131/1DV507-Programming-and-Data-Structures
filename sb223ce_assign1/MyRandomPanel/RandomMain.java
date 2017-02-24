package sb223ce_assign1.MyRandomPanel;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class RandomMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		RandomPanel a = new RandomPanel();

		Scene scene = new Scene(a, 170, 150);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
