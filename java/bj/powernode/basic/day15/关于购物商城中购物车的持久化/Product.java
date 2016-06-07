package bj.powernode.basic.day15.关于购物商城中购物车的持久化;

import java.io.Serializable;


public class Product implements Serializable {

	// 属性
	private String pro_name;
	private Double pro_price;

	// 构造方法
	public Product() {

		super();
	}

	public Product( String proName, Double proPrice ) {

		super();
		pro_name = proName;
		pro_price = proPrice;
	}


	// setter and getter
	public String getPro_name() {

		return pro_name;
	}

	public Double getPro_price() {

		return pro_price;
	}

	public void setPro_name( String proName ) {

		pro_name = proName;
	}

	public void setPro_price( Double proPrice ) {

		pro_price = proPrice;
	}


	public int hashCode() {

		final int prime  = 31;
		int       result = 1;
		result = prime * result
		         + ( ( pro_name == null ) ? 0 : pro_name.hashCode() );

		result = prime * result
		         + ( ( pro_price == null ) ? 0 : pro_price.hashCode() );

		return result;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj == null ) {

			return false;
		}

		if ( getClass() != obj.getClass() ) {

			return false;
		}
		Product other = (Product) obj;

		if ( pro_name == null ) {

			if ( other.pro_name != null ) {

				return false;
			}

		} else if ( !pro_name.equals( other.pro_name ) ) {

			return false;
		}

		if ( pro_price == null ) {

			if ( other.pro_price != null ) {

				return false;
			}

		} else if ( !pro_price.equals( other.pro_price ) ) {

			return false;
		}

		return true;
	}

	public String toString() {

		return "Product [pro_name=" + pro_name + ", pro_price=" + pro_price
		       + "]";
	}

}
