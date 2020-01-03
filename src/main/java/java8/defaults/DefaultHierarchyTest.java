package java8.defaults;

interface A {
	default void hello() {
		System.out.println("hello-A");
	}
}

interface A1 extends A {
	default void hello() {
		System.out.println("hello-A1");
	}
}


public class DefaultHierarchyTest implements A1 {
	public static void main(String[] args) {
		A1 a1 = new DefaultHierarchyTest();
		a1.hello();
		A a = (A)a1;
		a.hello();	
	}
}
