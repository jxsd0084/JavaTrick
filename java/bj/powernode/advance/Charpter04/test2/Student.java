package bj.powernode.advance.Charpter04.test2;

// 通过基础机制,子类可以重用父类中定义好的代码(非私有的属性和方法可以被继承,但是构造方法不能被继承)

// 继承的目的在于:是为了代码的复用

// 在java中规定,一个类只能继承一个单独的基类(也就是单继承)

// 但是一个类可以被多个子类继承(也就是一个类可以有多个子类)
public class Student extends Person {

	private String schoolName;

	public void setSchoolName( String _schoolName ) {
		schoolName = _schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	// 当父类的被继承的方法不在适合子类的需要的时候,可以在子类中对该方法进行重新定义

	// 这种方式成为方法的覆盖

	// 方法覆盖的要求:

	// 1.访问权限不能减低
	// 2.方法的返回类型必须要一致
	// 3.方法名称必须要一致
	// 4.参数列表必须要一致
	// 5.抛出异常不能扩大
	// 6.只能在继承关系中使用覆盖
	// 7.只能被覆盖一次
	// 8.父类的静态方法不能被覆盖(静态方法不存放覆盖这种说法)

	@Override
	public String print(/* int age */ ) {

		return "学生的信息:name=" + getName() + " age=" + getAge() + " schoolName="
		       + schoolName;
	}

	// 在一个类中出现多个相同名称的方法,成为方法的的重载
	// 又被称为 编译时多态

	// 方法的的重载的要求:

	// 1.访问权限没有限制
	// 2.方法的返回类型必须要一致
	// 3.方法名称必须要一致
	// 4.参数列表必须要不一致(参数的个数,参数的类型,参数的顺序)
	// 5.抛出异常没有限制
	// 6.只能在本类中
	// 7.可以被重载多次
	// 8.静态方法也可以重载
	private int study() {
		System.out.println( getName() + "在学习" );
		return 0;
	}

	public void study( String className ) {
		System.out.println( getName() + "在学习 " + className );
	}

	public void study( int i, String className ) {

	}

}
