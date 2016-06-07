package bj.mldn.javase02.ch06.no11;

class Demo {    // 定义Demo类，实际上就是继承了Object类

}

public class ObjectDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		Demo d = new Demo();    // 实例化Demo对象
		System.out.println("不加toString()输出：" + d);
		System.out.println("加上toString()输出：" + d.toString());
	}
}
