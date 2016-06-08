package bj.DesignPattern.JavaPattern._01_单一职责原则.section3;

/**
 * Created by Administrator on 2016/6/8.
 */
public class DataTransfer implements IDataTransfer {

	private String phoneNumber = ""; // 注意: 如果此次直接为null的话, 后面判断的时候除了判断不为null之外, 还需要再判断是否为空字符串, 比较麻烦!

	public void setPhoneNumber( String phoneNumber ) {

		this.phoneNumber = phoneNumber;
	}

	public DataTransfer( IConnectionManager connectionManager ) {

		super();

		if ( !"".equals( phoneNumber ) ) {
			connectionManager.dial( phoneNumber );
			connectionManager.huangup();
		}
	}

}
