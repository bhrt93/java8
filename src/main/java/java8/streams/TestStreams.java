package java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestStreams {
	public static void print(Stream<String> stream) {
		Consumer<String> print = System.out::println;
		stream.peek(print).peek(print).map(s -> s).peek(print).forEach(print);
	}

	private static void longer(Optional<Boolean> opt) {
		if (opt.isPresent())
			System.out.println("run: " + opt.get());
	}

	private static void shorter(Optional<Boolean> opt) {
		opt.map(x -> "run: " + x).ifPresent(System.out::println);
	}
	

	public static void main(String[] args) {
		summaryStatistics();

		System.out.println("");

	}

	private static void flatMapToInt() {
		IntStream ints = IntStream.empty();
		IntStream moreInts = IntStream.of(66, 77, 88);
		Stream.of(ints, moreInts).flatMapToInt(x -> x).forEach(System.out::print);
	}

	private static void reverseOrderComparator() {
		Stream<String> s = Stream.of("over the river", "through the woods", "to grandmother's house we go");
		s.filter(n -> n.startsWith("t")).sorted(Comparator.reverseOrder()).findFirst().ifPresent(System.out::println);
	}

	private static void samples() {
		Stream<Character> stream = Stream.of('c', 'b', 'a'); // z1
		stream.sorted().findAny().ifPresent(System.out::println);
		print(Stream.of("hi"));
		Stream<String> stream1 = Stream.of("base", "ball");
		stream1.mapToInt(s0 -> s0.length()).forEach(System.out::println);
		
		
		Stream<Integer> stream3 = Stream.iterate(1, i -> i+1);
		//stream3.limit(10).forEach(System.out::println);
		boolean bool = stream3.anyMatch(i -> i > 5);
		System.out.println("bool="+bool);

		IntStream s1 = IntStream.of(10, 20, 40);
		s1 = IntStream.empty();
		// System.out.print(s.average().getAsDouble());

		List<Double> list = new ArrayList<>();
		list.add(5.4);
		list.add(1.2);
		Optional<Double> opt = list.stream().sorted().findFirst();
		System.out.println(opt.get() + " " + list.get(0));

		IntStream stream0 = IntStream.of(6, 10);
		LongStream longs = stream0.mapToLong(i -> i);
		System.out.println(longs.average().orElseGet(() -> 2.0));

		Stream<Character> chars = Stream.of('o', 'b', 's', 't', 'a', 'c', 'l', 'e');
		//chars.map(c -> c).collect(Collectors.toList() );
		Map map2 = chars.map(c -> c).collect(Collectors.toMap(stx -> stx.toString(), stx -> stx.charValue()));
		System.out.println(map2);

		Optional<String> opt1 = Optional.empty();
		// Optional<String> opt2 = Optional.of(null);
		Optional<String> opt3 = Optional.ofNullable(null);

		Stream<String> sx1 = Stream.of("speak", "bark", "meow", "growl", "woof");
		BinaryOperator<String> mergeFunction = (a, b) -> a;
		Map<Integer, String> map = sx1.collect(Collectors.toMap(String::length, k -> k, (s, a) -> s + ", " + a));
		System.out.println(map.size() + " " + map.get(4));


		Stream<Character> stream2 = Stream.of('c', 'b', 'a'); // z1
		stream2.sorted().findAny().ifPresent(System.out::println); // z2
		
		
		Stream<Boolean> bools = Stream.iterate(true, b -> !b);
		//bools.forEach(System.out::println);
		
		Map<Boolean, List<Boolean>> map3 = bools.limit(1)
		    .collect(Collectors.partitioningBy(b -> b));
		System.out.println(map3);
	}

	private static void summaryStatistics() {
		IntStream pages = IntStream.of(200, 300);
		IntSummaryStatistics stats = pages.summaryStatistics();
		long total = stats.getSum();
		long count = stats.getCount();
		System.out.println(total + "-" + count);
	}

	private static void partitioningByWithCollectors() {
		// creating an Integer stream
		Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Using Collectors.counting() method
		// to count the number of elements in
		// the 2 partitions
		Map<Boolean, Long> map = s.collect(Collectors.partitioningBy(num -> (num > 3), Collectors.counting()));

		// Displaying the result as a map
		// true if greater than 3, false otherwise
		System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map);
	}

	private static void partitioningByEx() {
		// creating an Integer stream
		Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// using Collectors partitioningBy()
		// method to split the stream of elements into
		// 2 parts, greater than 3 and less than 3.
		Map<Boolean, List<Integer>> map = s.collect(Collectors.partitioningBy(num -> num > 3));

		// Displaying the result as a map
		// true if greater than 3, false otherwise
		System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map);
	}
}
