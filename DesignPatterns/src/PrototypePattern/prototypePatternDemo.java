package PrototypePattern;

public class prototypePatternDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		BookShop bookShop = new BookShop();
		bookShop.setBookShopName("Amazon");
		bookShop.loadBooks();

		System.out.println("Before cloning" + bookShop.toString());

		BookShop bs2 = bookShop.clone();

		bs2.setBookShopName("Flipkart");

		bookShop.getBooks().remove(2);

		bs2.getBooks().remove(1);

		System.out.println("After cloning" + bookShop.toString());

		System.out.println("New Book shop " + bs2.toString());

		BookShop bs3 = bookShop.clone();
		bs3.setBookShopName("Online Books");

		System.out.println("New Book shop " + bs3.toString());

	}

}
