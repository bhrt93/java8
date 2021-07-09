package java8.streams;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		
		for (int i = 0; i < 1000000; i++)
			myList.add(i);

		System.out.println("building streams");
		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		System.out.println("filter and print");
		System.out.println("a"+Instant.now());
		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 980000);
		System.out.println();
		System.out.println("b"+Instant.now());
		
		// using lambda in forEach
		highNums.forEach(p -> System.out.print("."));
		System.out.println();
		System.out.println("c"+Instant.now());
		
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 980000);
		highNumsSeq.forEach(p -> System.out.print("*"));
		System.out.println();
		System.out.println("d"+Instant.now());
	}

}
