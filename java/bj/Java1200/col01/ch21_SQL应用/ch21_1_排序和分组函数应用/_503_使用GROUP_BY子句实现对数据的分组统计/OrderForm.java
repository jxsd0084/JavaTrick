package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._503_使用GROUP_BY子句实现对数据的分组统计;

public class OrderForm {

	private int    id;
	private String clientName;
	private String clientArea;
	private String clientDate;
	private String visePerson;
	private float  clientMoney;

	public float getClientMoney() {

		return clientMoney;
	}

	public void setClientMoney( float clientMoney ) {

		this.clientMoney = clientMoney;
	}

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getClientName() {

		return clientName;
	}

	public void setClientName( String clientName ) {

		this.clientName = clientName;
	}

	public String getClientArea() {

		return clientArea;
	}

	public void setClientArea( String clientArea ) {

		this.clientArea = clientArea;
	}

	public String getClientDate() {

		return clientDate;
	}

	public void setClientDate( String clientDate ) {

		this.clientDate = clientDate;
	}

	public String getVisePerson() {

		return visePerson;
	}

	public void setVisePerson( String visePerson ) {

		this.visePerson = visePerson;
	}

}
