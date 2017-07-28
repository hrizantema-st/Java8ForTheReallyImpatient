package application;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * 5. Here is a concrete example of a ColorTransformer. We want to put a
 * frame around an image. First, implement a variant of the transform method
 * of Section 3.3, “Choosing a Functional Interface,” on page 50, with a
 * ColorTransformer instead of an UnaryOperator<Color>. Then call it with an
 * appropriate lambda expression to put a 10 pixel gray frame replacing the
 * pixels on the border of an image.
 */
public class Task_5_6_8 extends Application {
	@Override
	public void start(Stage stage) {
		Image image = new Image("dog.jpg");
		Image newImage = transform(image, (x, y, color) -> {
			if (x >= 10 && x <= (image.getWidth() - 10) && y >= 10 && y <= (image.getHeight() - 10)) {
				return color;
			} else {
				return Color.GRAY;
			}
		});

		Image brightenedImage2 = transform2(image, (c, factor) -> c.deriveColor(0, 1, factor, 1), 20);
		
		ColorTransformer redColorTransformer = brighten(image, 30, Color.BISQUE);
		Image newImage2 = transform(image, redColorTransformer);
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

	/*
	 * 6. Complete the method public static <T> Image transform(Image in,
	 * BiFunction<Color, T> f, T arg) from Section 3.4, “Returning Functions,”
	 * on page 53.
	 */
	public static <T> Image transform2(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
		return out;
	}

	public static UnaryOperator<Color> brighten(double factor) {
		return c -> c.deriveColor(0, 1, factor, 1);
	}

	/*
	 * 8. Generalize Exercise 5 by writing a static method that yields a
	 * ColorTransformer that adds a frame of arbitrary thickness and color to an
	 * image.
	 */
	public static ColorTransformer brighten(final Image image, final int thickness, final Color color) {
		return (x, y, c) -> {
			if (x >= thickness && x <= (image.getWidth() - thickness) && y >= thickness
					&& y <= (image.getHeight() - thickness)) {
				return c;
			} else {
				return color;
			}
		};
	}
}
