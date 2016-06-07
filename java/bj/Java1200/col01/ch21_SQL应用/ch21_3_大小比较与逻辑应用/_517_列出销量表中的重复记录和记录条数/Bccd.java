package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._517_列出销量表中的重复记录和记录条数;

public class Bccd {

	private int    id;
	private String bccdName;
	private int    bccdCount;
	private float  bccdPrice;
	private String bccdDate;
	private int    countId;
	private int    sum;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getBccdName() {

		return bccdName;
	}

	public void setBccdName( String bccdName ) {

		this.bccdName = bccdName;
	}

	public int getBccdCount() {

		return bccdCount;
	}

	public void setBccdCount( int bccdCount ) {

		this.bccdCount = bccdCount;
	}

	public float getBccdPrice() {

		return bccdPrice;
	}

	public void setBccdPrice( float bccdPrice ) {

		this.bccdPrice = bccdPrice;
	}

	public String getBccdDate() {

		return bccdDate;
	}

	public void setBccdDate( String bccdDate ) {

		this.bccdDate = bccdDate;
	}

	public int getCountId() {

		return countId;
	}

	public void setCountId( int countId ) {

		this.countId = countId;
	}

	public int getSum() {

		return sum;
	}

	public void setSum( int sum ) {

		this.sum = sum;
	}
}
