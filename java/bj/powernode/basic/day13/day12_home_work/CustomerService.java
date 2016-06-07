package bj.powernode.basic.day13.day12_home_work;

import java.util.*;

/*

	业务类:
		1.给某个顾客添加订单
		2.删除某个顾客的某个订单
		3.打印某个顾客的订单列表

*/
public class CustomerService {

	/*
		customer_orders是 Map结构 .
		key   存储 Customer类型的对象
		value 存储 Customer对象关联的订单. value是Set集合.
	*/
	private Map customer_orders = new HashMap();

	/**
	 * 给某个顾客添加订单
	 */
	public void addOrder( String cname, Order o ) {
		
		/*
		//0.必须的对象
		Customer c = new Customer(cname);
		
		//1.如果customer_orders的长度是0
		if(customer_orders.size==0){
			Set orders = new HashSet();
			orders.add(o);
			customer_orders.put(c,orders);
			return;
		}
		
		//2.如果customer_orders中有元素,但是没有cname相关的元素.
		if(!customer_orders.containsKey(c)){  //不包含
			Set orders = new HashSet();
			orders.add(o);
			customer_orders.put(c,orders);
			return;
		}
		
		//3.如果customer_orders中有元素,并且有cname相关的元素.
		if(customer_orders.containsKey(c)){  //包含
			Object oValue = customer_orders.get(c);
			if(oValue instanceof Set){
				Set orders = (Set)oValue;
				orders.add(o);
				return;
			}
		}
		*/


		Customer c = new Customer( cname );
		if ( customer_orders.containsKey( c ) ) {  // 包含
			Object oValue = customer_orders.get( c );
			if ( oValue instanceof Set ) {
				Set orders = (Set) oValue;
				orders.add( o );
				System.out.println( c + "添加订单" + o + "成功." );
				return;
			}
		}


		// 不包含
		Set orders = new HashSet();
		orders.add( o );
		customer_orders.put( c, orders );
		System.out.println( c + "添加订单" + o + "成功." );


	}


	/**
	 * 通过订单编号删除订单.
	 * <p>
	 * orderNo一定存在.
	 */

	public void removeOrder( String orderNo ) {

		Collection sets = customer_orders.values();   // 获取Map的value部分.value部分的每个元素都是Set集合.

		Iterator it1 = sets.iterator();

		while ( it1.hasNext() ) {
			Set      orders = (Set) it1.next();       // 取出某一个Set集合
			Iterator it2    = orders.iterator();
			while ( it2.hasNext() ) {
				Order o = (Order) it2.next();         // 取出订单对象
				if ( orderNo.equals( o.getOrderNo() ) ) {
					it2.remove();
					System.out.println( o.toString() + "删除成功." );
					return;
				}
			}
		}
	}

	/**
	 * 打印cname顾客的订单
	 * <p>
	 * 假如顾客的名字一定存在.
	 */
	public void printOrders( String cname ) {

		Customer c      = new Customer( cname );
		Set      orders = (Set) customer_orders.get( c );

		System.out.println( c.toString() + "订单明细：" );
		Iterator it = orders.iterator();
		while ( it.hasNext() ) {

			System.out.println( "\t" + it.next() );
		}

	}

}
