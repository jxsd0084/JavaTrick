package bj.powernode.advance.Charpter05.homework;

/*

 【程序3】

 写一个类Person，包含2个属性 name和age,在代码块中为name
 和age 赋初值,要求直接输出 一个Person对象时输出"XXX:YY"
 (其中XXX为该Person的name
 ，YY为该Person的age)；并且在程序中认为若两个Person的
 name和age都相同则这两个Person的equals比较也相等。


 写一个类Teacher继承自Person，在Teacher类中定义一个属
 性course（String类型）,直接输出一个Teacher对象的格式
 与Person对象的格式相同，但在程序中要求只有Teacher对象
 的所有属性都相同时，它们的equals()比较结果才为真。要
 求在主方法中测试以上程序。

 */

public class Person1 {

	private String name;
	private int    age;

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	@Override
	public String toString() {

		return "Peron的信息: name=" + name + " age=" + age;
	}

	@Override
	public boolean equals( Object obj ) {

		boolean result = false;

		if ( this == obj ) {
			return true;
		}

		if ( obj instanceof Person ) {
			Person1 p = (Person1) obj;
			if ( this.age == p.age && this.name.equals( p.name ) ) {
				result = true;
			}
		}

		return result;
	}

}
