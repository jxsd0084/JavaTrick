package bj.DesignPattern.ym_pattern.factorymethod.example3;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建需要使用的Creator对象
		ExportOperate operate = new ExportDBOperate();

		// 调用输出数据的功能方法
		operate.export( "测试数据" );
	}

}
