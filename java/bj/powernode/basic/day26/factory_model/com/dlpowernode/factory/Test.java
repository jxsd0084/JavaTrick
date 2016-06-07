package bj.powernode.basic.day26.factory_model.com.dlpowernode.factory;

import bj.powernode.basic.day26.factory_model.com.dlpowernode.factory.entity.Cat;
import bj.powernode.basic.day26.factory_model.com.dlpowernode.factory.entity.Dog;

import java.util.Date;

public class Test {

	public static void main( String[] args ) {
		/**
		 * 获取猫对象
		 */
		Cat  cat     = (Cat) InstanceFactory.getInstance( "Cat" );
		Dog  dog     = (Dog) InstanceFactory.getInstance( "Dog" );
		Date nowTime = (Date) InstanceFactory.getInstance( "NowTime" );

		System.out.println( cat.toString() );
		System.out.println( dog.toString() );
		System.out.println( nowTime );
	}

}
