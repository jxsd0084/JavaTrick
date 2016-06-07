package bj.DesignPattern.JavaPattern._02_里氏替换原则.section2;

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

		sanMao.setGun( new ToyGun() );

		sanMao.killEnemy();
	}

}
