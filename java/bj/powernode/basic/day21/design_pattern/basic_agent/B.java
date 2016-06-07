package bj.powernode.basic.day21.design_pattern.basic_agent;

public class B {  //目标类
	public void m(){ //目标方法
		try {
			Thread.sleep(1243);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m method invoked.");
	}
}
