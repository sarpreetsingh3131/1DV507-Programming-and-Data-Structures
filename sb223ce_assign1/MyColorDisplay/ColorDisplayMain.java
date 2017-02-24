package sb223ce_assign1.MyColorDisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorDisplayMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ColorDisplay a = new ColorDisplay();

		Scene scene = new Scene(a.getParent(), 300, 250);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
