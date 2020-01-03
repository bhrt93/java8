package java8.oops;

class Wash<T> {
	T item;

	public void clean(T item) {
		System.out.println("Clean " + item);
	}
}

public class TestGenerics {
	public static void main(String[] args) {
		Wash wash1 = new Wash();
		Wash wash2 = new Wash<String>();
		Wash<String> wash = new Wash<>();
		wash1.clean("socks");
		wash2.clean("socks");
		wash.clean("socks");
	}
}
