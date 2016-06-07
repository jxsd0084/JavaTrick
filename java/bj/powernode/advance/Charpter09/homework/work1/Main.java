package bj.powernode.advance.Charpter09.homework.work1;

public class Main {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		Person               p1  = new Person( "张三" );
		Person.PersonEmotion pe1 = p1.new PersonEmotion();
		pe1.setIsHappy( true );
		pe1.setIsHappy( false );
		pe1.setIsHappy( true );
		pe1.setIsHappy( true );

		System.out.println( "===============================" );
		Person               p2  = new Person( "李四" );
		Person.PersonEmotion pe2 = p2.new PersonEmotion();
		pe2.setIsHappy( true );
		pe2.setIsHappy( false );
		pe2.setIsHappy( true );
		pe2.setIsHappy( true );
	}
}
