package bj.powernode.basic.day07;

public class Product {

	// 属性
	private String pro_no;
	private String pro_name;
	private double pro_price;


	// 构造方法
	public Product() {

		super();
	}

	public Product( String pro_no, String pro_name, double pro_price ) {

		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
	}


	// setter and getter
	public void setPro_no( String pro_no ) {

		this.pro_no = pro_no;
	}

	public String getPro_no() {

		return pro_no;
	}

	public void setPro_name( String pro_name ) {

		this.pro_name = pro_name;
	}

	public String getPro_name() {

		return pro_name;
	}

	public void setPro_price( double pro_price ) {

		this.pro_price = pro_price;
	}

	public double getPro_price() {

		return pro_price;
	}


	// 重写equals
	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Product ) {

			Product p = (Product) obj;

			// 如果商品的编号和名字一样，我们就认为是同一个商品
			if ( this.getPro_no().equals( p.getPro_no() ) && this.getPro_name().equals( p.getPro_name() ) ) {

				return true;
			}
		}

		return false;

	}


	// 重写toString
	public String toString() {

		return pro_no + "\t" + pro_name + "\t" + pro_price;
	}


	// 主方法
	public static void main( String[] args ) {

		Product p1 = new Product( "p_001", "apple", 1.0 );
		Product p2 = new Product( "p_002", "orange", 2.0 );
		Product p3 = new Product( "p_001", "apple", 1.0 );


		System.out.println( p1.toString() );
		System.out.println( p2 );


		System.out.println( p1.equals( p2 ) ? "p1和p2相等" : "p1和p2不是同一个对象" );
		System.out.println( p1.equals( p3 ) ? "p1和p3相等" : "p1和p3不是同一个对象" );


		System.out.println( "p1对象的哈希码值=" + p1.hashCode() );
		System.out.println( "p2对象的哈希码值=" + p2.hashCode() );



		System.out.println( Integer.toHexString( p1.hashCode() ) );  //将哈希码值转换成16进制
		System.out.println( Integer.toHexString( p2.hashCode() ) );


		System.out.println( "十进制的15对应的十六进制=" + Integer.toHexString( 15 ) );  //转换成16进制

	}

}
