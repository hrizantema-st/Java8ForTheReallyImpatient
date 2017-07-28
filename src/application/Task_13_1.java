package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Task_13_1 extends Application {

	private static int[] xCoord = { 0, 0, 1, -1 };
	private static int[] yCoord = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Image image = new Image("dog.jpg");
		Image blurredImage = edge(image);
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(blurredImage))));
		stage.show();
	}

	private static Color edgeColor(int x, int y, Image in) {
		Color currentColor = in.getPixelReader().getColor(x, y);
		double red = 4 * currentColor.getRed();
		double green = 4 * currentColor.getGreen();
		double blue = 4 * currentColor.getBlue();
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		for (int i = 0; i < xCoord.length; i++) {
			for (int j = 0; j < yCoord.length; j++) {
				if (x + xCoord[i] >= 0 && x + xCoord[i] < width && y + yCoord[j] >= 0 && y + yCoord[j] < height) {
					red -= in.getPixelReader().getColor(x + xCoord[i], y + yCoord[j]).getRed();
					green -= in.getPixelReader().getColor(x + xCoord[i], y + yCoord[j]).getGreen();
					blue -= in.getPixelReader().getColor(x + xCoord[i], y + yCoord[j]).getBlue();
				}
			}
		}
		red = (red >= 0.0 && red <= 1.0) ? red : 0;
		green = (green >= 0.0 && green <= 1.0) ? green : 0;
		blue = (blue >= 0.0 && blue <= 1.0) ? blue : 0;
		return new Color(red, green, blue, 1);
	}

	/*
	 * For edge detection, replace each color value c with 4c – n – e – s – w,
	 * where the other colors are those of the pixel to the north, east, south,
	 * and west.
	 */
	public static Image edge(final Image in) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, edgeColor(x, y, in));
		return out;
	}

}
