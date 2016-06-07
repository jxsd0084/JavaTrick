package bj.crazy.ch06.u006.lee;

/**
 * Created by Administrator on 2016/5/2.
 */
public abstract interface Output {

	public static final int MAX_CACHE_LINE = 50;

	public abstract void out();

	public abstract void getData( String paramString );

}
