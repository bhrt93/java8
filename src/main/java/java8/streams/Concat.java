package java8.streams;

import java.util.Arrays;
import java.util.List;

public class Concat {
	public String concat1(List<String> values) {
		return values.parallelStream().reduce("a", (x, y) -> x + y, String::concat);
	}

	public String concat2(List<String> values) {
		return values.parallelStream().reduce((w, z) -> z + w).get();
	}

	public static void main(String... questions) {
//		Concat c = new Concat();
//		List<String> list = Arrays.asList("Cat", "Hat");
//		String x = c.concat1(list);
//		String y = c.concat2(list);
//		System.out.print(x + " " + y);
		long b = 500;//1-11110100
		System.out.println((byte) (b >>> 8));
		
				byte[] data = {(byte) (b), (byte) (b >>> 8) }; //declare a byte variable and assign the value i.e 10
				System.out.println(data[0] & 255); // print the value of byte variable b
				System.out.println(data[1] & 255);
	}
}
