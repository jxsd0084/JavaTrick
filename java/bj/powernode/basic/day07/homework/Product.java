package bj.powernode.basic.day07.homework;

public class Product {

	// 属性
	private String pro_name;
	private double pro_price;


	// 构造方法

	Product() {

	}

	Product( String pro_name, double pro_price ) {

		this.pro_name = pro_name;
		this.pro_price = pro_price;
	}

	// setter and getter

	public void setPro_name( String pro_name ) {

		this.pro_name = pro_name;
	}

	public String getPro_name() {

		return pro_name;
	}

	public void setPro_price( double pro_price ) {

		this.pro_price = pro_price;
	}

	public double getPro_price() {

		return pro_price;
	}

}	
