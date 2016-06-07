package bj.Java1200.col01.ch21_SQL应用.ch21_2_聚集函数和日期查询._508_利用MAX函数求数据表中的最大值;

public class OrderForm {

	private int    id;
	private String clientName;
	private String clientArea;
	private String clientDate;
	private float  clientMoney;
	private String visePerson;

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

	public float getClientMoney() {

		return clientMoney;
	}

	public void setClientMoney( float clientMoney ) {

		this.clientMoney = clientMoney;
	}

	public String getVisePerson() {

		return visePerson;
	}

	public void setVisePerson( String visePerson ) {

		this.visePerson = visePerson;
	}

}
