package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._110_Java对象的浅克隆;

public class Address {

	private String state;
	private String province;
	private String city;

	public Address( String state, String province, String city ) {

		this.state = state;
		this.province = province;
		this.city = city;
	}

	public String getState() {

		return state;
	}

	public void setState( String state ) {

		this.state = state;
	}

	public String getProvince() {

		return province;
	}

	public void setProvince( String province ) {

		this.province = province;
	}

	public String getCity() {

		return city;
	}

	public void setCity( String city ) {

		this.city = city;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "国家：" + state + ", " );
		sb.append( "省：" + province + ", " );
		sb.append( "市：" + city );
		return sb.toString();
	}

}
