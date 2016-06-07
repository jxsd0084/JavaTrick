package bj.powernode.advance.Charpter13.homework.test3;

import java.util.HashMap;

/*
 * AnswerSheet类    答卷类属性：每道题的答案  提示：
 * 答卷中每道题的答案用HashMap存放，
 * key为String，表示题号，value为学生的答案
 */
public class AnswerSheet {

	/**
	 * 存放学生答案的map key为String，表示题号，value也是String,为学生的答案
	 */
	private HashMap< String, String > map;

	public HashMap< String, String > getMap() {

		return map;
	}

	public void setMap( HashMap< String, String > map ) {

		this.map = map;
	}

	public AnswerSheet( HashMap< String, String > map ) {

		this.map = map;
	}
}
