package bj.powernode.advance.Charpter06.homework1;

/*

    第一个发动机叫"YAMAHA",实现功能:
 a. 启动方法中显示"YAMAHA启动，速度60"。
 b. 停止方法中显示"YAMAHA停止，速度0".
 c. 加速方法中显示"YAMAHA加速，速度80".

*/

// Yahama类实现IEngine接口
public class Yamaha implements IEngine {

	@Override
	// 实现加速方法, YAMAHA加速
	public void speedup() {

		System.out.println( "YAMAHA加速，速度80" );
	}

	@Override
	// 实现启动方法,YAMAHA启动
	public void start() {

		System.out.println( "YAMAHA启动，速度60" );
	}

	@Override
	// 实现刹车方法,YAMAHA刹车
	public void stop() {

		System.out.println( "YAMAHA停止，速度0" );
	}

}
