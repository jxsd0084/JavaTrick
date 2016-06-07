package bj.mldn.javase01.no83.Class.demo.factorydemo02;

interface Fruit {

	public void eat();
}

class Apple implements Fruit {

	public void eat() {

		System.out.println("吃苹果。");
	}
}

class Orange implements Fruit {

	public void eat() {

		System.out.println("吃橘子");
	}
}

class Factory {

	public static Fruit getInstance(String className) {

		Fruit f = null;
		try {
			f = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
		}
		return f;
	}
}

public class FactoryDemo02 {

	public static void main(String[] args) {

		Fruit f = Factory.getInstance("org.lxh.demo.factorydemo02.Apple");
		f.eat();
	}
}
