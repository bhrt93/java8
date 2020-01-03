package java8.oops;

import java8.oops.Bottle.Message;
import java8.oops.Bottle.Ship;

class Bottle {
	public class Message {
		public String msg() {
			return "Message in a bottle";
		}
	}
	public static class Ship {
		private enum Sail { // w1
			TALL {
				protected int getHeight() {
					return 100;
				}
			},
			SHORT {
				protected int getHeight() {
					return 2;
				}
			};
			protected abstract int getHeight();
		}

		public Sail getSail() {
			return Sail.TALL;
		}
	}
}

public class InnerTest {
	public final Ship sh;
	{
		sh = new Bottle.Ship();
	}

	public static void main(String[] stars) {
		Bottle bottle = new Bottle();
		Ship q = new Bottle.Ship(); // w2
		Message q2 =  bottle.new Message(); // w2
		System.out.println(q2.msg());
		System.out.print(q.getSail());
	}
}
