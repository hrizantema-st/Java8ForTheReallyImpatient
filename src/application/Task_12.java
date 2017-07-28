package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Task_12 extends Application {
	/*
	 * 12. Enhance the LatentImage class in Section 3.6, “Laziness,” on page 56,
	 * so that it supports both UnaryOperator<Color> and ColorTransformer. Hint:
	 * Adapt the former to the latter.
	 */
	@Override
	public void start(Stage stage) {
		Image image = new Image("dog.jpg");
		ColorTransformer redFrame = (x, y, color) -> {
			if (x >= 10 && x <= (image.getWidth() - 10) && y >= 10 && y <= (image.getHeight() - 10)) {
				return color;
			} else {
				return Color.RED;
			}
		};

		Image finalImage = LatentImage.from(image).transform(Color::brighter).transform(Color::grayscale)
				.transform(redFrame).toImage();
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(finalImage))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
