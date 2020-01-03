package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class TestLambdaMethod {

	public static void magic(BinaryOperator<Long> lambda) {
		System.out.println(lambda.apply(3L, 7L));
	}

	void reduceList(List<String> names, Predicate<String> tester) {
		names.removeIf(tester);
	}

	public static void main(String... electricSheep) {

		Long ja = 10L;
		BinaryOperator<Long> binLmd = (c, m) -> {
			return c + m + ja;
		};
		magic((b, w) -> (long) w.intValue());
		magic(binLmd);

		int MAX_LENGTH = 5;
		TestLambdaMethod search = new TestLambdaMethod();
		List<String> names = new ArrayList<>();
		names.add("Lassie");
		names.add("Benji");
		names.add("Brian");
		// MAX_LENGTH += names.size();
		search.reduceList(names, d -> d.length() > MAX_LENGTH);
		System.out.print(names.size());

	}
}
