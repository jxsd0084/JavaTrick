package bj.powernode.advance.Charpter09.homework.work2;

/**
 * 定义
 * 一个类Army,该类有一个静态方法attack(Weapow),要求
 * 传一个Weapon对象做参数，表示让这个Weapon对象发射。
 */
public class Army {

	public static void attack( Weapon w ) {
		w.shoot();
	}
}
