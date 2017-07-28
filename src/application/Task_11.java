package application;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Task_11 extends Application {
	/*
	 * 11. Implement static methods that can compose two ColorTransformer
	 * objects, and a static method that turns a UnaryOperator<Color> into a
	 * ColorTransformer that ignores the x- and y-coordinates. Then use these
	 * methods to add a gray frame to a brightened image. (See Exercise 5 for
	 * the gray frame.)
	 */

	@Override
	public void start(Stage stage) {
		Image image = new Image("dog.jpg");
		ColorTransformer grayFrame = (x, y, color) -> {
			if (x >= 10 && x <= (image.getWidth() - 10) && y >= 10 && y <= (image.getHeight() - 10)) {
				return color;
			} else {
				return Color.GRAY;
			}
		};
		Image newImage2 = transform(image, compose(grayFrame, unaryOperatorToColorTransformer(Color::brighter)));

		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage2))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
		return out;
	}

	public static ColorTransformer compose(ColorTransformer colTransformer1, ColorTransformer colTransformer2) {
		return (x, y, t) -> colTransformer1.apply(x, y, colTransformer2.apply(x, y, t));

	}

	public static ColorTransformer unaryOperatorToColorTransformer(final UnaryOperator<Color> unaryOperator) {
		return ((x, y, c) -> unaryOperator.apply(c));
	}
}
