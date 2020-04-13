package java8Practice;

import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

/**
 * 
 * @author G521885
 *
 */
public class PrimitiveFunctionalInterfaceTesting {
	public static void main(String[] args) {
		// predicate primitive
		System.out.println("--------------- Predicate Testing ----------");
		predicateTesting();

		// function primitive
		System.out.println("--------------- Function Testing ---------");
		functionTesting();

		// Consumer primitive
		System.out.println("--------------- Consumer Testing ---------");
		consumerTesting();

		// Supplier primitive
		System.out.println("--------------- Supplier Testing ---------");
		supplierTesting();

		System.out.println("---------------Unary operator---------------");
		UnaryOperatorTesting();
		System.out.println("---------------Binary operator---------------");
		binaryOperatorTesting();

	}

	private static void binaryOperatorTesting() {
		// interface BinaryOperator<T> { T apply(T t,T t);}
		BinaryOperator<Integer> bo = (a, b) -> a + b;
		System.out.println(bo.apply(1, 2));

		// interface IntBinaryOperator { int applyAsInt(int a,int b);}
		IntBinaryOperator ibo = (a, b) -> a + b;
		System.out.println(ibo.applyAsInt(1, 2));

		// interface LongBinaryOperator { long applyAsLong(long a,long b);}
		LongBinaryOperator lbo = (a, b) -> a + b;
		System.out.println(lbo.applyAsLong(1l, 2l));

		// interface DoubleBinaryOperator { double applyAsDouble(double a,double b);}
		DoubleBinaryOperator dbo = (a, b) -> a + b;
		System.out.println(dbo.applyAsDouble(1.5, 2.6));
	}

	private static void UnaryOperatorTesting() {
		// interface UnaryOperator<T> { T apply(T t); }
		UnaryOperator<Integer> uo = i -> i * i;
		System.out.println(uo.apply(8));
		// interface IntUnaryOperator { int applyAsInt(int i); }
		IntUnaryOperator iuo = i -> i * i;
		System.out.println(iuo.applyAsInt(2));
		// interface LongUnaryOperator { long applyAsLong(long i); }
		LongUnaryOperator luo = i -> i * i;
		System.out.println(luo.applyAsLong(2l));
		// interface DoubleUnaryOperator { double applyAsDouble(double l); }
		DoubleUnaryOperator duo = i -> i * i;
		System.out.println(duo.applyAsDouble(2l));
	}

	private static void supplierTesting() {
		// interface IntSupplier { int getAsInt();}
		IntSupplier is = () -> (int) (Math.random() * 3);
		// interface LongSupplier { long getAsLong();}
		LongSupplier ls = () -> (long) (Math.random() * 3);
		// interface DoubleSupplier { double getAsDouble();}
		DoubleSupplier ds = () -> Math.random() * 3;
		// interface BooleanSupplier { boolean getAsBoolean();}
		BooleanSupplier bs = () -> false;

		System.out.println(is.getAsInt());
		System.out.println(ls.getAsLong());
		System.out.println(ds.getAsDouble());
		System.out.println(bs.getAsBoolean());
	}

	private static void consumerTesting() {
		// interface IntConsumer { void accept(int i);}
		IntConsumer ic = i -> System.out.println(i * 2);
		ic.accept(2);
		// interface LongConsumer { void accept(long l);}
		LongConsumer lc = i -> System.out.println(i * 2);
		lc.accept(2l);
		// interface DoubleConsumer { void accept(double d);}
		DoubleConsumer dc = System.out::println;
		dc.accept(2.9);

		System.out.println("---------------");
		// interface ObjIntConsumer<T> { void accept(T t,int i);}
		ObjIntConsumer<String> oic = (s, i) -> System.out.println(s.length() + i);
		oic.accept("hello", 2);
		// interface ObjLongConsumer<T> { void accept(T t,long l);}
		ObjLongConsumer<String> olc = (s, l) -> System.out.println(s.length() + l);
		olc.accept("hello", 2l);
		// interface ObjDoubleConsumer<T> { void accept(T t,long l);}
		ObjDoubleConsumer<String> odc = (s, d) -> System.out.println(s.length() + d);
		odc.accept("hello", 2.3);
	}

