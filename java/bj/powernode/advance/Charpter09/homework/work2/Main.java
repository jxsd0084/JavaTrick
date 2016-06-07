package bj.powernode.advance.Charpter09.homework.work2;

public class Main {

	/**
	 * 在主方法中调用attack方法，使用匿名内部类做参数。
	 */
	public static void main( String[] args ) {
		Army army1 = new Army();

		// 匿名内部类一定是实现一个接口或继承一个抽象类的
		// 创建了一个实现了Weapon接口的类(但是这个类只使用一次,就没有特定的声明)的对象
		// 并且把这个对象当做attack()方法的参数
		army1.attack( new Weapon() {
			public void shoot() {
				System.out.println( "导弹1在发射" );
			}
		} );
		army1.attack( new Weapon() {
			public void shoot() {
				System.out.println( "导弹2在发射" );
			}
		} );
		army1.attack( new Weapon() {
			public void shoot() {
				System.out.println( "导弹3在发射" );
			}
		} );
	}

}
