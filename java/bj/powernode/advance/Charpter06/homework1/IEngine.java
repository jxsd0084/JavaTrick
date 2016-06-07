package bj.powernode.advance.Charpter06.homework1;

/*

     设计一个发动机接口(IEngine)，需要提供如下功能：

 (1).启动(start)  
 (2)停止(stop)  
 (3)加速(speedup)

 提示：设计接口的意义在于只要发动机实现了这些功能就
 可以装在我的汽车上

 */

// IEngine接口,抽象方法:start();stop();speedUp();
public interface IEngine {

	// 启动
	void start();

	// 停止
	void stop();

	// 加速
	void speedup();
}
