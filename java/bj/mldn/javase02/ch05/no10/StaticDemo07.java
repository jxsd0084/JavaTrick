package bj.mldn.javase02.ch05.no10;

class Demo2 {    // 定义Person类

	private String name;            // 保存名字
	private static int count = 0;    // 所有对象共享此属性

	public Demo2() {

		count++;                    // 有对象产生就自增
		this.name = "DEMO-" + count;    // 自动进行编名操作
	}

	public Demo2(String name) {

		this.name = name;            // 可以通过构造赋值
	}

	public String getName() {        // 取得姓名
		return this.name;
	}
};

public class StaticDemo07 {

	public static void main(String args[]) {

		System.out.println(new Demo2().getName());
		System.out.println(new Demo2("LXH").getName());
		System.out.println(new Demo2().getName());
		System.out.println(new Demo2("MLDN").getName());
		System.out.println(new Demo2().getName());
	}
};
