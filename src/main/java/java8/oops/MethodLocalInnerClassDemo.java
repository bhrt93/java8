package java8.oops;

class MyOuter {
	private int x = 10;

	public void createLocalInnerClass() {
		int y = 20;
		final int z = 30;
		class LocalInner {
			public void accessOuter() {
				System.out.println(x);
				System.out.println(y);
				System.out.println(z);
			}
		}
		//y=y+10;
		LocalInner li = new LocalInner();
		li.accessOuter();
	}
}

public class MethodLocalInnerClassDemo {
	public static void main(String[] args) {
		MyOuter mo = new MyOuter();
		mo.createLocalInnerClass();
	}
}
