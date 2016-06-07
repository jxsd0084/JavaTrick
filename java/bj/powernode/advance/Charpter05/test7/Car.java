package bj.powernode.advance.Charpter05.test7;

// 接口是一个特殊的抽象类,接口也是不能实例化的

public interface Car {

	// 接口中所有的属性都是公开的静态的常量 (抽象类中可以有实例属性)
	public static final int MAX_SPEED = 500;

	// 接口中所有的方法都是公开的抽象的方法(抽象类中可以有实例方法)
	public abstract void run();

	public abstract void stop();

	// 接口中不能有构造方法(抽象类可以有构造方法)
	// 在内存中存在抽象类的对象,但是不能存在接口的对象
	// public Car(){
	// }
}

// 一个类在继承一个基类的时候,还可以同时实现多个接口
abstract class Person {

	public abstract void eat();
}

interface Machine {

	public abstract void run();
}

// 如果一个类没有实现接口中所有的抽象方法,则这个类一定是抽象类
class Robot extends Person implements Machine, Car {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}
}

// 在接口和接口之间,也可以使用继承关系,并且是多继承的
interface IA {

	void f1();

	void f2();
}

interface IB {

	void f3();

	void f2();
}

interface IC extends IB, IA {

	void f3();

	void f4();
}

class ImplClass implements IC {

	@Override
	public void f3() {
		// TODO Auto-generated method stub
	}

	@Override
	public void f4() {
		// TODO Auto-generated method stub
	}

	@Override
	public void f2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void f1() {
		// TODO Auto-generated method stub

	}

}
