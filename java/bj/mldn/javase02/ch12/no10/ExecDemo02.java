package bj.mldn.javase02.ch12.no10;

public class ExecDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		int       i     = 0;
		int       j     = 0;


		InputData input = new InputData();


		i = input.getInt( "请输入第一个数字：", "输入的数据必须是数字，请重新输入！" );
		j = input.getInt( "请输入第二个数字：", "输入的数据必须是数字，请重新输入！" );


		System.out.println( i + " + " + j + " = " + ( i + j ) );
	}
}
