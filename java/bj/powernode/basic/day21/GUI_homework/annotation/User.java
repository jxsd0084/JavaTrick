package bj.powernode.basic.day21.GUI_homework.annotation;

import java.io.Serializable;

/**
 * java语言中的Annotation. JDK1.5之后(包含1.5)
 *  标注/注释
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class User implements Serializable{

	/**
	 * 重写的方法.
	 * 如何保证这个方法一定是重写的方法呢?
	 */
	@Override
	public String toString(){
		return "test";
	}
}
