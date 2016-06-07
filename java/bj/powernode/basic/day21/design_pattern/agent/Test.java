package bj.powernode.basic.day21.design_pattern.agent;

public class Test {

	/**
	 * 测试代理模式
	 */
	public static void main(String[] args) {
		
		CommonInterface cif = new Agent(new Target());
		
		cif.method();
		
	}

}
