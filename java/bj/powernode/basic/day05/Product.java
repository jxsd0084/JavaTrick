package bj.powernode.basic.day05;


public class Product {

	//  属性(实例变量,成员变量)
	private String productName;     //  商品名字
	private double price;           //  商品的单价

	//  setter and getter

	public void setProductName( String productName ) {

		this.productName = productName;
	}

	public String getProductName() {

		return this.productName;
	}

	public void setPrice( double price ) {

		this.price = price;
	}

	public double getPrice() {

		return this.price;
	}


	//  构造方法

	//  构造方法的重载.

	public Product() {
		//  System.out.println("test");  // this()必须放在构造函数的第一行.
		this( "BMW" );                   // 去调用了另外的构造方法.
		//  this(10.0);                  // 对 this 的调用必须是构造函数中的第一个语句
	}

	public Product( String productName ) {

		this.productName = productName;
	}

	public Product( double price ) {

		this.price = price;
	}

	public Product( String productName, double price ) {

		this.productName = productName;
		this.price = price;
	}

	//  主方法
	public static void main( String[] agrs ) {

		Product p1 = new Product();

		System.out.println( "p1对象的名字=" + p1.getProductName() );


		Product p2 = new Product( "苹果" );
		Product p3 = new Product( 10.0 );
		Product p4 = new Product( "香蕉", 20.0 );


	}


}
