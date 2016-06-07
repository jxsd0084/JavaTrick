package bj.powernode.advance.Charpter06.homework1;

/*

    第二个发动机叫"HONDA"，实现功能:

 a. 启动方法中显示"HONDA启动，速度40"。
 b. 停止方法中显示"YAMAHA停止，速度0".
 c. 加速方法中显示"YAMAHA加速，速度120".

 */

// Honda类属性IEngine接口
public class Honda implements IEngine {

	@Override
	// 重写加速方法,HONDA加速
	public void speedup() {

		System.out.println( "Honda加速，速度120" );
	}

	@Override
	// 重写启动方法,HONDA启动
	public void start() {

		System.out.println( "Honda启动，速度40" );
	}

	@Override
	// 重写刹车方法,HONDA刹车
	public void stop() {

		System.out.println( "Honda停止，速度0" );
	}

}
