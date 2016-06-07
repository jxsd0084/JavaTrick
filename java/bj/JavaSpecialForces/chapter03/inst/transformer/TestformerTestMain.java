package bj.JavaSpecialForces.chapter03.inst.transformer;

import bj.JavaSpecialForces.chapter03.asm.ForASMTestClass;

import java.lang.instrument.UnmodifiableClassException;

public class TestformerTestMain {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws UnmodifiableClassException {
		// InstForTransformer.reTransClass(ForASMTestClass.class);
		ForASMTestClass testClass = new ForASMTestClass();
		testClass.display1();
		testClass.display2();
	}

}
