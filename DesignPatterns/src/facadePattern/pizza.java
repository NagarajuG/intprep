package facadePattern;

public class pizza implements food {

	private String foodItem;

	@Override
	public void prepareFood(String ingrediants) {
		this.foodItem = "Pizza prepared with " + ingrediants;

	}

	@Override
	public String deliverFood() {

		return foodItem;
	}

}
