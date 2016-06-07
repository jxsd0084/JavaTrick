package bj.Java1200.col01.ch05_面向对象技术应用.ch05_2_修饰符的使用._088_单例模式的应用;

public class Emperor {

	private static Emperor emperor = null;

	private Emperor() {

	}

	public static Emperor getInstance() {

		if ( emperor == null ) {
			emperor = new Emperor();
		}
		return emperor;
	}

	public void getName() {

		System.out.println( "我是皇帝：明日科技" );
	}

}
