package bj.mldn.javase01.no24;

interface Fruit {

	public void eat();
}

class Apple implements Fruit {

	public void eat() {

		System.out.println("吃苹果。。。");
	}
}

class Orange implements Fruit {

	public void eat() {

		System.out.println("吃橘子。。。");
	}
}

class Factory {    // 工厂类

	public static Fruit getFruit(String className) {

		Fruit f = null;
		if ("apple".equals(className)) {

			f = new Apple();
		}

		if ("orange".equals(className)) {

			f = new Orange();
		}
		return f;
	}
}

public class InterDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

//		Fruit f = Factory.getFruit(args[0]);
		Fruit f = Factory.getFruit("apple");

		if (f != null) {

			f.eat();
		}

	}

}