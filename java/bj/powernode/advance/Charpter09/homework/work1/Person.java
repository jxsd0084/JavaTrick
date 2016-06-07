package bj.powernode.advance.Charpter09.homework.work1;

/**
 * 定义一个Person类，Person类中包含一个PersonEmotion 类的属性emotion,PersonEmotion类是Person类中定义的
 * 一个内部类。同时，Person类还包含两个方法happy()和 sad()分别打印XXX happy/XXX
 * sad,(XXX为该Person的name)。 PersonEmotion类有一个私有属性boolean isHappy,代表情
 * 绪类型，如果为true，代表高兴，否则就不高兴; PersonEmotion类中为这一属性提供公共的访问方法，每
 * 次在改变isHappy的值时都要去调用外部类中相应的 happy()或sad()方法。在Person类的外部生成若干个
 * Person对象，并设计程序验证以上的代码。
 */
public class Person {

	private String        name;
	private PersonEmotion emotion;

	Person( String name ) {
		this.name = name;
	}

	private void happy() {
		System.out.println( name + "很高兴" );
	}

	private void sad() {
		System.out.println( name + "很伤心" );
	}

	class PersonEmotion {

		private boolean isHappy;

		public boolean getIsHappy() {
			return isHappy;
		}

		public void setIsHappy( boolean b ) {
			isHappy = b;
			if ( b ) {
				// Person.this.happy();
				// 内部类可以直接调用外部类私有的属性或方法
				happy();
			} else {
				// Person.this.sad();
				sad();
			}
		}
	}

}
