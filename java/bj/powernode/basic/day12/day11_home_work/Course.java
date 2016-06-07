package bj.powernode.basic.day12.day11_home_work;

public class Course {

	// 属性
	private String cno;
	private String cname;


	//构 造方法
	public Course() {

	}

	public Course( String cno, String cname ) {

		this.cno = cno;
		this.cname = cname;
	}


	// setter and getter
	public void setCno( String cno ) {

		this.cno = cno;
	}

	public String getCno() {

		return cno;
	}

	public void setCname( String cname ) {

		this.cname = cname;
	}

	public String getCname() {

		return cname;
	}


	// 重写equals

	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Course ) {

			Course c = (Course) obj;

			if ( c.getCname().equals( this.cname ) && c.getCno().equals( this.cno ) ) {

				return true;
			}
		}

		return false;
	}


	// 重写hashCode
	public int hashCode() {

		return this.getCno().hashCode() + this.getCname().hashCode();
	}


	// 重写toString
	public String toString() {

		return "[课程编号:" + cno + ",课程名字:" + cname + "]";
	}

}
