package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._188_泛型化接口与最大值;

public interface Maximum < T extends Comparable< T > > {

	T getMax( T[] array );
}
