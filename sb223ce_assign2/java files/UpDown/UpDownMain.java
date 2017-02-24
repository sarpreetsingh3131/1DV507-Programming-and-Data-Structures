package sb223ce_assign2.UpDown;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class UpDownMain extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		/* Class */
		UpDownPane a = new UpDownPane();

		/* set root pane and view layout */
		Group layout = new Group();
		layout.getChildren().add(a.getView());
		a.getView().setLayoutX(265);
		a.getView().setLayoutY(259);

		Scene scene = new Scene(layout, 560, 560);

		/*
		 * As the scene height and length is 210, and I am shifting the logo +-7
		 * to all sides. I found the boundary points where the logo gets
		 * disappear. For this, I am decreasing the boundary point from scence
		 * height and length.
		 */

		scene.setOnKeyPressed(e -> {

			if (e.getCode() == KeyCode.UP) {
				a.getView().setLayoutY(a.getView().getLayoutY() - 7);

				if (a.getView().getLayoutY() == -7) {
					a.getView().setLayoutY(scene.getHeight() - 7);
				}
			} else if (e.getCode() == KeyCode.DOWN) {
				a.getView().setLayoutY(a.getView().getLayoutY() + 7);

				if (a.getView().getLayoutY() == 560) {
					a.getView().setLayoutY(scene.getHeight() - 560);
				}
			} else if (e.getCode() == KeyCode.LEFT) {
				a.getView().setLayoutX(a.getView().getLayoutX() - 7);

				if (a.getView().getLayoutX() == -8) {
					a.getView().setLayoutX(scene.getHeight() - 8);
				}

			} else if (e.getCode() == KeyCode.RIGHT) {
				a.getView().setLayoutX(a.getView().getLayoutX() + 7);

				if (a.getView().getLayoutX() == 559) {
					a.getView().setLayoutX(559 - scene.getHeight());
				}
			}

		});

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
