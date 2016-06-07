package bj.powernode.advance.Charpter06.homework1;

/*
 *  设计一个汽车类(Car),汽车应该有一个方法用来测试发动机的
 性能,叫testEngine().

 这个方法里主要有以下内容:
 测试发动机启动
 测试发动机加速
 测试发动机停止
 （提示：也就是在方法中调用发动机的三个方法）
 */

// 汽车类,方法testEngine(),参数:IEngine engine
// 方法中分别调用:speedUp();start();stop();方法
public class Car {

	public void testEngine( IEngine engine ) {

		engine.speedup();

		engine.start();

		engine.stop();

	}

}
