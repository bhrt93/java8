package java8.oops;

import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("3", 3);
		map.put("three", 3);
		map.put("THREE", 3);
		System.out.println(map.firstKey() + " " + map.lastKey());
	}
}
