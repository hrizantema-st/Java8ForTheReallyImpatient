package java8ex3;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 */
public class Pair<L, R> {

	private final L left;
	private R right;

	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	public void setRight(R right) {
		this.right = right;
	}

	@Override
	public int hashCode() {
		return left.hashCode() ^ right.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair))
			return false;
		Pair pairo = (Pair) o;
		return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
	}

	/*
	 * 23. Define a map operation for a class Pair<T> that represents a pair of
	 * objects of type T.
	 */
	// <R> Stream<R> map(Function<? super T, ? extends R> mapper);
	public Pair<L, R> map(Function<Pair<L, R>, Pair<L, R>> mapper) {
		return mapper.apply(this);

	}

	/*
	 * 24. Can you define a flatMap method for Pair<T>? If so, what is it? If
	 * not, why not? Answer: in what structure it is going to return the values
	 */

	/*
	 * 22. Is there a flatMap operation for CompletableFuture? If so, what is
	 * it?
	 */
}