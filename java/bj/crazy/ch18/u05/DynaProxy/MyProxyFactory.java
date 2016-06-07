package bj.crazy.ch18.u05.DynaProxy;

import java.lang.reflect.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MyProxyFactory {

	// 为指定target生成动态代理对象
	public static Object getProxy( Object target ) throws Exception {


		// 创建一个 MyInvokationHandler 对象

		MyInvokationHandler handler = new MyInvokationHandler();





		// 为MyInvokationHandler设置 target 对象

		handler.setTarget( target );





		// 创建、并返回一个 动态代理
		Object obj = Proxy.newProxyInstance( target.getClass().getClassLoader()
				, target.getClass().getInterfaces(), handler );

		return obj;


	}

}
