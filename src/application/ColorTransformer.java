package application;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	Color apply(int x, int y, Color t);
}
