package decoratorPattern;

public abstract class carDecorator implements car {
	car car;

	public carDecorator(car car) {

		this.car = car;
	}

	public car manfactureCar() {
		return car.manfactureCar();
	}

}
