package bj.Java1200.col01.ch23_数据查询.ch23_4_函数查询._581_计算商品销售额所占百分比;

public class Ware {

	private int    id;
	private String wName;
	private float  price;
	private String wdate;
	private String percent;

	public String getPercent() {

		return percent;
	}

	public void setPercent( String percent ) {

		this.percent = percent;
	}

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getwName() {

		return wName;
	}

	public void setwName( String wName ) {

		this.wName = wName;
	}

	public float getPrice() {

		return price;
	}

	public void setPrice( float price ) {

		this.price = price;
	}

	public String getWdate() {

		return wdate;
	}

	public void setWdate( String wdate ) {

		this.wdate = wdate;
	}


}
