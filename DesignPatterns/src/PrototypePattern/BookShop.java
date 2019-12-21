package PrototypePattern;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
	private String bookShopName;
	List<Book> books = new ArrayList<Book>();

	public String getBookShopName() {
		return bookShopName;
	}

	public void setBookShopName(String bookShopName) {
		this.bookShopName = bookShopName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BookShop [bookShopName=" + bookShopName + ", books=" + books + "]";
	}

	public void loadBooks() {
		System.out.println("Calling this once is fine... don't call me again");
		for (int i = 1; i <= 10; i++) {
			Book book = new Book();
			book.setBookId(i);
			book.setBookName("Book " + i);

			this.getBooks().add(book);

		}
	}

	@Override
	protected BookShop clone() throws CloneNotSupportedException {
		BookShop bookShop = new BookShop();

		for (Book b : this.getBooks()) {
			bookShop.getBooks().add(b);
		}

		return bookShop;

	}

}
