package bj.DesignPattern.ym_pattern.simplefactory.example2;

/**
 * 客户端，使用Api接口
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// 通过简单工厂来获取接口对象
		Api api = Factory.createApi( 1 );

		api.operation( "正在使用简单工厂" );
	}

}
