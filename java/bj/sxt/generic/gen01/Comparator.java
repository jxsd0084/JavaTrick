package bj.sxt.generic.gen01;

/**
 * 泛型接口
 * 泛型不能使用在全局常量上
 *
 * @param <T>
 * @author com.bj.com.bj
 */
public interface Comparator < T > {

	// 全局常量
	/*public static final*/ int MAX_VALUE = 1024;

	// 公共的抽象方法
	/*public abstract */T compare( T t );
}