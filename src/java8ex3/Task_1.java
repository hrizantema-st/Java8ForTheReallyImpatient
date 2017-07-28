package java8ex3;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task_1 {
	/*
	 * Enhance the lazy logging technique by providing conditional logging. A
	 * typical call would be logIf(Level.FINEST, () -> i == 10, () -> "a[10] = "
	 * + a[10]). Don’t evaluate the condition if the logger won’t log the
	 * message.
	 */
	public static void main(String[] args) {
		Logger.getGlobal().setLevel(Level.OFF);
		logIf(Level.INFO, () -> true, () -> "you'll never see it");
		
		Logger.getGlobal().setLevel(Level.ALL);
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < a.length; i++) {
			log(i, a);
		}
	}

	private static void log(int i, int[] a) {
		logIf(Level.INFO, () -> i == 10, () -> "a[10] = " + a[10]);
	}

	public static void info(final Logger logger, final Supplier<String> message) {
		if (logger.isLoggable(Level.INFO))
			logger.info(message.get());
	}

	public static void logIf(final Level level, final BooleanSupplier predicate, final Supplier<String> message) {
		Logger logger = Logger.getGlobal();
		if (logger.isLoggable(level) && predicate.getAsBoolean()) {
			logger.log(level, message.get());
		}
	}
}
