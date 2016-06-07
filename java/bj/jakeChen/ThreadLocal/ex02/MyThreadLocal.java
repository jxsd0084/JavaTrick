package bj.jakeChen.ThreadLocal.ex02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/2.
 */
public abstract class MyThreadLocal < T > {

	private Map< Thread, T > container = Collections.synchronizedMap( new HashMap< Thread, T >() );

	public void set( T value ) {

		container.put( Thread.currentThread(), value );
	}

	public T get() {

		Thread thread = Thread.currentThread();
		T      value  = container.get( thread );
		if ( value == null && ! container.containsKey( thread ) ) {
			value = initialvalue();
			container.put( thread, value );
		}
		return value;
	}

	public void remove() {

		container.remove( Thread.currentThread() );
	}

	private T initialvalue() {

		return null;
	}

	protected abstract Integer initialValue();
}
