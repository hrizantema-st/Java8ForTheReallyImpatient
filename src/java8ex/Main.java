package java8ex;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	// 1.2
	public static File[] allSubdirectories(final String directoryName) {
		File dir = new File(directoryName);
		return dir.listFiles(File::isDirectory);
	}

	// 1.3
	public static String[] allFiles(final String directoryName, final String extension) {
		File dir = new File(directoryName);
		// return dir.listFiles(x -> x.getName().endsWith(extension));
		return dir.list((dir2, name) -> name.endsWith(extension));
	}

	// 1.4
	// Given an array of File objects, sort it so that the directories come
	// before the
	// files, and within each group, elements are sorted by path name
	public static void sortFiles(final File[] files) {

		Arrays.sort(files, (final File first, final File second) -> {
			if ((first.isDirectory() && second.isDirectory()) || (first.isFile() && second.isFile())) {
				return first.getName().compareToIgnoreCase(second.getName());
			} else if (first.isFile() && second.isDirectory()) {
				return 1;
			} else {
				return -1;
			}
		});
		Arrays.stream(files).forEach(System.out::println);
	}

	public static <T> void main(String[] args) {

		// File[] result =
		// allSubdirectories("C:\\Users\\hstancheva\\Desktop\\JSF");
		// File[] result = allFiles("C:\\Users\\hstancheva\\Desktop\\JSF",
		// "png");
		// Arrays.stream(result).forEach(System.out::println);
		File dir = new File("C:\\Users\\hstancheva\\Desktop\\JSF");
		File[] res = dir.listFiles();
		sortFiles(res);
		// new Thread(uncheck(() -> { System.out.println("Zzz");
		// Thread.sleep(1000); })).start();
		/*
		 * Runnable r = andThen(() -> { System.out.println("1111");}, () -> {
		 * System.out.println("22222");}); new Thread(r).start();
		 */

		// 1.8
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		/*
		 * for (int i = 0; i < names.length; i++) -- Local variable i defined in
		 * an enclosing scope must be final or effectively final
		 */
		/*for (String name : names)
			runners.add(() -> System.out.println(name));
			*/
		/*
		 * for (Runnable r : runners) { new Thread(r).start(); }
		 */
		Collection2<String> col = new ArrayList2<>();
		col.add("one");
		col.add("two");
		col.add("three");
		col.forEachIf(System.out::println, x -> x.contains("t"));

	}

	// 1.7
	public static Runnable andThen(Runnable r1, Runnable r2) {
		return () -> {
			r1.run();
			r2.run();
		};
	}
}
