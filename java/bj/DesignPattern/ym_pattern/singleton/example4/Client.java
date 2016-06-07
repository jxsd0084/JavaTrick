package bj.DesignPattern.ym_pattern.singleton.example4;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		// 创建读取应用配置的对象
		AppConfig config = AppConfig.getInstance();

		String paramA = config.getParameterA();
		String paramB = config.getParameterB();

		System.out.println( "paramA=" + paramA + ",paramB=" + paramB );

	}

}
