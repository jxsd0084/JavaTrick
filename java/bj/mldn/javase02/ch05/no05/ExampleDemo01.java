package bj.mldn.javase02.ch05.no05;

class Student {

	private String stuno;
	private String name;
	private float  math;
	private float  english;
	private float  computer;

	public Student() {

	}

	public Student( String s, String n, float m, float e, float c ) {

		this.setStuno( s );
		this.setName( n );
		this.setMath( m );
		this.setEnglish( e );
		this.setComputer( c );
	}

	public void setStuno( String s ) {

		stuno = s;
	}

	public void setName( String n ) {

		name = n;
	}

	public void setMath( float m ) {

		math = m;
	}

	public void setEnglish( float e ) {

		english = e;
	}

	public void setComputer( float c ) {

		computer = c;
	}

	public String getStuno() {

		return stuno;
	}

	public String getName() {

		return name;
	}

	public float getMath() {

		return math;
	}

	public float getEnglish() {

		return english;
	}

	public float getComputer() {

		return computer;
	}

	public float sum() {        // 求和操作
		return math + english + computer;
	}

	public float avg() {        // 求平均值
		return this.sum() / 3;
	}

	public float max() {        // 求最高成绩
		float max = math;       // 数学是最高成绩
		max = max > computer ? max : computer;
		max = max > english ? max : english;
		return max;
	}

	public float min() {        // 求最低成绩
		float min = math;       // 数学是最高成绩
		min = min < computer ? min : computer;
		min = min < english ? min : english;
		return min;
	}
};

public class ExampleDemo01 {

	public static void main( String args[] ) {

		Student stu = null;            // 声明对象
		stu = new Student( "MLDN-33", "李兴华", 95.0f, 89.0f, 96.0f );
		System.out.println( "学生编号：" + stu.getStuno() );
		System.out.println( "学生姓名：" + stu.getName() );
		System.out.println( "数学成绩：" + stu.getMath() );
		System.out.println( "英语成绩：" + stu.getEnglish() );
		System.out.println( "最高分：" + stu.max() );
		System.out.println( "最低分：" + stu.min() );
	}

}
