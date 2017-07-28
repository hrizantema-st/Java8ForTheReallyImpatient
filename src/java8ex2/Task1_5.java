package java8ex2;

import java.util.stream.Stream;

public class Task1_5 {
	/*
	 * 5. Using Stream.iterate, make an infinite stream of random numbers—not by
	 * calling Math.random but by directly implementing a linear congruential
	 * generator. In such a generator, you start with x0 = seed and then produce
	 * xn + 1 = (a xn + c) % m, for appropriate values of a, c, and m. You
	 * should implement a method with parameters a, c, m, and seed that yields a
	 * Stream<Long>. Try out a = 25214903917, c = 11, and m = 248.
	 */
	public static void main(String[] args) {
		// a = 25214903917, c = 11, and m = 248.
		final long a = 25214903917L;
		final int c = 11;
		final double m = Math.pow(2, 48);
		final double seed = 7;

		Stream<Long> randoms = generateRandomStream(a, c, (int) m, (long) seed).limit(10);
		randoms.forEach(System.out::println);
	}

	public static Stream<Long> generateRandomStream(final long a, final long c, final int m, final long seed) {
		return Stream.iterate(seed, (x -> (a * x + c) / m));
	}
}
