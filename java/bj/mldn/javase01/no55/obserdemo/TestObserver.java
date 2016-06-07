package bj.mldn.javase01.no55.obserdemo;

public class TestObserver {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		House  h    = new House( 3000.0f );

		Person per1 = new Person();
		Person per2 = new Person();
		Person per3 = new Person();

		h.addObserver( per1 );// 增加一个观察者
		h.addObserver( per2 );// 增加一个观察者
		h.addObserver( per3 );// 增加一个观察者

		h.setPrice( 6000.0f );// 要通知观察者内容已经被改变了

	}

}
