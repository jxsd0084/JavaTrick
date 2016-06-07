package bj.mldn.javase02.ch05.no08;

class Person1 {             // 定义Person类

	private String name;    // 姓名
	private int    age;     // 年龄
	private Book1  book;    // 一个人有一本书

	public Person1( String name, int age ) {

		this.setName( name );
		this.setAge( age );
	}

	public void setName( String n ) {

		name = n;
	}

	public void setAge( int a ) {

		age = a;
	}

	public String getName() {

		return name;
	}

	public int getAge() {

		return age;
	}

	public void setBook( Book1 b ) {

		book = b;
	}

	public Book1 getBook() {

		return book;
	}
};

class Book1 {                 // 定义Book类

	private String  title;    // 标题
	private float   price;    // 价格
	private Person1 person;   // 一本书属于一个人

	public Book1( String title, float price ) {

		this.setTitle( title );
		this.setPrice( price );
	}

	public void setTitle( String t ) {

		title = t;
	}

	public void setPrice( float p ) {

		price = p;
	}

	public String getTitle() {

		return title;
	}

	public float getPrice() {

		return price;
	}

	public void setPerson( Person1 p ) {

		person = p;
	}

	public Person1 getPerson() {

		return person;
	}
};

public class RefDemo05 {

	public static void main( String arg[] ) {

		Person1 per = new Person1( "张三", 30 );
		Book1   bk  = new Book1  ( "JAVA SE核心开发", 90.0f );
		per.setBook( bk );        // 设置两个对象间的关系，一个人有一本书
		bk.setPerson( per );      // 设置两个对象间的关系，一本书属于一个人

		// --- 双向依赖 ---

		// 可以通过人找到书
		System.out.println( "从人找到书 --> 姓名："
		                    + per.getName() + "；年龄："
		                    + per.getAge() + "；书名："
		                    + per.getBook().getTitle() + "；价格："
		                    + per.getBook().getPrice() );


		// 也可以通过书找到其所有人
		System.out.println( "从书找到人 --> 书名："
		                    + bk.getTitle() + "；价格："
		                    + bk.getPrice() + "；姓名："
		                    + bk.getPerson().getName() + "；年龄："
		                    + bk.getPerson().getAge() );
	}

}
