package bj.powernode.basic.day02;

public class _12_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {


		//  条件语句，分支语句

		/*

			第一种写法
			switch(int类型的值){
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				default: 语句;
			}
			
			
			第二种写法:
			switch(int类型的值){
				case int类型的值:语句;
				case int类型的值:语句;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				default: 语句;
			}
			
			第三种写法:
			switch(int类型的值){
				case int类型的值:语句;
				case int类型的值:语句;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
				case int类型的值:语句;break;
			}
			
			
			switch(int类型值)
			switch(byte/short/char)
			
			
			int i = 10;
			switch(i){}
			
			byte b = 10;
			switch(b){}

		*/


		char c = 't';  // 97

		String result = "";

		switch ( c ) {
			case 97:
				result = "c变量中是a字符";
				break;

			case 'b':
				result = "c变量中是b字符";
				break;

			case 'c':
				result = "c变量中是c字符";
				break;

			case 'd':
				result = "c变量中是d字符";
				break;

			case 'e':
				result = "c变量中是e字符";
				break;

			default:
				result = "c变量中存储的不是a,b,c,d,e";
		}


		System.out.println( result );


	}

}

