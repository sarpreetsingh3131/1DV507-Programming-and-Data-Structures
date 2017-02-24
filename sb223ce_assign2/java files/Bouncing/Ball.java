package sb223ce_assign2.Bouncing;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

	// Fields
	private double x = 2;
	private double y = 2;

	// constructor
	public Ball() {

	}

	public Ball(double x, double y, double radius, Color color) {
		super(x, y, radius, color);

	}

	// getter and setters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
