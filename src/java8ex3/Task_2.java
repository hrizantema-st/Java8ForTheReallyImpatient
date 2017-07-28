package java8ex3;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public class Task_2 {
	/*
	 * 2. When you use a ReentrantLock, you are required to lock and unlock with
	 * the idiom myLock.lock(); try { some action } finally { myLock.unlock(); }
	 * Provide a method withLock so that one can call withLock(myLock, () -> {
	 * some action })
	 */

	public static void withLock(final ReentrantLock myLock, Runnable runnable) {
		myLock.lock();
		try {
			runnable.run();
		} finally {
			myLock.unlock();
		}
	}

	public static void main(String[] args) {
		withLock(new ReentrantLock(), () -> {System.out.println("print some actions");});
		String p = null;
		myAssert(() -> p != null, "Parameter is null");
	}

	/*
	 * 3. Java 1.4 added assertions to the language, with an assert keyword. Why
	 * were assertions not supplied as a library feature? Could they be
	 * implemented as a library feature in Java 8?
	 */
	public static <T> void myAssert(final BooleanSupplier predicate) {
		if(!predicate.getAsBoolean()) {
			throw new AssertionError();
		}
	}
	
	public static <T> void myAssert(final BooleanSupplier predicate, final T message) {
		if(!predicate.getAsBoolean()) {
			throw new AssertionError(message);
		}
	}

	/*
	 * 4. How many functional interfaces with Filter in their name can you find
	 * in the Java API? Which ones add value over Predicate<T>?
	 */
	//I could not find any 
}
