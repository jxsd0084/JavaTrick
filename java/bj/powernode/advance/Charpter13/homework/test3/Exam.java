package bj.powernode.advance.Charpter13.homework.test3;

import java.util.*;

/*
 * 1.Exam类   考试类属性： 若干学生  一张考卷提示：学生采用HashSet存放
 * 问题：为Exam类添加一个方法，用来为所有学生判卷，并打印成绩排名（名次、姓名）
 */
public class Exam {

	private HashSet< Student > set;
	private Paper              paper;

	public HashSet< Student > getSet() {

		return set;
	}

	public void setSet( HashSet< Student > set ) {

		this.set = set;
	}

	public Paper getPaper() {

		return paper;
	}

	public void setPaper( Paper paper ) {

		this.paper = paper;
	}

	public Exam( HashSet< Student > set, Paper paper ) {

		this.set = set;
		this.paper = paper;
	}

	/**
	 * 判分的方法：调用此方法，打印出所有参加考试学生的总成绩，及排名。
	 */
	public void getMark() {
		// 自定义一个TreeSet集合，存放遍历出的所有参加考试的学生，会进行自动排序。
		// （在学生类里实现了Comparable接口，并重写了compareTo()方法）
		Set< Student > studentTreeSet = new TreeSet< Student >();

		// 根据考试类里面的属性HashSet<Student> set来遍历所有参加考试的学生
		for ( Student stu : set ) {
			int                       mark        = 0;// 定义一个变量来接受取得的总成绩
			AnswerSheet               answerSheet = stu.getAnswerSheet();
			HashMap< String, String > smap        = answerSheet.getMap();

			// 这里遍历出的pid与Question题里的有若干道Question题
			// 遍历试卷里面所有的题目
			for ( String pid : paper.getMap().keySet() ) {
				// 取出试卷中的题目
				Question question = paper.getMap().get( pid );

				// smap.get(pid) 是学生该题目的答案
				// question.getRight() 本题的正确答案
				if ( smap.get( pid ).equals( question.getRight() ) ) {
					mark += question.getThisScope();
				}
				try {
					if ( stu.getAnswerSheet() == null ) {
						continue;
					}
				} catch ( NullPointerException ex ) {
					ex.printStackTrace();
				} finally {
					stu.setSumMark( mark ); // 设置学生的总分数
					studentTreeSet.add( stu );
				}
			}
		}
		int rank = 1;
		for ( Student s : studentTreeSet ) {
			Student stu = s;
			System.out.println( stu + "    名次为：" + rank );
			rank++;
		}
	}
}

