package bj.mldn.javase01.no25;

interface National {

}

class Person3 extends Object implements National {

}

public class ObjectDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String arg[] ) {

		National na   = new Person3();    // 子类为接口实例化

		Object   obj  = na;    // 使用Object接收接口实例

		National temp = (National) obj;

	}

}
