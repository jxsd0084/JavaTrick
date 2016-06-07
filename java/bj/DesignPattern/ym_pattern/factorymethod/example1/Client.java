package bj.DesignPattern.ym_pattern.factorymethod.example1;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		ExportOperate operate = new ExportOperate();

		operate.export( 2, "测试数据" );

	}

}
