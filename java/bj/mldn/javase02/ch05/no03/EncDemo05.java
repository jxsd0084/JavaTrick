package bj.mldn.javase02.ch05.no03;

class Person5 {

	private String name;               // 声明姓名属性
	private int    age;                // 声明年龄属性

	public void setName( String n ) {  // 设置姓名
		name = n;
	}

	public void setAge( int a ) {      // 设置年龄
		if ( a >= 0 && a <= 150 ) {    // 加入验证
			age = a;
		}
	}

	public String getName() {          // 取得姓名
		return name;
	}

	public int getAge() {              // 取得年龄
		return age;
	}

	public void tell() {

		System.out.println( "姓名：" + this.getName() + "，年龄：" + this.getAge() );
	}
}

public class EncDemo05 {

	public static void main( String arsgh[] ) {

		Person5 per = new Person5();   // 声明并实例化对象
		per.setName( "张三" );          // 调用setter设置姓名
		per.setAge( - 30 );            // 调用setter设置年龄
		per.tell();                    // 输出信息
	}
}
