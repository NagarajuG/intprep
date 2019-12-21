package builderPattern;

public class Shop {

	public static void main(String[] args) {
		PhoneBuilder phoneBuilder = new PhoneBuilder();
		phoneBuilder.setBattery(5000).setCompany("Realme").setOs("Android").setScreenSize(6);
		phoneBuilder.setRam(6);

		Phone phone1 = phoneBuilder.getPhone();

		System.out.println(phone1);
		Phone phone = new PhoneBuilder().setCompany("Apple").setRam(6).setScreenSize(5.5).getPhone();

		System.out.println(phone);

	}

}
