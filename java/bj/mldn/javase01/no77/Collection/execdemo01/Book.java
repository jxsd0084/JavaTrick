package bj.mldn.javase01.no77.Collection.execdemo01;

public class Book implements Goods {

	private String name;
	private int    count;
	private float  price;

	public Book() {

	}

	public Book( String name, int count, float price ) {

		this.name = name;
		this.count = count;
		this.price = price;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public int getCount() {

		return count;
	}

	public void setCount( int count ) {

		this.count = count;
	}

	public float getPrice() {

		return price;
	}

	public void setPrice( float price ) {

		this.price = price;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( ! ( obj instanceof Book ) ) {
			return false;
		}
		Book b = (Book) obj;
		if ( b.name.equals( this.name ) && b.count == this.count
		     && b.price == this.price ) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {

		return this.name.hashCode() + new Integer( this.count ).hashCode()
		       + new Float( this.price ).hashCode();
	}

	public String toString() {

		return "书名：" + this.name + "；书的价格：" + this.price + "；书的数量："
		       + this.count;
	}

}
