package bj.powernode.basic.day02;

public class _07_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  for循环
		/*
			for(表达式1;表达式2;表达式3){
				语句1;
				语句2;
			}
			
			表达式1只执行1次
			
			for(1;2;3){
				4;
			}
			
			1执行一次-->2-->4-->3-->2->4->3-->2.....
			
		*/




		int i;

		for ( i = 1; i <= 10; i++ ) {

			System.out.println( i );
		}

		//  最简单的for循环
		int j = 0;
		for (; ; ) {

			j++;
			if ( j == 100 ) {

				break;    //    结束当前循环
			}

			System.out.println( j );
		}


	}

}

//  练习: 1 -- 100 所有奇数的和.
