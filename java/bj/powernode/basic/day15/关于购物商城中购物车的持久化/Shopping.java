package bj.powernode.basic.day15.关于购物商城中购物车的持久化;

import java.io.*;

public class Shopping {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {




		// 1.创建购物车
		ShoppingCart cart = new ShoppingCart();





		// 2.模拟几个商品
		Product p1 = new Product( "苹果", 2.35 );
		Product p2 = new Product( "西瓜", 3.35 );
		Product p3 = new Product( "樱桃", 15.23 );
		Product p4 = new Product( "potato", 1.35 );





		// 3.添加商品到购物车
		cart.addProduct( p1 );
		cart.addProduct( p2 );

		cart.addProduct( p3 );
		cart.addProduct( p3 );
		cart.addProduct( p3 );

		cart.addProduct( p4 );
		cart.addProduct( p4 );
		cart.addProduct( p4 );
		cart.addProduct( p4 );




		// 4.假如现在程序发生了异常,持久化购物车
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "D:/course/JavaProjects/day15/关于购物商城中购物车的持久化/cart.dll" ) );

		oos.writeObject( cart );




		oos.flush();

		oos.close();


	}

}
