package bj.DesignPattern.JavaPattern._01_单一职责原则.section3;

/**
 * Created by Administrator on 2016/6/8.
 */
public interface IConnectionManager {

	// 拨通电话
	public void dial( String phoneNumber );

	// 通话完毕，挂电话
	public void huangup();
	
}
