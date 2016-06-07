package bj.powernode.advance.Charpter06.test5.test3;

/**
 * 本例主题:局部内部类(方法中出现的类)
 * 关键字:
 * 局部内部类实现IA接口
 * 实现接口的fun1方法
 * return new Inner();
 * Outer out = new Outer();
 * IA接口 ia = out.f1();
 * ia.fun1();
 */
public class Outer {

	// 返回接口的f1普通方法,向创建本类的对象,通过对象调用f1方法,然后由IA接口ia进行接收,最后由ia完成对fun1方法调用
	public IA接口 f1() {

		int index = 1000;

		// 在一个方法里面出现的类称为局部内部类
		// 局部内部类实现IA接口
		class Inner implements IA接口 {

			// 局部内部类属性
			private int index = 10;

			// 局部内部类实现接口的fun1方法
			public void fun1() {

				System.out.println( "index=" + index );
			}
		}

		return new Inner();
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Outer out = new Outer();

		IA接口  ia  = out.f1();

		ia.fun1();
	}

}
