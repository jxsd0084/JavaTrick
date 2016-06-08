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


 */
