package bj.powernode.basic.day02;

public class _08_OddSum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  求1-100的奇数和
		
		/*
		
			从1-100的循环{
				每循环一次取出一个值,
				判断该值是否是奇数,
				如果是奇数,则追加.
			}
		
		*/






		int result = 0;             // 初始化一个结果,该结果是0

		for ( int i = 1; i <= 100; i++ ) {

			if ( i % 2 == 1 ) {     // 奇数
				result += i;        // += 追加
			}

		}


		System.out.println( "计算结果" + result );






	}

}
