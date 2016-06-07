package bj.powernode.basic.day25.regex;


/**
 * 正则表达式
 * 1.必须要以 ^开始,以$ 结束
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 正则表达式：解决用户输入的数据是否与规定的匹配。
 * \         转义字符
 * ［］  代表在中括号中选一个，在内若有－表示多少到多少。
 * ^        代表非
 * \d  代表数字
 * \D  代表非数字
 * \w  单词字符
 * \W  非单词字符
 * <p>
 * <p>
 * ？（0－1 次）              ＋（1－n次）                   ＊（0－n次）
 * ｛n｝必须n次
 * ｛n,｝大于等于n次
 * ｛n,m｝大于等于n，小于等于m
 * 所有的数量是匹配前边的。
 * <p>
 * <p>
 * <p>
 * （）作为一个整体，\( \)
 * 所有正则以^表示开始，以$结束
 * －中划线放在［］中括号开始或者最后，不要放中间。
 * <p>
 * 如果超长用＋连接
 * java中\\代表\
 * 注意 $ 符号，要转义就要写成\\$。正则里的特殊字符需要转义。
 */
public class TestRegex {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {


		// 定义正则表达式
		String regex = "^[123]$";                       // 1 2 3

		String str1 = "1";

		System.out.println( str1.matches( regex ) );    // false

		// 月薪的正则表达式
		String salRegex = "^[1-9]+[0-9]*[.]?[0-9]+$";
		System.out.println( "12345.12312".matches( salRegex ) );


		String regex01 = "^([1]{10,15}[.]{1})+$";
		System.out.println( "1111111111111111".matches( regex01 ) );

		String regex02 = "^[-19]{1}$";
		System.out.println( "1".matches( regex02 ) );
		System.out.println( "9".matches( regex02 ) );
		System.out.println( "-".matches( regex02 ) );

	}

}
