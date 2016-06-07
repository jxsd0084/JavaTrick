package bj.mldn.javase01.no07;

class Address {

	private String national;
	private String province;
	private String city;
	private String street;
	private String zipcode;

	public Address() {

	}

	public Address( String n, String p, String c, String s, String z ) {

		this.setNational( n );
		this.setProvince( p );
		this.setCity( c );
		this.setStreet( s );
		this.setZipcode( z );
	}

	public String getInfo() {

		return "地址信息：" + "\n" +
		       "\t|- 国家：" + this.getNational() + "\n" +
		       "\t|- 省份：" + this.getProvince() + "\n" +
		       "\t|- 城市：" + this.getCity() + "\n" +
		       "\t|- 街道：" + this.getStreet() + "\n" +
		       "\t|- 邮编：" + this.getZipcode();
	}

	public void setNational( String n ) {

		national = n;
	}

	public void setProvince( String p ) {

		province = p;
	}

	public void setCity( String c ) {

		city = c;
	}

	public void setStreet( String s ) {

		street = s;
	}

	public void setZipcode( String z ) {

		zipcode = z;
	}

	public String getNational() {

		return national;
	}

	public String getProvince() {

		return province;
	}

	public String getCity() {

		return city;
	}

	public String getStreet() {

		return street;
	}

	public String getZipcode() {

		return zipcode;
	}
}

public class AddressDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Address add = new Address( "中国", "北京", "北京市", "西城区", "100088" );

		System.out.println( add.getInfo() );

	}

}
