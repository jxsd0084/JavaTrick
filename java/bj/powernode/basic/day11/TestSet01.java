package bj.powernode.basic.day11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/*

	测试Set集合如何保证不重复:调用equals方法.

*/
public class TestSet01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		// 1.创建Set集合
		Set products = new HashSet();




		// 2.准备对象
		Product p1 = new Product( "p001", "BMW" );
		Product p2 = new Product( "p001", "BMW" );
		Product p3 = new Product( "p002", "PASSAT" );
		Product p4 = new Product( "p003", "QQ" );





		// 3.添加对象
		products.add( p1 );
		products.add( p1 );
		products.add( p2 );
		products.add( p3 );
		products.add( p4 );






		// 4.获取集合的元素个数.
		System.out.println( "商品的个数是=" + products.size() ); //3


		// 5.遍历集合
		Iterator it = products.iterator();
		while ( it.hasNext() ) {

			System.out.println( it.next() );
		}

	}

}


class Product {

	private String p_no;
	private String p_name;

	public Product() {

		super();
	}

	public Product( String pNo, String pName ) {

		super();
		p_no = pNo;
		p_name = pName;
	}

	public String getP_no() {

		return p_no;
	}

	public void setP_no( String pNo ) {

		p_no = pNo;
	}

	public String getP_name() {

		return p_name;
	}

	public void setP_name( String pName ) {

		p_name = pName;
	}


	public int hashCode() {

		return this.getP_no().hashCode() + this.getP_name().hashCode();


	}


	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Product ) {

			Product p = (Product) obj;

			if ( this.p_no.equals( p.p_no ) && p.p_name.equals( this.p_name ) ) {

				return true;
			}
		}

		return false;
	}


	public String toString() {

		return "Product [p_name=" + p_name + ", p_no=" + p_no + "]";
	}


}

