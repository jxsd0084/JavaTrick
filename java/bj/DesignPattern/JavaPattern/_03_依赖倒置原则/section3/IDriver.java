package bj.DesignPattern.JavaPattern._03_依赖倒置原则.section3;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         司机的接口
 */
public interface IDriver {

	// 是司机就应该会驾驶汽车
	public void drive( ICar car ); // 3.接口声明依赖对象

}
