package bj.mldn.javase01.no69.adddemo;


public class AddDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		InputData input = new InputData();
		int       i     = input.getInt( "请输入第一个数字：", "输入的内容必须是数字，" ); // 接收第一个数字
		int       j     = input.getInt( "请输入第一个数字：", "输入的内容必须是数字，" ); // 接收第二个数字
		System.out.println( "数字相加操作：" + i + " + " + j + " = " + ( i + j ) );
	}

}
