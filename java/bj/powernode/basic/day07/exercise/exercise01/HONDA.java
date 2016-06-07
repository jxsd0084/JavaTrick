package bj.powernode.basic.day07.exercise.exercise01;

public class HONDA implements IEngine {

	public void start() {

		System.out.println( "HONDA启动，速度40" );
	}

	public void stop() {

		System.out.println( "YAMAHA停止，速度0" );
	}

	public void speedup() {

		System.out.println( "YAMAHA加速，速度120" );
	}

}
