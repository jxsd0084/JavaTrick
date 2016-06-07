package bj.powernode.advance.Charpter06.test5.test5;

// 普通类Person
public class Person {

	// 普通方法drive,参数:ICar接口 car
	public void drive( ICar car ) {

		// car调用run方法和stop方法
		car.run();

		car.stop();
	}

}
