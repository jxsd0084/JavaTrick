package bj.powernode.basic.day21.dpp.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义一个代理类:记录某个类的某个方法执行时间.
 *
 * @author Administrator
 */
public class LogMethodExeTimeProxy {

	private Object target;


	public LogMethodExeTimeProxy( Object target ) {
		this.target = target;
	}

	public Object invoke( String methodName, Class[] parameterTypes, Object[] args ) {

		Object obj = null;

		BufferedWriter writer = null;

		try {


			Method method = target.getClass().getDeclaredMethod( methodName, parameterTypes );

			// 方法开始执行时间
			long begin = System.currentTimeMillis();

			// 执行目标对象的目标方法
			obj = method.invoke( target, args );

			// 方法执行结束时刻
			long end = System.currentTimeMillis();

			// 方法消耗时间
			long exeTime = end - begin;

			// 记录日志
			writer = new BufferedWriter( new FileWriter( "c:/log", true ) );

			Date             beginTime    = new Date( begin );
			Date             endTime      = new Date( end );
			SimpleDateFormat sdf          = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss SSSS" );
			String           strBeginTime = sdf.format( beginTime );
			String           strEndTime   = sdf.format( endTime );

			writer.write( "INFO:" + strBeginTime + "  " + target.getClass().getName() + "类型对象的" + methodName + "方法开始执行.\n" );
			writer.write( "INFO:" + strEndTime + "  " + target.getClass().getName() + "类型对象的" + methodName + "方法执行结束.\n" );

			if ( exeTime > 5000 ) {
				writer.write( "INFO:" + target.getClass().getName() + "类型对象的" + methodName + "方法执行消耗时间" + exeTime + "毫秒,警告:该方法执行时间已经超过5000毫秒,请对其进行优化.\n" );
			} else {
				writer.write( "INFO:" + target.getClass().getName() + "类型对象的" + methodName + "方法执行消耗时间" + exeTime + "毫秒\n" );
			}


			writer.flush();


		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {

			// 关闭流
			if ( writer != null ) {
				try {
					writer.close();
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}

		}

		return obj;
	}
}
