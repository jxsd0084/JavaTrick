package bj.mldn.javase02.ch06.no12;

public class WrapperDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		float f = 30.3f;        // 基本数据类型



		Float x = new Float(f);    // 装箱：将基本数据类型变为包装类



		float y = x.floatValue();// 拆箱：将一个包装类变为基本数据类型



	}
}
