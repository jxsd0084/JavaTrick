package bj.powernode.basic.day05;

/*

	Point类抽象三维空间中的点.
		包括的属性(成员变量): x,y,z  (double)
		抽象出一个方法：计算两点之间的距离.

*/

public class Point {

	//  成员变量(属性:attribute) --> 静属性

	double x;   //    点在空间中的x坐标
	double y;   //    点在空间中的y坐标
	double z;   //    点在空间中的z坐标


	//  因为要创建Point对象,所以需要提供构造方法
	//  缺省构造器
	Point() {

	}


	//  有参数的构造方法
	//  创建对象并且给对象的成员变量赋值
	Point( double _x, double _y, double _z ) {

		x = _x;
		y = _y;
		z = _z;
	}


	//  方法(函数-->动属性)
	//  怎么定义方法？ 1.该方法应该返回什么类型. 2.该方法应该传递什么类型的参数
	double getDistance( Point otherPoint ) {

		//用数学知识，计算两点之间的距离.
		return Math.sqrt( ( this.x - otherPoint.x ) * ( this.x - otherPoint.x )
		                  + ( this.y - otherPoint.y ) * ( this.y - otherPoint.y )
		                  + ( this.z - otherPoint.z ) * ( this.z - otherPoint.z ) );
	}


	//  程序的主方法
	public static void main( String[] args ) {


		//  计算两点之间的距离

		//  1.创建出空间中的一个点对象 a
		Point a = new Point( 1.0, 2.0, 3.0 );


		//  2.创建出空间中的另一个点对象 b
		Point b = new Point( 4.0, 5.0, 6.0 );


		//  3.调用getDistance方法来计算两点之间的距离
		double distance = a.getDistance( b );


		//  4.将结果打印到控制台
		System.out.println( "a和b点之间的距离=" + distance );



	}

}
