package bj.jakeChen.Proxy.ex01;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chenlong on 2016/5/23.
 */
public class UserServiceProxy implements InvocationHandler {

	private Object targetObject;

	public Object createProxyInstance( Object targetObject ) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance( this.targetObject.getClass().getClassLoader(), this.targetObject.getClass().getInterfaces(), this );
	}

	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
		UserServiceBean bean = (UserServiceBean) this.targetObject;
		Object          obj  = null;
		if ( bean.getName() != null ) {
			if ( "wuq".equals( bean.getName() ) ) {
				obj = method.invoke( this.targetObject, args );
			} else {
				System.out.println( "您没有操作权限" );
			}
		} else {
			System.out.println( "您没有操作权限" );
		}
		return obj;
	}

}
