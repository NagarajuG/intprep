package singletonPattern;

public class singletonExample {

	public static void main(String[] args) {

		DBConnection dbConnection1 = DBConnection.getInstance();
		DBConnection dbConnection2 = DBConnection.getInstance();

		System.out.println(dbConnection1.toString());
		System.out.println(dbConnection2.toString());

	}

}

class DBConnection {
	static private DBConnection dbConnection;

	private DBConnection() {
		System.out.println("You got new DB connection");
	}

	public static DBConnection getInstance() {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}

		return dbConnection;

	}

}
