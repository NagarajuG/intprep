package builderPattern;

public class PhoneBuilder {
	private String company;
	private String os;
	private int ram;
	private int battery;
	private double screenSize;

	public PhoneBuilder setCompany(String company) {
		this.company = company;
		return this;
	}

	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}

	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}

	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}

	public PhoneBuilder setScreenSize(double screenSize) {
		this.screenSize = screenSize;
		return this;
	}

	public Phone getPhone() {

		return new Phone(company, os, ram, battery, screenSize);

	}

}
