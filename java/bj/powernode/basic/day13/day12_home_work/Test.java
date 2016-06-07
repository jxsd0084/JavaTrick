package bj.powernode.basic.day13.day12_home_work;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {




		// 1.创建Service对象
		CustomerService cs = new CustomerService();





		// 2.添加订单
		Order o1 = new Order( "orderno_001" );
		Order o2 = new Order( "orderno_002" );
		Order o3 = new Order( "orderno_003" );
		Order o4 = new Order( "orderno_004" );
		Order o5 = new Order( "orderno_005" );
		Order o6 = new Order( "orderno_006" );


		cs.addOrder( "jack", o1 );
		cs.addOrder( "jack", o2 );
		cs.addOrder( "jack", o3 );
		cs.addOrder( "sun", o4 );
		cs.addOrder( "cock", o5 );
		cs.addOrder( "lusens", o6 );







		// 3.删除订单.
		cs.removeOrder( "orderno_002" );







		// 4.打印订单列表
		cs.printOrders( "jack" );
		cs.printOrders( "sun" );
		cs.printOrders( "cock" );
		cs.printOrders( "lusens" );






	}

}
