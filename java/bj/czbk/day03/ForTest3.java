package bj.czbk.day03;

/*
2,1~100之间 7的倍数的个数。并打印。
思路：
1，先对1~100进行循环(遍历)通过循环的形式。
2，在遍历的过程中，定义条件。只对7的倍数进行操作。
3，因为7的倍数不确定，只要符合条件，就通过一个变量来记录住这个变化的次数。


步骤：
1，定义循环语句，选择for语句。
2，在循环中定义判断。只要是7的倍数即可。使用if语句。条件：7的倍数 x%7==0；
3，定义变量，该变量随着7的倍数的出现而自增。
*/
class ForTest3 {

	public static void main( String[] args ) {

		int count = 0;
		for ( int x = 1; x <= 100; x++ ) {
			if ( x % 7 == 0 ) {
				//  System.out.println("x="+x);
				count++;
			}
		}
		System.out.println( "count=" + count );

		/*
		计数器思想。

		通过一个变量记录住数据的状态变化。

		也许通过循环完成。
		*/
	}
}
