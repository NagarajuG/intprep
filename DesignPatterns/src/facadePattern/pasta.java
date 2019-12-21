package facadePattern;

public class pasta implements food {
	private String foodItem;

	@Override
	public void prepareFood(String ingrediants) {
		this.foodItem = "Pasta prepared with " + ingrediants;

	}

	@Override
	public String deliverFood() {

		return foodItem;
	}

}
