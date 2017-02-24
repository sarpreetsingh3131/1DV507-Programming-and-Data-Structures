package sb223ce_assign2.UpDown;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UpDownPane {

	/* Fields */
	private Image image;
	private ImageView view;

	/* Constructor */
	public UpDownPane() {

		/* Initializing the fields */
		image = new Image(getClass().getResourceAsStream("khanda.jpg"));
		view = new ImageView();
		view.setImage(image);

		/* According to the instruction, I am setting the picture to 7 x 7 */
		view.setFitHeight(7);
		view.setFitWidth(7);
		view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setCache(true);

	}

	/* Getter */
	public ImageView getView() {
		return view;
	}

}
