package bj.mldn.javase01.no83.Class.demo.factorydemo01;

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
		if (className.equals("apple")) {
			f = new Apple();
		}
		if (className.equals("orange")) {
			f = new Orange();
		}
		return f;
	}
}

public class FactoryDemo01 {

	public static void main(String[] args) {

		Fruit f = Factory.getInstance("apple");
		f.eat();
	}
}
