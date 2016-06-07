package bj.powernode.basic.day07.exercise.exercise01;

public interface IEngine {

	// 接口: 常量+抽象方法.
	// 常量中的 static final可以省略
	// 抽象方法中的 public abstract 可以省略

	void start();  // public

	void stop();

	void speedup();

}
