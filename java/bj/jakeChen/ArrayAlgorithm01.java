package bj.jakeChen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenlong on 2016/4/26.
 */
// 数组的7种算法
public class ArrayAlgorithm01 {

	/**
	 * 遍历
	 * 遍历就是把这个数组的每个元素 显示出来 遍历的方法就是先定义这个数组的大小
	 * 然后用FOR循环来完成数组例如
	 */
	public static void loopArray( double[] score ) {
		for ( int i = 0; i < 5; i++ ) {
			System.out.println( score[ i ] );
		}
	}

	/**
	 * 求和
	 * 求和就是在遍历的基础上添加一个求和的计数器 就在在for外面定义一个和的变量 这个变量的初始值是0
	 * 这样就能达到求和的结果是正确的
	 * 求和的公式在for循环里面写这样的目的是因为求和也是在循环的往上加的过程
	 */
	public static void sumArray( double[] score ) {
		double sum = 0;
		for ( int i = 0; i < score.length; i++ ) {
			sum = sum + score[ i ];
		}
		System.out.println( score.length + "位同学的成绩是" + sum );
	}

	/**
	 * 极值
	 * 极值的目的就是求一个极端的值
	 * 方法就是假定数组里面的一个数据是最大的然后用其他的数据遍历他与他进行对比 如果新的数据值比这个定义的值大的话那么就替换他的这个位置然后继续遍历 遍历结束后就输出这个值就是最大的值或者最小的值  例如
	 *
	 * @param score
	 */
	public static void getMaxElement( double[] score ) {
		double max = score[ 0 ];
		int    i;
		for ( i = 0; i < score.length; i++ ) {
			if ( score[ i ] > max ) {  //这里的大于号变成小于号就可以求最小值了
				max = score[ i ];
			}
		}
		System.out.println( i + "位同学的最高成绩是" + max );
	}

	/**
	 * 查找
	 * 查找用到了boolean变量 因为这个功能的目的就是找到与没找到 换句话来说就是 找到了就是真（或假） 没找到就是假（或真）
	 * for循环里面写的if判断
	 * 判断方法就是当用户输入的值与数组中的某一个值是一样的那么就输出 否则(else)就没找到 输出不输出随便你
	 * 还要判断下用boolean就可以做到 如果是真那么就跳出这个循环并且进入下一个循环 因为boolean在跳出的时候变化成真了 那么在下面的if里面就是以真的形式出现并且输出
	 *
	 * @param score
	 * @param findScore
	 */
	public static void findElement( double[] score,
	                                double findScore ) {
		boolean flag = false;
		System.out.println( "请输入您要查找的分数：" );
		int i;
		for ( i = 0; i < score.length; i++ ) {
			if ( score[ i ] == findScore ) {
				flag = true;    //  变真了
				break;          //  跳出这个for循环进入下面的if循环
			}
		}
		if ( flag ) {           //  由于是上面的boolean变成真了 所以就进入这个if 如果没找到就跳刀下面的else
			System.out.println( "找到了您所要查找的分数。" + score[ i ] );
		} else {
			System.out.println( "没有找到您所要查找的分数。" );
		}
	}

	/**
	 * 倒置
	 * 倒置的意思就是最后一个元素变成第一个元素第一个元素变成最后一个
	 * 过程就是折中取半
	 * 不遍历整个数组了遍历一半，那么就/2就可以 但是计算机数数的方法是从0开始的也就是说最后一个值里面是没有任何意义的 所以要在最后一个值那-1
	 * 并且还要定义一个空的变量  因为要用到三步换值（变量） 不定义也可以
	 *
	 * @param score
	 */
	public static void reverseArray( double[] score ) {
		for ( int i = 0; i < score.length / 2; i++ ) {
			double temp = score[ i ];                       //  这里是空变量赋值 三步赋值第一步
			score[ i ] = score[ score.length - 1 - i ];     //  右边的值赋到左边那么右边就变成空的值
			score[ score.length - 1 - i ] = temp;           //  但是这个temp是个临时的值所以他最后是空的没有

			for ( i = 0; i < score.length; i++ ) {
				System.out.println( score[ i ] );
			}
		}
	}

	/**
	 * 排序
	 * 排序是引用的JAVA自带的一个类 所以没有难度
	 *
	 * @param score
	 */
	public static void sortArray( double[] score ) {
		Arrays.sort( score );                                //  这个代码就是内个排序的类
		for ( int i = 0; i < score.length; i++ ) {
			System.out.println( score[ i ] );
		}
	}

	/**
	 * 插入
	 * 插入的意思就是在这个数组中某一个地方插入一个变量（值）
	 * 但是一旦插入的这个变量进去那么就会对这个数组产生变化所以数组一定要空出多余的地方
	 * 并且要对插入进来的 数据进行判断，判断结束后还要跳出这个判断的if，判断的条件就是：输入进来的值大于数组里的某一个值并且小于这个值前面的那一个值（num[i]-1)
	 * 替换这个值跳出
	 * 进入下一个循环
	 */
	public static void insertArray() {
		Scanner input = new Scanner( System.in );
		int[]   num   = new int[ 6 ];
		for ( int i = 0; i < num.length; i++ ) {
			num[ i ] = input.nextInt();
		}
		Arrays.sort( num );
		System.out.println( "输入您要插入的数：" );
		int insert = input.nextInt();
		for ( int i = 0; i < num.length; i++ ) {
			if ( ( insert > num[ i ] ) && ( insert < num[ i - 1 ] ) ) {
				num[ i ] = insert; // 妈蛋! 这哪里是插入数据啊~ 明明是覆盖数据!
				break;
			}
		}
		for ( int i = 0; i < num.length; i++ ) {
			System.out.println( num[ i ] );
		}
	}

	private static double[] getDoubleArray() {
		double[] score = new double[ 5 ];
		Scanner  input = new Scanner( System.in );
		for ( int i = 0; i < score.length; i++ ) {
			System.out.println( "请输入第" + ( i + 1 ) + "位同学的成绩：" );
			score[ i ] = input.nextDouble();
		}
		return score;
	}


	public static void main( String[] args ) {

		// 数组初始化的3种方式
		int[] sc1 = new int[]{ 1, 2, 3 };
		int[] sc2 = { 1, 2, 3 };
		int[] sc3 = new int[ 5 ];

		double[] score = getDoubleArray();

		loopArray( score );
		sumArray( score );
		getMaxElement( score );
		findElement( score, 3 );
		reverseArray( score );
		sortArray( score );
		insertArray();

	}

}
