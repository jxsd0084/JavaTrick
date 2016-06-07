package bj.powernode.advance.Charpter13.io.test7;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = - 6061289960668749085L;

	private String sheng;
	private String city;
	private String jieDao;


	public Address( String sheng, String city, String jieDao ) {

		super();
		this.sheng = sheng;
		this.city = city;
		this.jieDao = jieDao;
	}

	public String getSheng() {

		return sheng;
	}

	public void setSheng( String sheng ) {

		this.sheng = sheng;
	}

	public String getCity() {

		return city;
	}

	public void setCity( String city ) {

		this.city = city;
	}

	public String getJieDao() {

		return jieDao;
	}

	public void setJieDao( String jieDao ) {

		this.jieDao = jieDao;
	}

	@Override
	public String toString() {

		return "Address [city=" + city + ", jieDao=" + jieDao + ", sheng="
		       + sheng + "]";
	}

}
