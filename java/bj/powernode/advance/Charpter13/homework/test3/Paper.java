package bj.powernode.advance.Charpter13.homework.test3;

import java.util.HashMap;

/*
 *  Paper类   考卷类  属性：若干试题提示：试题采用HashMap存放，key为String，表示题号，value为试题对象
 */
public class Paper {

	/**
	 * 存放试题的map ,key为String，表示题号，value为试题对象
	 */
	// 将试题添加到HashMap中去
	private HashMap< String, Question > map;

	public HashMap< String, Question > getMap() {

		return map;
	}

	public void setMap( HashMap< String, Question > map ) {

		this.map = map;
	}

	public Paper( HashMap< String, Question > map ) {

		this.map = map;
	}

}
