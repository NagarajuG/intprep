package FactoryPattern;

public class factoryExample {

	public static void main(String[] args) {
		OperatingSystemFactory osfFactory = new OperatingSystemFactory();

		OperatingSystem oSystem = osfFactory.instance("closeopen");

		oSystem.spec();

	}

}