	private static void functionTesting() {
		// interface IntFunction<R> { R apply(int i); }
		IntFunction<String> iF = i -> String.valueOf(i * i);
		// interface LongFunction<R> { R apply(long i); }
		LongFunction<String> lf = l -> String.valueOf(l * l);
		// interface DoubleFunction<R> { R apply(double i); }
		DoubleFunction<String> df = d -> String.valueOf(d * d);

		// interface ToIntFunction<T> {int applyAsInt(T t);}
		ToIntFunction<String> tif = s -> s.length();
		// interface ToLongFunction<T> {long applyAsLong(T t);}
		ToLongFunction<String> tlf = s -> Long.parseLong(s);
		// interface ToDoubleFunction<T> {double applyAsDouble(T t);}
		ToDoubleFunction<String> tdf = s -> Double.parseDouble(s);

		// interface IntToLongFunction { long applyAsLong(int i); }
		IntToLongFunction itlf = i -> i * i * 1L;
		// interface IntToDoubleFunction { double applyAsDouble(int i); }
		IntToDoubleFunction itdf = i -> i * i * 1.0;

		// interface DoubleToIntFunction { int applyAsInt(double d); }
		DoubleToIntFunction dtif = d -> (int) d * 2;
		// interface DoubleToLongFunction { long applyAsLong(double d); }
		DoubleToLongFunction dtlf = d -> (long) d * 2;

		// interface LongToIntFunction { int applyAsInt(long l); }
		LongToIntFunction ltif = l -> (int) l * 2;
		// interface LongToDoubleFunction { double applyAsDouble(long l); }
		LongToDoubleFunction ltdf = d -> d * 2.0;

		// interface ToIntBiFunction<T,U> { int applyAsInt(T t,U u); }
		ToIntBiFunction<String, String> tibf = (s1, s2) -> s1.concat(s2).length();
		// interface ToDoubleBiFunction { double applyAsDouble(T t,U u); }
		ToDoubleBiFunction<String, String> tdbf = (s1, s2) -> Double.parseDouble(s1.concat(s2));
		// interface ToLongBiFunction { long applyAsLong(T t,U u); }
		ToLongBiFunction<String, String> tlbf = (s1, s2) -> Long.parseLong(s1.concat(s2));

		System.out.println(iF.apply(2));
		System.out.println(df.apply(2.50));
		System.out.println(lf.apply(3L));
		System.out.println("-------------");
		System.out.println(tif.applyAsInt("34"));
		System.out.println(tlf.applyAsLong("2"));
		System.out.println(tdf.applyAsDouble("23"));
		System.out.println("-----------------------");
		System.out.println(itlf.applyAsLong(2));
		System.out.println(itdf.applyAsDouble(3));
		System.out.println(dtif.applyAsInt(2.3));
		System.out.println(dtlf.applyAsLong(2.3));
		System.out.println(ltif.applyAsInt(2l));
		System.out.println(ltdf.applyAsDouble(2l));
		System.out.println("-----------------------");
		System.out.println(tibf.applyAsInt("hello", "hi"));
		System.out.println(tdbf.applyAsDouble("1", "2"));
		System.out.println(tlbf.applyAsLong("1", "2"));
	}

	private static void predicateTesting() {
		// interface IntPredicate { boolean test(int value); }
		IntPredicate oddPred = i -> i % 2 == 0;
		// interface LongPredicate { boolean test(long value); }
		LongPredicate longPred = i -> i % 2 == 0;
		// interface DoublePredicate { boolean test(double value); }
		DoublePredicate doublePred = i -> i > 20.0;

		System.out.println(oddPred.test(22));
		System.out.println(longPred.test(23L));
		System.out.println(doublePred.test(24.02));
	}
}
