package facadePattern;

public class customer {

	public static void main(String[] args) {

		System.out.println(WaiterOrChef.serveFood(FoodType.PIZZA));

		System.out.println(WaiterOrChef.serveFood(FoodType.PASTA));

	}

}
