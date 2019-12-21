package SOLIDPrinciples;

import java.util.ArrayList;
import java.util.List;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LiskovSubStitutionPrinciple {
	public interface IDiscount {
		int discount(int sales);
	}

	public interface IDataBase {
		void add(int db) throws Exception;
	}

	public class customer implements IDataBase, IDiscount {

		public void add(int db) {
			System.out.println("Customer add method");

		}

		public int discount(int sales) {
			System.out.println("Customer discount method");
			return sales - 5;
		}

	}

	public class GoldCustomer extends customer {
		public int discount(int sales) {
			System.out.println("Gold Customer discount method");
			return sales - 20;

		}

		public void add(int db) {
			// throw new Exception();
			// throw new Exception("Not implemented");
			// System.out.println("Gold customer add method");
		}
	}

	public class silverCustomer extends customer {

		public int discount(int sales) {
			System.out.println("Silver Customer discount method");
			return sales - 10;

		}

	}

	public class Enquiry extends customer {
		public void add(int db) {
			System.out.println("Enquiry class add method");
			System.out.println(db);

		}
	}

	public void parseCustomers() throws Exception {
		List<customer> customers = new ArrayList<customer>();
		GoldCustomer goldCustomer = new GoldCustomer();
		customers.add(goldCustomer);
		customers.add(new Enquiry());
		customers.add(new silverCustomer());

		for (customer customer : customers) {
			customer.discount(5);

		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println("Dummy main method");

		LiskovSubStitutionPrinciple liskovSubStitutionPrinciple = new LiskovSubStitutionPrinciple();
		liskovSubStitutionPrinciple.parseCustomers();

	}

}
