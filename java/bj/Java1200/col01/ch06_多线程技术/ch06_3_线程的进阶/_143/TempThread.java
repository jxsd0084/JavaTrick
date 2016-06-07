package bj.Java1200.col01.ch06_多线程技术.ch06_3_线程的进阶._143;

public class TempThread implements Runnable {// 测试用的Runnable接口实现类
	private int id = 0;

	@Override
	public void run() {// run()方法给id做自增运算
		id++;
	}
}
