package bj.mldn.javase02.ch16.no04;

@MyDocumentedAnntation(key = "MLDN", value = "www.mldnjava.cn")
public class SimpleBeanDocumented {

	/**
	 * 此方法在对象输出时调用，返回对象信息
	 */
	@MyDocumentedAnntation(key = "MLDN", value = "www.mldnjava.cn")
	public String toString() {

		return "Hello LiXingHua!!!";
	}
}
