package bj.powernode.advance.Charpter13.homework.test3;

/*
 * Student类     学生类属性：姓名   一张答卷   一张考卷
 */
public class Student implements Comparable< Student > {

	private String      name;           // 学生的名字
	private AnswerSheet answerSheet;    // 学生的答卷
	// private Exam exam ;
	private Paper       paper;          // 考试的试卷
	private int         sumMark;        // 添加了一个总成绩的属性

	public Paper getPaper() {

		return paper;
	}

	public void setPaper( Paper paper ) {

		this.paper = paper;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public AnswerSheet getAnswerSheet() {

		return answerSheet;
	}

	public void setAnswerSheet( AnswerSheet answerSheet ) {

		this.answerSheet = answerSheet;
	}

	// public Exam getExam() {
	// return exam;
	// }
	//
	// public void setExam(Exam exam) {
	// this.exam = exam;
	// }

	public int getSumMark() {

		return sumMark;
	}

	public void setSumMark( int sumMark ) {

		this.sumMark = sumMark;
	}

	public Student( String name ) {

		this.name = name;
	}

	public Student( String name, AnswerSheet answerSheet, Paper paper ) {

		this.name = name;
		this.answerSheet = answerSheet;
		this.paper = paper;
	}

	@Override
	public int hashCode() {

		return this.name.hashCode() * 31;
	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( obj instanceof Student ) {
			Student stu = (Student) obj;
			if ( this.name.equals( stu.name ) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {

		return "学生：" + this.name + "的总成绩为：" + this.sumMark;
	}

	// 按分数降序排列，若分数相同，按名字升序排列
	public int compareTo( Student stu ) {

		if ( this.sumMark > stu.sumMark ) {
			return - 1;
		}

		if ( this.sumMark < stu.sumMark ) {
			return 1;
		}

		if ( this.sumMark == stu.sumMark ) {
			if ( this.name.compareTo( stu.name ) > 0 ) {
				return 1;
			}

			if ( this.name.compareTo( stu.name ) < 0 ) {
				return - 1;
			}
		}

		return 0;
	}

}
