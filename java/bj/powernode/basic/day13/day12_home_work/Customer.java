package bj.powernode.basic.day13.day12_home_work;

public class Customer {


	// 属性
	private String cname;  // 在系统中顾客的名字是唯一的.


	// 构造方法
	public Customer() {

		super();
	}

	public Customer( String cname ) {

		this.cname = cname;
	}


	// setter and getter
	public void setCname( String cname ) {

		this.cname = cname;
	}

	public String getCname() {

		return cname;
	}


	// 重写equals
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( obj instanceof Customer ) {
			Customer c = (Customer) obj;
			if ( this.getCname().equals( c.getCname() ) ) {
				return true;
			}
		}

		return false;
	}


	// 重写hashCode
	public int hashCode() {

		return this.getCname().hashCode() + 78;
	}


	// 重写toString
	public String toString() {

		return "[customer's name " + cname + "]";
	}


}
