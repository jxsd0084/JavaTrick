package bj.Java1200.col01.ch05_面向对象技术应用.ch05_1_Java中类的定义._083_自定义图书类;

public class Book {

	private String title;
	private String author;
	private double price;

	public Book( String title, String author, double price ) {

		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {

		return title;
	}

	public String getAuthor() {

		return author;
	}

	public double getPrice() {

		return price;
	}

}
