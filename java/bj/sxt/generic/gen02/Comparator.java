package bj.sxt.generic.gen02;

/**
 * 泛型接口  与 泛型类  同理
 *
 * @author com.bj.com.bj
 */
public interface Comparator < T > {

	// 全局常量
	public static final int MAX_VALUE = 100;

	// 公共抽象方法
	public abstract void test( T t );
}

// 实现
class InterC1 < A > implements Comparator {

	@Override
	public void test( Object t ) {

	}
}

class InterC2 < A > implements Comparator< Integer > {

	@Override
	public void test( Integer t ) {
		// TODO Auto-generated method stub

	}
}

class InterC3 < T, A > implements Comparator< T > {

	@Override
	public void test( T t ) {

	}
}