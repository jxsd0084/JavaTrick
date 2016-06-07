package bj.sxt.generic.gen02;

/**
 * 自定义泛型类
 * 1、<> -->单个大写字母，尽可能见名知意
 * 2、
 * T Type
 * K V Key Value
 * E Element
 * <p>
 * 3、注意点:
 * 泛型不能使用在静态属性上
 * 指定的类型不能为基本类型
 *
 * @author com.bj.com.bj
 */
// T -->type 类型
public class MyStudent < T > {

	private T javase;

	// private static T test; // 泛型不能使用在静态属性上
	public MyStudent() {
	}

	public MyStudent( T javase ) {
		this.javase = javase;
	}

	public T getJavase() {
		return javase;
	}

	public void setJavase( T javase ) {
		this.javase = javase;
	}
}
