package facadePattern;

public class WaiterOrChef {

	public static String serveFood(FoodType type) {
		switch (type) {
		case PASTA:
			pasta pasta1 = new pasta();
			pasta1.prepareFood("Tomoto and Capsicum");
			return pasta1.deliverFood();

		case PIZZA:
			pizza pizza1 = new pizza();
			pizza1.prepareFood("chicken barbeque");
			return pizza1.deliverFood();

		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}

}
