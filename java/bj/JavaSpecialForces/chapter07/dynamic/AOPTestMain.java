package bj.JavaSpecialForces.chapter07.dynamic;

public class AOPTestMain {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		try {
			HelloInterface hello = BeanFactory.getBean( "chapter7.dynamic.HelloImpl", HelloInterface.class );
			hello.setInfo( "xieyuooo", "xiaopang" );
			//hello.getInfos1();
			//hello.getInfos2();
			//hello.display();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
