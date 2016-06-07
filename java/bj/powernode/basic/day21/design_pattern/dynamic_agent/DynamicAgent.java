package bj.powernode.basic.day21.design_pattern.dynamic_agent;

import java.lang.reflect.Method;

/**
 * 动态代理中的代理类
 * <p>
 * 任务：代理java语言中的所有类的方法执行.
 */
public class DynamicAgent {

	/**
	 * 在代理类中有一个目标类的引用.
	 * 因为目标类的类型不能确定,所以定义类型为Object类型.
	 */
	private Object target;  //目标类的引用.

	//构造方法(创建代理类对象)
	public DynamicAgent( Object target ) {

		this.target = target;
	}

	//代理类的代理方法,代理去执行目标类的目标方法

	/**
	 * @param methodName     方法名
	 * @param parameterTypes 方法的形参类型
	 * @param methodArgs     方法的实参列表
	 * @return
	 */
	public Object invoke( String methodName, Class[] parameterTypes, Object[] methodArgs ) {

		Object obj = null;

		//额外代码


		//执行目标对象的目标方法
		try {
			Class  c      = target.getClass(); //获取目标类对象的基因信息
			Method method = c.getDeclaredMethod( methodName, parameterTypes );  //方法的基因片段
			obj = method.invoke( target, methodArgs );  //目标对象的目标方法的执行结果
		} catch ( Exception e ) {
			e.printStackTrace();
		}


		//额外代码


		return obj;
	}
}
