package sb223ce_assign2.Bouncing;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.BROWN;
import static javafx.scene.paint.Color.CHARTREUSE;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.YELLOW;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.util.Duration;

public class MovingBall extends Pane {

	/* Fields */
	private Timeline animation;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private final Color[] COLORS = new Color[] { BROWN, BLUE, BLACK, RED, YELLOW, GREEN, ORANGE, CHARTREUSE };

	public MovingBall() {
		animation();
	}

	public void addBall() {

		// add random generator to change the color
		Random rand = new Random();
		Ball a = new Ball(20, 20, 10, COLORS[rand.nextInt(8)]);
		balls.add(a);
		getChildren().add(a);
	}

	private void move() {
		for (Node node : this.balls) {
			Ball ball = (Ball) node; // change the ball to node

			// Check boundaries
			if (checkX(ball) == true)
				ball.setX(ball.getX() * -1); // change direction

			if (checkY(ball) == true)
				ball.setY(ball.getY() * -1); // Change direction

			// change the position
			ball.setCenterX(ball.getX() + ball.getCenterX());
			ball.setCenterY(ball.getY() + ball.getCenterY());

		}
	}

	// check X axis and Y axis

	private boolean checkX(Ball a) {
		return a.getCenterX() < a.getRadius() || a.getCenterX() > getWidth() - a.getRadius();
	}

	private boolean checkY(Ball a) {
		return a.getCenterY() < a.getRadius() || a.getCenterY() > getHeight() - a.getRadius();
	}

	// set the animation and event handler
	private void animation() {
		animation = new Timeline(new KeyFrame(Duration.millis(10), e -> move()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
}
