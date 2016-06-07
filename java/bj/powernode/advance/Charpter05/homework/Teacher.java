package bj.powernode.advance.Charpter05.homework;

/*

 写一个类Teacher继承自Person，在Teacher类中定义一个属
 性course（String类型）,直接输出一个Teacher对象的格式
 与Person对象的格式相同，但在程序中要求只有Teacher对象
 的所有属性都相同时，它们的equals()比较结果才为真

*/
public class Teacher extends Person1 {

	private String course;

	public String getCourse() {

		return course;
	}

	public void setCourse( String course ) {

		this.course = course;
	}

	@Override
	public String toString() {

		return "Teacher的信息: name=" + this.getName() + " age=" + super.getAge()
		       + "course=" + this.course;
	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}

		if ( obj instanceof Teacher ) {
			// 强制类型转换的实质就是一个还原的过程!
			Teacher t = (Teacher) obj;
			if ( getName().equals( t.getName() ) && getAge() == t.getAge()
			     && this.course.equals( t.course ) ) {
				return true;
			}
		}

		return false;
	}

}
