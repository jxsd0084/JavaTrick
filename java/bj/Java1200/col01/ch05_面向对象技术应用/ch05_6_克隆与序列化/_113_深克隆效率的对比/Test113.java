package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._113_深克隆效率的对比;

import java.util.ArrayList;
import java.util.List;

public class Test113 {

	public static void main( String[] args ) {

		List< Worker113 >   workerList   = new ArrayList< Worker113 >();
		List< Employee113 > employeeList = new ArrayList< Employee113 >();
		Worker113           worker       = new Worker113( "明日科技", 12 );
		Employee113         employee     = new Employee113( "明日科技", 12 );
		long                currentTime  = System.currentTimeMillis();
		for ( int i = 0; i < 100000; i++ ) {
			workerList.add( worker.clone() );
		}
		System.out.print( "使用复制域的方式实现克隆所花费的时间：" );
		System.out.println( System.currentTimeMillis() - currentTime + "毫秒" );
		currentTime = System.currentTimeMillis();
		for ( int i = 0; i < 100000; i++ ) {
			employeeList.add( employee.clone() );
		}
		System.out.print( "使用序列化的方式实现克隆所花费的时间：" );
		System.out.println( System.currentTimeMillis() - currentTime + "毫秒" );
	}
}
