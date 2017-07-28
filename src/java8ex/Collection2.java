package java8ex;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {
	// applies action to each element for which filter returns true.
	default void forEachIf(Consumer<T> action, Predicate<T> filter) {
	       /* final Iterator<T> iterator = iterator();
	        while (iterator.hasNext()) {
	        	T each = iterator.next();
	            if (filter.test(each)) {
	                action.accept(each);
	            }
	        }*/
		Objects.requireNonNull(action);
        for (T t : this) {
        	if(filter.test(t)) {
        		action.accept(t);
        	}
        }
	}
}
//TODO how to use it
