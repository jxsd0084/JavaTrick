package bj.Java1200.col01.ch24_数据库高级应用.ch24_2_使用触发器._589_在删除成绩表时将学生表中的数据删除;

public class Grade {

	private int    id;
	private String name;
	private float  math;
	private float  englist;
	private float  chinese;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public float getMath() {

		return math;
	}

	public void setMath( float math ) {

		this.math = math;
	}

	public float getEnglist() {

		return englist;
	}

	public void setEnglist( float englist ) {

		this.englist = englist;
	}

	public float getChinese() {

		return chinese;
	}

	public void setChinese( float chinese ) {

		this.chinese = chinese;
	}
}
