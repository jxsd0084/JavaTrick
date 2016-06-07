package bj.mldn.javase01.no09;

class Person10 {

	public void print() {

		System.out.println( this );
	}
}

public class ThisDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person10 per1 = new Person10();
		Person10 per2 = new Person10();

		System.out.println( per1 );

		per1.print();

		System.out.println( per2 );

		per2.print();

	}

}
