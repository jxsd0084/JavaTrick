package bj.mldn.javase01.no55.comparesdemo;

public class Student {

	private int    stuno;
	private String name;
	private int    age;
	private float  score;

	public Student( int stuno, String name, int age, float score ) {

		this.stuno = stuno;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public boolean equals( Object obj ) { // 覆写equals，完成对象的比较
		if ( this == obj ) {
			return true;
		}

		if ( ! ( obj instanceof Student ) ) {
			return false;
		}

		Student stu = (Student) obj; // 向下转型

		if ( this.stuno == stu.stuno && this.name.equals( stu.name )
		     && this.age == stu.age && this.score == stu.score ) {
			return true;    // 对象相等

		} else {
			return false;    // 对象不等
		}

	}

	public String toString() { // 覆写toString()

		return "学生编号：" + this.stuno + "；姓名：" + this.name + "；年龄：" + this.age
		       + "；成绩：" + this.score;
	}

	public int getStuno() {

		return stuno;
	}

	public String getName() {

		return name;
	}

	public int getAge() {

		return age;
	}

	public float getScore() {

		return score;
	}

}
