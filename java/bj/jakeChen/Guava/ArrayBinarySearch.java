package bj.jakeChen.Guava;

/**
 * Created by chenlong on 2016/4/26.
 */
public class ArrayBinarySearch {

	public static void main( String[] args ) {

		BinarySearch bs = new BinarySearch();

		int[] sortedData = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10 };
		int   findValue  = 9;
		int   length     = sortedData.length;

		int pos = bs.searchRecursive( sortedData, 0, length - 1, findValue );
		System.out.println( "Recursice: " + findValue + " found in pos " + pos + "; count: " + bs.getrCount() );

		pos = bs.searchLoop( sortedData, findValue );
		System.out.println( "Loop: " + findValue + " found in pos " + pos + "; count: " + bs.getlCount() );
	}

}

/**
 * 二分查找
 *
 * @author cyxl
 */
class BinarySearch {

	private int rCount = 0;
	private int lCount = 0;

	/**
	 * 获取递归的次数
	 *
	 * @return
	 */
	public int getrCount() {
		return rCount;
	}

	/**
	 * 获取循环的次数
	 *
	 * @return
	 */
	public int getlCount() {
		return lCount;
	}

	/**
	 * 执行递归二分查找，返回第一次出现该值的位置
	 *
	 * @param sortedData 已排序的数组
	 * @param start      开始位置
	 * @param end        结束位置
	 * @param findValue  需要找的值
	 * @return 值在数组中的位置，从0开始。找不到返回-1
	 */
	public int searchRecursive( int[] sortedData,
	                            int start,
	                            int end,
	                            int findValue ) {
		rCount++;
		if ( start <= end ) {
			//  中间位置
			int middle = ( start + end ) >> 1;          //  相当于( start + end ) / 2

			int middleValue = sortedData[ middle ];     //  中值

			if ( findValue == middleValue ) {

				return middle;                          //  等于中值直接返回
			} else if ( findValue < middleValue ) {
				//  小于中值时在中值前面找
				return searchRecursive( sortedData, start, middle - 1, findValue );
			} else {
				//  大于中值在中值后面找
				return searchRecursive( sortedData, middle + 1, end, findValue );
			}
		} else {

			return -1;                                  //  找不到
		}
	}

	/**
	 * 循环二分查找，返回第一次出现该值的位置
	 *
	 * @param sortedData 已排序的数组
	 * @param findValue  需要找的值
	 * @return 值在数组中的位置，从0开始。找不到返回-1
	 */
	public int searchLoop( int[] sortedData,
	                       int findValue ) {
		int start = 0;
		int end   = sortedData.length - 1;

		while ( start <= end ) {
			lCount++;
			//中间位置
			int middle = ( start + end ) >> 1;          //  相当于( start + end ) / 2

			int middleValue = sortedData[ middle ];     //  中值

			if ( findValue == middleValue ) {

				return middle;                          //  等于中值直接返回
			} else if ( findValue < middleValue ) {

				end = middle - 1;                       //  小于中值时在中值前面找
			} else {

				start = middle + 1;                     //  大于中值在中值后面找
			}
		}

		return -1;                                      //  找不到
	}
}
