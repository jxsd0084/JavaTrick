package bj.powernode.basic.day15.关于购物商城中购物车的持久化;

import java.io.*;
import java.util.*;


/*

	购物车

*/
public class ShoppingCart implements Serializable {

	// 属性
	private Map< Product, Integer > maps;


	// 构造方法
	public ShoppingCart() {

		maps = new HashMap< Product, Integer >();
	}


	// setter and getter
	public void setMaps( Map< Product, Integer > maps ) {

		this.maps = maps;
	}

	public Map< Product, Integer > getMaps() {

		return maps;
	}

	// 向购物车中添加商品.
	public void addProduct( Product p ) {

		if ( maps.containsKey( p ) ) {

			Integer productCount = maps.get( p );

			productCount++;

			maps.put( p, productCount );

			return;
		}

		maps.put( p, new Integer( 1 ) );
	}

}
