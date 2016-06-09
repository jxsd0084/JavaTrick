package bj.DesignPattern.JavaPattern._01_单一职责原则.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         业务类调用
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		IUserInfo userInfo = new UserInfo();

		userInfo.changePassword( "abc" );

	}

}

/*

太Easy的类图了，我相信，即使是一个初级的程序员也可以看出这个接口设计得有问
题，用户的属性和用户的行为没有分开，这是一个严重的错误！这个接口确实设计得一团
糟，应该把用户的信息抽取成一个BO（Business Object，业务对象），把行为抽取成一个
Biz（Business Logic，业务逻辑），按照这个思路对类图进行修正，


 */
