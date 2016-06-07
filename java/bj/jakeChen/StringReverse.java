package bj.jakeChen;

import java.util.Stack;

/**
 * Created by chenlong on 2016/4/22.
 */
// 反转字符串
public class StringReverse {

	public static void main(String[] args) {
		String s = "abcd";
		System.out.println("-> " + reverse1(s));
		System.out.println("-> " + reverse2(s));
		System.out.println("-> " + reverse3(s));
		System.out.println("-> " + reverse4(s));
		System.out.println("-> " + reverse5(s));
		System.out.println("-> " + reverse6(s));
		System.out.println("-> " + reverse7(s));
	}

	/**
	 * 递归
	 *
	 * @param s
	 * @return
	 */
	public static String reverse1(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String left  = s.substring(0, length / 2);
		String right = s.substring(length / 2, length);
		return reverse1(right) + reverse1(left);
	}

	/**
	 * for循环
	 *
	 * @param s
	 * @return
	 */
	public static String reverse2(String s) {
		int    length  = s.length();
		String reverse = "";
		for (int i = 0; i < length; i++)
			reverse = s.charAt(i) + reverse;
		return reverse;
	}

	/**
	 * for循环2
	 *
	 * @param s
	 * @return
	 */
	public static String reverse3(String s) {
		char[] array   = toCharArray2(s);
		String reverse = "";
		for (int i = array.length - 1; i >= 0; i--)
			reverse += array[i];

		return reverse;
	}

	/**
	 * StringBuffer
	 *
	 * @param s
	 * @return
	 */
	public static String reverse4(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	/**
	 * 转Char数组, 替换数组中的字符
	 *
	 * @param orig
	 * @return
	 */
	public static String reverse5(String orig) {
		char[] s          = toCharArray2(orig);
		int    n          = s.length - 1;
		int    halfLength = n / 2;

		for (int i = 0; i <= halfLength; i++) {
			char temp = s[i];
			s[i] = s[n - i];
			s[n - i] = temp;
		}
		return new String(s);
	}

	/**
	 * 转Char数组, 使用"异或^"运算符
	 *
	 * @param s
	 * @return
	 */
	public static String reverse6(String s) {
		char[] str   = s.toCharArray();
		int    begin = 0;
		int    end   = s.length() - 1;

		while (begin < end) {
			str[begin] = (char) (str[begin] ^ str[end]);
			str[end] = (char) (str[begin] ^ str[end]);
			str[begin] = (char) (str[end] ^ str[begin]);
			begin++;
			end--;
		}
		return new String(str);
	}

	/**
	 * 转Char数组, 使用Stack集合
	 *
	 * @param s
	 * @return
	 */
	public static String reverse7(String s) {
		char[]           str   = toCharArray2(s);
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length; i++)
			stack.push(str[i]);

		String reversed = "";
		for (int i = 0; i < str.length; i++)
			reversed += stack.pop();

		return reversed;
	}

	/**
	 * 字符串 -> Char数组 System.arraycopy
	 *
	 * @return
	 */
/*	private static char[] toCharArray(String str) {
		int  len      = str.length();
		char result[] = new char[len];
		// 此处有误, 应该调用操作系统底层函数应该传入数组, 而不是字符串
		System.arraycopy(str, 0, result, 0, len);
		return result;
	}*/

	/**
	 * 字符串 -> Char数组 for循环
	 * @param str
	 * @return
	 */
	private static char[] toCharArray2(String str) {
		int  len      = str.length();
		char result[] = new char[len];
		for (int i = 0; i < len; i++) {
			result[i] = str.charAt(i);
		}
		return result;
	}

}
