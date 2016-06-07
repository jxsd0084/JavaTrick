package bj.powernode.basic.day15.关于购物商城中购物车的持久化;

import java.io.*;
import java.util.*;

public class BackCart {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		ObjectInputStream ois = new ObjectInputStream( new FileInputStream( "D:/course/JavaProjects/day15/关于购物商城中购物车的持久化/cart.dll" ) );

		Object obj = ois.readObject();

		if ( obj instanceof ShoppingCart ) {

			ShoppingCart cart = (ShoppingCart) obj;

			Map< Product, Integer > maps = cart.getMaps();

			//遍历
			Set< Product > products = maps.keySet();
			for ( Product p : products ) {

				System.out.println( p + "\t" + maps.get( p ) );
			}

		}


		ois.close();

	}

}
