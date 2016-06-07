package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._546;

public class BookSell {

	private int    id;
	private String bookName;
	private String stock;
	private float  price;
	private String bookConcern;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getBookName() {

		return bookName;
	}

	public void setBookName( String bookName ) {

		this.bookName = bookName;
	}

	public String getStock() {

		return stock;
	}

	public void setStock( String stock ) {

		this.stock = stock;
	}

	public float getPrice() {

		return price;
	}

	public void setPrice( float price ) {

		this.price = price;
	}

	public String getBookConcern() {

		return bookConcern;
	}

	public void setBookConcern( String bookConcern ) {

		this.bookConcern = bookConcern;
	}

}
