package bj.powernode.basic.day13.day12_home_work;

public class Order {

	// 属性
	private String orderNo;  // 订单号在系统中是唯一的.

	// 构造方法
	public Order() {

	}

	public Order( String orderNo ) {

		this.orderNo = orderNo;
	}


	// setter and getter
	public void setOrderNo( String orderNo ) {

		this.orderNo = orderNo;
	}

	public String getOrderNo() {

		return orderNo;
	}

	//equals
	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj == null ) {

			return false;
		}
		if ( obj instanceof Order ) {

			Order o = (Order) obj;

			if ( o.orderNo.equals( this.orderNo ) ) {

				return true;
			}
		}

		return false;
	}


	// hashCode
	public int hashCode() {

		return orderNo.hashCode();
	}


	// toString
	public String toString() {

		return "[order no " + orderNo + "]";
	}

}
