package java8ex3;

import java.util.Objects;
import java.util.function.Function;

public class Task_10 {
	/*
	 * 10. Why can’t one call UnaryOperator op = Color::brighter; Image
	 * finalImage = transform(image, op.compose(Color::grayscale)); Look
	 * carefully at the return type of the compose method of UnaryOperator<T>.
	 * Why is it not appropriate for the transform method? What does that say
	 * about the utility of structural and nominal types when it
	 * comes to function composition?
	 */

	/*
	 *  default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
	 */
}
