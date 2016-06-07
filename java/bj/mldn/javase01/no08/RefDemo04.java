package bj.mldn.javase01.no08;

class Person {

	private String name;
	private int    age;
	private Book   book;    // 一个人有一本书

	public Person( String n, int a ) {

		this.setName( n );
		this.setAge( a );
	}

	public void setBook( Book b ) {

		book = b;
	}

	public void setName( String n ) {

		name = n;
	}

	public void setAge( int a ) {

		age = a;
	}

	public Book getBook() {

		return book;
	}

	public String getName() {

		return name;
	}

	public int getAge() {

		return age;
	}
}

class Book {

	private String title;
	private float  price;
	private Person person;

	public Book( String t, float p ) {

		this.setTitle( t );
		this.setPrice( p );
	}

	public void setPerson( Person p ) {

		person = p;
	}

	public void setTitle( String t ) {

		title = t;
	}

	public void setPrice( float p ) {

		price = p;
	}

	public Person getPerson() {

		return person;
	}

	public String getTitle() {

		return title;
	}

	public float getPrice() {

		return price;
	}
}

public class RefDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person per = new Person( "张三", 30 );
		Book   bk  = new Book( "Java基础", 89.0f );

		per.setBook( bk );        // 一个人有一本书
		bk.setPerson( per );    // 一本书属于一个人

		System.out.println( per.getBook().getTitle() );    // 由人找到其所拥有书的名字
		System.out.println( bk.getPerson().getName() );    // 由书找到人的名字

	}

}
