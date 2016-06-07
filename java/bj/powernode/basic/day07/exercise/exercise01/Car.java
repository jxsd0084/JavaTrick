package bj.powernode.basic.day07.exercise.exercise01;

public class Car {

	// 测试引擎
	public void testEngine( IEngine i ) {

		//太具体了。

		/*
		YAMAHA y = new YAMAHA();
		
		y.start();
		y.speedup();
		y.stop();
		
		HONDA h = new HONDA();
		
		h.start();
		h.speedup();
		h.stop();

		*/

		i.start();
		i.speedup();
		i.stop();

	}


}
