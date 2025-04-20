package org.alex.brain.constant;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Service<T> {
    public T serviceSupplier(Supplier<T> sup){
        return sup.get();
    }
    public String serviceFunction(Function<T, String> func, T t){
        return func.apply(t);
    }
    public void serviceConsumer(Consumer<T> cons, T t){
        cons.accept(t);
    }
    public boolean servicePredicate(Predicate<T> pr, T t){
        return pr.test(t);
    }
}
