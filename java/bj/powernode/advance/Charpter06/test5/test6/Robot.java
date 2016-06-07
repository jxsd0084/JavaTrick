package bj.powernode.advance.Charpter06.test5.test6;

/**
 * 用内部类去实现两个父类的抽象方法
 *
 * @author Administrator
 */

public class Robot extends Person {

	@Override
	public void run() {

		System.out.println( "机器人实现人的run行为" );
	}

	// 内部类的第三个作用:配合接口,抽象类,实现真正的多继承
	// 不用内部类,无法实现
	class RobotHeart implements Machine {

		public void run() {

			System.out.println( "机器人实现机器的run行为" );
		}
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Robot      r  = new Robot();
		RobotHeart rr = r.new RobotHeart();

		r.run();
		rr.run();

	}

}
