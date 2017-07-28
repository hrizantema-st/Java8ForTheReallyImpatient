package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
	/*
	 * 12. Enhance the LatentImage class in Section 3.6, “Laziness,” on page 56,
	 * so that it supports both UnaryOperator<Color> and ColorTransformer. Hint:
	 * Adapt the former to the latter.
	 */
	private Image in;
	private List<ColorTransformer> pendingOperations;

	private LatentImage(Image in) {
		super();
		this.in = in;
		this.pendingOperations = new ArrayList<ColorTransformer>();
	}

	private ColorTransformer unaryOperatorToColorTransformer(final UnaryOperator<Color> unaryOperator) {
		return ((x, y, c) -> unaryOperator.apply(c));
	}
	
	public LatentImage transform(final ColorTransformer f) {
		pendingOperations.add(f);
		return this;
	}
	
	public LatentImage transform(final UnaryOperator<Color> f) {
		pendingOperations.add(unaryOperatorToColorTransformer(f));
		return this;
	}

	public static LatentImage from(final Image image) {
		return new LatentImage(image);
	}
	

	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (ColorTransformer f : pendingOperations)
					c = f.apply(x, y, c);
				out.getPixelWriter().setColor(x, y, c);
			}
		return out;
	}
}
