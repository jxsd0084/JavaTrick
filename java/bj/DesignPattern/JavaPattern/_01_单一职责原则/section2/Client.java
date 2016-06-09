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

重新拆封成两个接口，IUserBO负责用户的属性，简单地说，IUserBO的职责就是收集和
反馈用户的属性信息；IUserBiz负责用户的行为，完成用户信息的维护和变更。各位可能要
说了，这个与我实际工作中用到的User类还是有差别的呀！别着急，我们先来看一看分拆成
两个接口怎么使用。OK，我们现在是面向接口编程，所以产生了这个UserInfo对象之后，当
然可以把它当IUserBO接口使用。也可以当IUserBiz接口使用，这要看你在什么地方使用了。
要获得用户信息，就当是IUserBO的实现类；要是希望维护用户的信息，就把它当作IUserBiz
的实现类就成了，如代码清单1-1所示。


代码清单1-1 分清职责后的代码示例
......
IUserInfo userInfo = new UserInfo();
//我要赋值了，我就认为它是一个纯粹的BO
IUserBO userBO = (IUserBO)userInfo;
userBO.setPassword("abc");
//我要执行动作了，我就认为是一个业务逻辑类
IUserBiz userBiz = (IUserBiz)userInfo;
userBiz.deleteUser();
......


确实可以如此，问题也解决了，但是我们来分析一下刚才的动作，为什么要把一个接口
拆分成两个呢？其实，在实际的使用中，我们更倾向于使用两个不同的类或接口：一个是
IUserBO，一个是IUserBiz，类图如图1-3所示。

以上我们把一个接口拆分成两个接口的动作，就是依赖了单一职责原则，那什么是单一
职责原则呢？单一职责原则的定义是：应该有且仅有一个原因引起类的变更。


 */
