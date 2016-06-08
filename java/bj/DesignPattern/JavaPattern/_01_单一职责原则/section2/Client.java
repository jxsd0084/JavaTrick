package bj.DesignPattern.JavaPattern._01_单一职责原则.section2;

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

		IUserBiz userInfo = new UserInfo();

		// 我要复制了，我就认为它是一个纯粹的BO
		IUserBO userBO = (IUserBO) userInfo;
		userBO.setPassword( "abc" );

		// 我要执行动作了，我就认为是一个业务逻辑类
		IUserBiz userBiz = (IUserBiz) userInfo;
		userBiz.deleteUser();

	}

}

/*

重新拆封成两个接口，IUserBO负责用户的属性，简单地说，

IUserBO的职责就是收集和反馈用户的属性信息；

IUserBiz负责用户的行为，完成用户信息的维护和变更。



单一职责原则的定义是：应该有且仅有一个原因引起类的变更。


 */
