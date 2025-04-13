package org.alex.brain.constant;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test<T> {
    public T testSupplier(Supplier<T> sup){
        return sup.get();
    }
    public String testFunction(Function<T, String> func, T t){
        return func.apply(t);
    }
    public void testConsumer(Consumer<T> cons, T t){
        cons.accept(t);
    }
    public boolean testPredicate(Predicate<T> pr, T t){
        return pr.test(t);
    }
}
