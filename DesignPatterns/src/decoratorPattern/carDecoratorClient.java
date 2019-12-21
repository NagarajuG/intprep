package decoratorPattern;

public class carDecoratorClient {
	public static void main(String[] args) {
		car bmCar = new bmwCar();
		bmCar.manfactureCar();

		petrolCarDecorator petrolCarDecorator = new petrolCarDecorator(bmCar);
		petrolCarDecorator.manfactureCar();

		System.out.println(bmCar.toString());

		disealCarDecorator disealCarDecorator = new disealCarDecorator(bmCar);
		disealCarDecorator.manfactureCar();

		System.out.println(bmCar.toString());

	}

}
