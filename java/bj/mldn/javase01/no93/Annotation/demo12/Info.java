package bj.mldn.javase01.no93.Annotation.demo12;

@MyAnnotation
public class Info {

	private String name;

	/**
	 * 本方法是覆写Object类中的toString()方法
	 */
	@MyAnnotation
	public String toString() {

		return "hello";
	}
}
  
