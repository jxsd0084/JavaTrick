package bj.DesignPattern.JavaPattern._01_单一职责原则.section3;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Phone {

	private ConnectionManager connectionManager = null;
	private DataTransfer      dataTransfer      = null;

	public Phone( ConnectionManager connectionManager, DataTransfer dataTransfer ) {

		this.connectionManager = connectionManager;
		this.dataTransfer = dataTransfer;
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		ConnectionManager connectionManager = new ConnectionManager();
		Phone             phone             = new Phone( connectionManager, new DataTransfer( connectionManager ) );

	}

}
