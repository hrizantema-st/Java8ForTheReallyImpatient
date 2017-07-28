package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * 13. Convolution filters such as blur or edge detection compute a pixel
 * from neighboring pixels.Note that these cannot be implemented lazily, using the approach of
 * Section 3.6, “Laziness,” on page 56, since they require the image from
 * the previous stage (or at least the neighboring pixels) to have been
 * computed. Enhance the lazy image processing to deal with these
 * operations. Force computation of the previous stage when one of these
 * operators is evaluated.
 */
public class Task_13 extends Application {

	private static int[] xCoord = { 0, 0, 0, 1, 1, 1, -1, -1, -1 };
	private static int[] yCoord = { 0, 1, -1, 0, 1, -1, 0, 1, -1 };

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Image image = new Image("dog.jpg");
		Image blurredImage = blur(image);
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(blurredImage))));
		stage.show();
	}

	private static Color average(int x, int y, Image in) {
		double redSum = 0, greenSum = 0, blueSum = 0;
		int numberOfNeighbours = 0;
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		for (int i = 0; i < xCoord.length; i++) {
			for (int j = 0; j < yCoord.length; j++) {
				if (x + xCoord[i] >= 0 && x + xCoord[i] < width && y + yCoord[j] >= 0 && y + yCoord[j] < height) {
					redSum += in.getPixelReader().getColor(x + xCoord[i], y + yCoord[j]).getRed();
					greenSum += in.getPixelReader().getColor(x + xCoord[i], y + yCoord[j]).getGreen();
					blueSum += in.getPixelReader().getColor(x + xCoord[i], y + yCoord[j]).getBlue();
					numberOfNeighbours++;
				}
			}
		}

		return new Color(redSum / (double) numberOfNeighbours, greenSum / (double) numberOfNeighbours,
				blueSum / (double) numberOfNeighbours, 1);
	}

	/*
	 * To blur an image, replace each color value by the average of itself and
	 * its eight neighbors.
	 */
	public static Image blur(final Image in) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, average(x, y, in));
		return out;
	}
}
