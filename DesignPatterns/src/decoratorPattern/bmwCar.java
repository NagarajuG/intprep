package decoratorPattern;

public class bmwCar implements car {
	private String carName;
	private String ModelName;
	private int doors;
	private int tyres;
	private String engine;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getModelName() {
		return ModelName;
	}

	public void setModelName(String modelName) {
		ModelName = modelName;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getTyres() {
		return tyres;
	}

	public void setTyres(int tyres) {
		this.tyres = tyres;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "bmwCar [carName=" + carName + ", ModelName=" + ModelName + ", doors=" + doors + ", tyres=" + tyres
				+ ", engine=" + engine + "]";
	}

	@Override
	public car manfactureCar() {
		this.setCarName("SUV");
		this.setModelName("XUV 500");
		this.setDoors(4);
		this.setTyres(4);

		return this;
	}

}
