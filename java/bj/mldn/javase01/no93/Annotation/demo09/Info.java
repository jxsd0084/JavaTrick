package bj.mldn.javase01.no93.Annotation.demo09;

public class Info {

	@Override
	@Deprecated
	@SuppressWarnings(value = "")
	@MyAnnotation(key = "MLDN", value = "www.mldnjava.cn")
	public String toString() {

		return "hello";
	}
}
