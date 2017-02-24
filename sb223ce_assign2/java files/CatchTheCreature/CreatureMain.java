package sb223ce_assign2.CatchTheCreature;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreatureMain extends Application {

	@Override
	public void start(Stage stage) {

		/*Call the constructor and set the stage*/
		Creature creature = new Creature();

		Scene scene = new Scene(creature.getRoot());
		stage.setScene(scene);
		stage.setTitle("Catch the Creature");
		stage.setWidth(850);
		stage.setHeight(700);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
