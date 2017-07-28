package java8ex2;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Task1_9 {
	// 1.9 Join all elements in a Stream<ArrayList<T>> to one ArrayList<T>. Show
	// how to do this with the three forms of reduce.
	public static <T> Optional<ArrayList<T>> joinElements1(Stream<ArrayList<T>> stream) {
		return stream.reduce((ArrayList<T> x, ArrayList<T> y) -> {
			x.addAll(y);
			return x;
		});

	}

	public static <T> ArrayList<T> joinElements2(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<T>(), (ArrayList<T> x, ArrayList<T> y) -> {
			x.addAll(y);
			return x;
		});

	}

	public static <T> ArrayList<T> joinElements3(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<T>(), (ArrayList<T> x, ArrayList<T> y) -> {
			x.addAll(y);
			return x;
		}, (ArrayList<T> x, ArrayList<T> y) -> {
			x.addAll(y);
			return x;
		});

	}

	public static void main(String[] args) {
		// 1.9
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("M");
		list2.add("N");
		Stream<ArrayList<String>> strArr = Stream.of(list1, list2);
		/*
		Optional<ArrayList<String>> op = joinElements1(strArr);
		if (op.isPresent()) {
			for (String str : op.get()) {
				System.err.println(str);
			}
		}*/

		ArrayList<String> res2 = joinElements3(strArr);
		for (String str : res2) {
			System.err.println(str);
		}
	}
}
