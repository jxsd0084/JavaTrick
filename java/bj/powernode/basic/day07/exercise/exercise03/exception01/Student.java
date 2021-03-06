package bj.powernode.basic.day07.exercise.exercise03.exception01;

public class Student {

	// 要求使用该方法时参数必须是String类型,如果不是字符串则抛出异常.
	public void printName( Object obj ) throws MustStringArgumentException {

		if ( ! ( obj instanceof String ) ) {

			// 上抛异常
			throw new MustStringArgumentException( "必须传递一个字符串类型的数据" );  //必须处理或者上抛
		}

		System.out.println( obj );
	}

}
