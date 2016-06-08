package bj.DesignPattern.JavaPattern._03_依赖倒置原则.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         业务场景类
 */
public class Client {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Driver zhangSan = new Driver();
		Benz   benz     = new Benz();

		// 张三开奔驰车
		zhangSan.drive( benz );
	}

}

/*

依赖倒置原则在Java语言中的表现就是：

● 模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过
接口或抽象类产生的；

● 接口或抽象类不依赖于实现类；

● 实现类依赖接口或抽象类。更加精简的定义就是“面向接口编程”——OOD（Object-Oriented Design，面向对象设
计）的精髓之一。


 */
