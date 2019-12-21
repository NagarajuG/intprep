package builderPattern;

public class Phone {
	private String company;
	private String os;
	private int ram;
	private int battery;
	private double screenSize;

	public Phone(String company, String os, int ram, int battery, double screenSize) {
		super();
		this.company = company;
		this.os = os;
		this.ram = ram;
		this.battery = battery;
		this.screenSize = screenSize;
	}

	@Override
	public String toString() {
		return "Phone [company=" + company + ", os=" + os + ", ram=" + ram + ", battery=" + battery + ", screenSize="
				+ screenSize + "]";
	}

}
