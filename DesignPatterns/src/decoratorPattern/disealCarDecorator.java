package decoratorPattern;

public class disealCarDecorator extends carDecorator {

	public disealCarDecorator(decoratorPattern.car car) {
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
			bCar.setEngine("Diesel Engine");
			System.out.println("Diesel Engine got added");

		}
	}

}
