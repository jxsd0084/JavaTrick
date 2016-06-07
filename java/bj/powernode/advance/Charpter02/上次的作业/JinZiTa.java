package bj.powernode.advance.Charpter02.上次的作业;/*


【程序2】
 在屏幕上打印出n行的金字塔图案，如，若n=5,则图案如下：
        *
       ***
      *****
     *******
    *********
*/

//-----------源代码---------------
public class JinZiTa {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		JinZiTa jzt = new JinZiTa();

		jzt.print( 10 );

	}


	// 打印指定层数的金字塔
	// n表示要打印的层数
	public void print( int n ) {

		// 用for循环打印金字塔的层数
		for ( int i = 0; i < n; i++ ) {

			// 控制金子塔每层前面的空格
			// 如果总共是5层,则第一层要打印4个空格,
			// 第二层要打印3个空格,则控制空格个数的
			// 表达式为j<n-i
			for ( int j = 0; j < n - i; j++ ) {

				System.out.print( " " );
			}

			// 控制每层金字塔打印的*号的个数
			// 当i=0时,第一层金字塔 :for(int k = 0; k <= 0; k++),打印一个*号
			// 当i=1时,第二层金字塔 :for(int k = 0; k <= 2; k++):打印三个*号
			for ( int k = 0; k <= 2 * i; k++ ) {

				System.out.print( "*" );
			}

			System.out.println( "" );
		} // 结束for循环

	}



	/*
	public static void main(String[] args) {
		// 从命令行中接受参数,转换成int类型
		// 用来控制金字塔的层数
		//int n = Integer.parseInt(args[0]);

		int n = 40;

		// 用for循环打印金字塔的层数
		for (int i = 0; i < n; i++) {
			// 控制金子塔每层前面的空格
			// 如果总共是5层,则第一层要打印4个空格,
			// 第二层要打印3个空格,则控制空格个数的
			// 表达式为j<n-i
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			// 控制每层金字塔打印的*号的个数
			// 当i=0时,第一层金字塔 :for(int k = 0; k <= 0; k++),打印一个*号
			// 当i=1时,第二层金字塔 :for(int k = 0; k <= 2; k++):打印三个*号
			for (int k = 0; k <= 2 * i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}// 结束for循环
    }// 结束main方法
    */


} // 结束class

