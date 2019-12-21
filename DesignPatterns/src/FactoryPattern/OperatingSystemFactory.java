package FactoryPattern;

public class OperatingSystemFactory {

	public OperatingSystem instance(String type) {
		if (type.equals("open"))
			return new Android();
		else if (type.equals("close"))
			return new IOS();
		else {
			return new Windows();
		}

	}

}
