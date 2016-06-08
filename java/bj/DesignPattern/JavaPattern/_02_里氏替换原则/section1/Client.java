package bj.DesignPattern.JavaPattern._02_里氏替换原则.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         业务场景模拟类
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// 产生三毛这个士兵
		Soldier sanMao = new Soldier();

		// 给三毛一支枪
		sanMao.setGun( new Rifle() );
		sanMao.killEnemy();

	}

}

/*

注意　在类中调用其他类时务必要使用父类或接口，如果不能使用父类或接口，则说明
类的设计已经违背了LSP原则。


注意　如果子类不能完整地实现父类的方法，或者父类的某些方法在子类中已经发
生“畸变”，则建议断开父子继承关系，采用依赖、聚集、组合等关系代替继承。


依赖倒置原则在Java语言中的表现就是：

● 模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过
接口或抽象类产生的；

● 接口或抽象类不依赖于实现类；

● 实现类依赖接口或抽象类。更加精简的定义就是“面向接口编程”——OOD（Object-Oriented Design，面向对象设
计）的精髓之一。


 */
