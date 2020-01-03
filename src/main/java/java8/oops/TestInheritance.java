package java8.oops;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Furniture {
	// - A default method cannot override a method from java.lang.Object
//    @Override
//    default boolean equals(Object other);
//	{}
}

interface Clickable {
	default void click() {
		System.out.println("click");
	}

	default void print() {
		System.out.println("Clickable");
	}
}

interface Accessible {
	default void access() {
		System.out.println("access");
	}

//	default void print(){
//		System.out.println("Accessible");
//	}
}

class Button implements Clickable, Accessible {

	public static void main(String[] args) {
		Button button = new Button();
		button.click();
		button.access();
		button.print();
	}

}

interface Vehicle {
}

class Bus implements Vehicle {
}

class Building {
	public String show() {
		return "building";
	}
}

public class TestInheritance {

	class House extends Building {
		public String show() {
			return "house";
		}
	}

	public void convert() {
		Building b = new Building();
		House h = new House();
		Building bh = new House();
		House s = (House) b;
		System.out.println(s.show());
		Building p = (House) b;
//		House q = (Building) h;
		Building r = (Building) bh;

	}

	public static void main(String[] args) {
		TestInheritance t = new TestInheritance();
		t.convert();

		Button button = new Button();
		button.click();
		button.access();
		button.print();

		Bus[] buses = new Bus[0];
		boolean busTest = buses instanceof Vehicle[];
		System.out.println("buses:" + busTest);

		Bus bus = new Bus();
		List<Integer> l = new ArrayList();
		new ArrayList<Integer>(l);

		System.out.println(null instanceof Bus);
		System.out.println(bus instanceof Vehicle);
		System.out.println(bus instanceof Bus);
//        System.out.println(bus instanceof ArrayList); // Compilation Error: Incompatible conditional operand types Bus and ArrayList
		System.out.println(bus instanceof Collection);

	}
}
