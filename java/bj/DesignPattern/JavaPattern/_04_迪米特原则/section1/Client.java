package bj.DesignPattern.JavaPattern._04_迪米特原则.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         我们使用Client来描绘一下这个场景
 */
public class Client {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Teacher teacher = new Teacher();

		// 老师发布命令
		teacher.commond( new GroupLeader() );
	}

}

/*

	迪米特法则（Law of Demeter，LoD）也称为最少知识原则（Least Knowledge
Principle，LKP），虽然名字不同，但描述的是同一个规则：一个对象应该对其他对象有最
少的了解。通俗地讲，一个类应该对自己需要耦合或调用的类知道得最少，你（被耦合或调
用的类）的内部是如何复杂都和我没关系，那是你的事情，我就知道你提供的这么多public
方法，我就调用这么多，其他的我一概不关心。



5.3 最佳实践

	迪米特法则的核心观念就是类间解耦，弱耦合，只有弱耦合了以后，类的复用率才可以
提高。其要求的结果就是产生了大量的中转或跳转类，导致系统的复杂性提高，同时也为维
护带来了难度。读者在采用迪米特法则时需要反复权衡，既做到让结构清晰，又做到高内聚
低耦合。


 */
