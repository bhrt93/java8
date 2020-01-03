package java8.lambda;

import java.util.function.BooleanSupplier;

public class LambdaInitWarehouse {

	private int quantity = 40;
	private final BooleanSupplier stock;
	
	{
		stock = () -> quantity > 0;
	}

	public void checkInventory() {
		if (stock.getAsBoolean())
			System.out.print("Plenty!");
		else {
			System.out.print("On Backorder!");
		}
	}

	public static void main(String... widget) {
		final LambdaInitWarehouse w13 = new LambdaInitWarehouse();
		w13.checkInventory();
		Math.pow(3, 3);
	}
}