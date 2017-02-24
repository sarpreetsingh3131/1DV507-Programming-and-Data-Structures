package sb223ce_assign2.CatchTheCreature;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Creature {
	/* Fields */
	private Image image;
	private ImageView view;
	private Label label = new Label("Caught:  ");
	private final StackPane stack = new StackPane();
	private BorderPane root = new BorderPane();
	private Text text = new Text("0");
	private HBox hbox = new HBox();
	private Timeline timeline = new Timeline();
	private EventHandler<ActionEvent> move;

	/* Constructor */
	public Creature() {

		/* Initializing the fields */
		image = new Image(getClass().getResourceAsStream("snuf.jpg"));
		view = new ImageView();
		view.setImage(image);
		view.setFitWidth(40);
		view.setFitHeight(40);
		view.setPreserveRatio(true);
		view.setSmooth(true);

		label.setFont(Font.font(18));
		text.setFont(Font.font(18));

		hbox.getChildren().addAll(label, text);
		hbox.setPrefSize(50, 50);
		hbox.setAlignment(Pos.BOTTOM_CENTER);

		stack.getChildren().addAll(view);
		stack.setPrefSize(450, 450);
		stack.setAlignment(Pos.TOP_LEFT);

		root.setTop(stack);
		root.setBottom(hbox);
		root.setPrefSize(500, 500);

		/* Set timer */
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);

		/* Make the creature bigger and smaller */
		KeyValue keyValueX = new KeyValue(view.scaleXProperty(), 0);
		KeyValue keyValueY = new KeyValue(view.scaleYProperty(), 0);

		/* Speed */
		Duration duration = Duration.millis(1000);

		/* Methods */
		moveCreature();
		click();

		KeyFrame key = new KeyFrame(duration, move, keyValueX, keyValueY);

		/* Add to time line and play it */
		timeline.getKeyFrames().add(key);
		timeline.setAutoReverse(true);
		timeline.play();

	}

	/* Getter */

	public BorderPane getRoot() {
		return root;
	}

	private void moveCreature() {
		move = new EventHandler<ActionEvent>() {

			/* Change the creature position */
			Random rand = new Random();

			public void handle(ActionEvent t) {

				/*
				 * Generate random numbers and change the X, Y position of
				 * creature
				 */
				stack.setTranslateX(rand.nextInt(500));

				stack.setTranslateY(rand.nextInt(500));

			}
		};
	}

	private void click() {

		view.setOnMouseClicked(e -> {

			/* Change the text whenever the creature will be clicked */
			int s = Integer.valueOf(text.getText());
			int count = s + 1;
			text.setText("" + count);
		});

	}

}
