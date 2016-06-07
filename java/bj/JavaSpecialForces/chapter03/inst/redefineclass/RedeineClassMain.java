package bj.JavaSpecialForces.chapter03.inst.redefineclass;

import bj.JavaSpecialForces.chapter03.asm.ForASMTestClass;

import java.io.IOException;

public class RedeineClassMain {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {
		ForASMTestClass testClass = new ForASMTestClass();

		byte[] bytes = convertByteCode();

		InstForRedefineClass.redefineClass( ForASMTestClass.class, bytes );
		testClass.display1();

	}

	private static byte[] convertByteCode() throws NotFoundException,
			CannotCompileException, IOException {
		CtClass  ctClass  = ClassPool.getDefault().get( "chapter3.asm.ForASMTestClass" );
		CtMethod ctMethod = ctClass.getDeclaredMethod( "display1" );
		ctMethod.insertBefore( "{ System.out.println(\"前面加一条呀！\"); }" );
		ctMethod.insertAfter(
				"String a = \"定义个String\";" +
				"System.out.println(\"输出我定义的String！\" + a);"
		);
		byte[] bytes = ctClass.toBytecode();
		return bytes;
	}
}
