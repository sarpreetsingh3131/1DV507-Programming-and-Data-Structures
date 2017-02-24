package sb223ce_assign1.MyRandomPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.Random;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RandomPanel extends BorderPane {

	/*Fields*/
	private Random ran = new Random(100);
	private Button btn = new Button("New Random");
	private Text actiontarget = new Text();

	public RandomPanel() {

		/*Set button on action*/
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				int digit = ran.nextInt(100) + 1;
				actiontarget.setFont(Font.font(digit));
				actiontarget.setText("" + digit);
			}
		});
		
		/*set layout*/
		setCenter(actiontarget);
		setBottom(btn);
		BorderPane.setAlignment(actiontarget, Pos.CENTER);
		BorderPane.setAlignment(btn, Pos.BOTTOM_CENTER);

	}

}
