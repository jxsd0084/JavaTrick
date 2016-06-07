package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._504_使用GROUP_BY子句实现多表分组统计;

public class Sell {

	private String sellId;
	private float  sellPrice;
	private String sellTime;
	private int    sellCount;

	public String getSellId() {

		return sellId;
	}

	public void setSellId( String sellId ) {

		this.sellId = sellId;
	}

	public float getSellPrice() {

		return sellPrice;
	}

	public void setSellPrice( float sellPrice ) {

		this.sellPrice = sellPrice;
	}

	public String getSellTime() {

		return sellTime;
	}

	public void setSellTime( String sellTime ) {

		this.sellTime = sellTime;
	}

	public int getSellCount() {

		return sellCount;
	}

	public void setSellCount( int sellCount ) {

		this.sellCount = sellCount;
	}
}
