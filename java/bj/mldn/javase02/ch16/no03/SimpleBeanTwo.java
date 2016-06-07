package bj.mldn.javase02.ch16.no03;

public class SimpleBeanTwo {

	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	@MyDefaultAnnotationReflect(key = "MLDN", value = "www.mldnjava.cn")
	public String toString() {

		return "Hello LiXingHua!!!";
	}
}
