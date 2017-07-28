package java8ex2;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1_8 {
	// 1.8
	// method that alternates elements from the streams first and second,
	// stopping when one of them runs out of elements.
	public static void main(String[] args) {
		Stream<String> zipppedStream = zip(Stream.of("a", "b", "c"), Stream.of("z", "t"));
		zipppedStream.forEach(System.out::println);
	}

	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		List<T> l1 = first.collect(Collectors.toList());
		List<T> l2 = second.collect(Collectors.toList());

		Stream<T> result = IntStream.range(0, Math.min(l1.size(), l2.size()))
				.mapToObj(i -> Stream.of(l1.get(i), l2.get(i))).flatMap(Function.identity());
		return result;
	}

}
