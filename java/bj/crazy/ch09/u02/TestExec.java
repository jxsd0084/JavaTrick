package bj.crazy.ch09.u02;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestExec {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Runtime rt = Runtime.getRuntime();

		rt.exec( "notepad.exe" );

	}


}
