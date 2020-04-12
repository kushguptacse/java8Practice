package java8Practice;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * interface BiPredicate<T,U> { boolean test(T t,U u); }
 * 
 * interface BiConsumer<T,U> { void accept(T t,U u); }
 * 
 * interface BiFunction<T,U,R> { R apply(T t,U u); }
 * 
 * @author G521885
 *
 */
public class BiFunctionalInterfaceTesting {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> sumCheck = (a, b) -> (a + b) > 10;
		BiConsumer<Integer, Integer> sumConsumer = (a, b) -> System.out.println(a + b);
		BiConsumer<Integer, Integer> minusConsumer = (a, b) -> System.out.println(a - b);
		BiFunction<Integer, Integer, Integer> greaterElement = (a, b) -> a > b ? a : b;
		System.out.println(sumCheck.test(5, 6));
		sumConsumer.accept(5, 6);
		minusConsumer.accept(6, 5);
		System.out.println(greaterElement.apply(5, 6));
	}

}
