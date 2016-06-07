package bj.mldn.javase01.no40.Gen.gendemo7;

public class PersonDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		Person< Basic > per = null;
		per = new Person< Basic >();

		Basic b = new Basic( "张三", 22 );

		per.setInfo( b );

		System.out.println( per.getInfo() );

	}

}
