package decoratorPattern;

public class petrolCarDecorator extends carDecorator {

	public petrolCarDecorator(car car) {
		super(car);
	}

	public car manfactureCar() {
		car.manfactureCar();
		addEngine(car);
		return car;

	}

	public void addEngine(car car) {
		if (car instanceof bmwCar) {
			bmwCar bCar = (bmwCar) car;
			bCar.setEngine("Petrol Engine");
			System.out.println("Petrol Engine got added");

		}
	}

}
