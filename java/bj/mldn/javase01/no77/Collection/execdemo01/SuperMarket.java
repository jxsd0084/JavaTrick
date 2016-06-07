package bj.mldn.javase01.no77.Collection.execdemo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SuperMarket {

	private List< Goods > allGoods;

	public SuperMarket() {

		this.allGoods = new ArrayList< Goods >();
	}

	public void add( Goods goods ) {

		this.allGoods.add( goods );
	}

	public void remove( Goods goods ) {

		this.allGoods.remove( goods );
	}

	public List< Goods > search( String keyWord ) {

		List< Goods >     temp = new ArrayList< Goods >();
		Iterator< Goods > iter = this.allGoods.iterator();
		while ( iter.hasNext() ) {
			Goods g = iter.next();
			if ( g.getName().indexOf( keyWord ) != - 1 ) {
				temp.add( g );
			}
		}
		return temp;
	}

	public List< Goods > getAllGoods() {

		return this.allGoods;
	}
}
