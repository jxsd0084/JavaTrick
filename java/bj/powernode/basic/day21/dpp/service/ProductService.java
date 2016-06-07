package bj.powernode.basic.day21.dpp.service;

public class ProductService {

	public void clearCart() {

		try {
			Thread.sleep( 6000 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( "清空购物车" );
	}

}
