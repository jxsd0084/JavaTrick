package bj.JavaAlgorithm.basic.P2;

import java.util.Scanner;

//基于数组的队列
class DATA4 {

	String name;
	int    age;
}

class SQType {

	static final int QUEUELEN = 15;
	DATA4[] data = new DATA4[ QUEUELEN ];                    //队列数组
	int head;                                //队头
	int tail;                                //队尾

	SQType SQTypeInit() {

		SQType q;

		if ( ( q = new SQType() ) != null ) {        //申请内存

			q.head = 0;                        //设置队头
			q.tail = 0;                            //设置队尾
			return q;
		} else {
			return null;                        //返回空
		}
	}

	//判断空队列
	int SQTypeIsEmpty( SQType q ) {

		int temp = 0;
		if ( q.head == q.tail ) {
			temp = 1;
		}
		return temp;
	}

	//判断满队列
	int SQTypeIsFull( SQType q ) {

		int temp = 0;
		if ( q.tail == QUEUELEN ) {
			temp = 1;
		}
		return temp;
	}

	//清空队列
	void SQTypeClear( SQType q ) {

		q.head = 0;                            //设置队头
		q.tail = 0;                                //设置队尾
	}

	//释放队列
	void SQTypeFree( SQType q ) {

		if ( q != null ) {
			q = null;
		}
	}

	//入队列
	int InSQType( SQType q, DATA4 data ) {

		if ( q.tail == QUEUELEN ) {
			System.out.print( "队列已满!操作失败!\n" );
			return 0;
		} else {
			q.data[ q.tail++ ] = data;                //将元素入队列
			return 1;
		}
	}

	//出队列
	DATA4 OutSQType( SQType q ) {

		if ( q.head == q.tail ) {
			System.out.print( "\n队列已空!操作失败!\n" );
			System.exit( 0 );
		} else {
			return q.data[ q.head++ ];
		}
		return null;
	}

	//读结点数据
	DATA4 PeekSQType( SQType q ) {

		if ( SQTypeIsEmpty( q ) == 1 ) {
			System.out.print( "\n空队列!\n" );
			return null;
		} else {
			return q.data[ q.head ];
		}
	}

	//计算队列长度
	int SQTypeLen( SQType q ) {

		int temp;
		temp = q.tail - q.head;
		return temp;
	}

}

public class P2_4 {

	public static void main( String[] args ) {

		SQType st = new SQType();
		DATA4  data1;

		Scanner input = new Scanner( System.in );

		//初始化队列
		SQType stack = st.SQTypeInit();
		System.out.print( "入队列操作：\n" );
		System.out.println( "输入姓名 年龄进行入队列操作:" );
		do {
			DATA4 data = new DATA4();
			data.name = input.next();
			data.age = input.nextInt();
			if ( data.name.equals( "0" ) ) {
				break;                        //若输入0，则退出
			} else {
				st.InSQType( stack, data ); //入队列
			}
		} while ( true );


		String temp = "1";
		System.out.println( "出队列操作:按任意非0键进行出栈操作:" );
		temp = input.next();
		while ( ! temp.equals( "0" ) ) {
			data1 = st.OutSQType( stack ); //出队列
			System.out.printf( "出队列的数据是(%s,%d)\n", data1.name, data1.age );
			temp = input.next();
		}

		System.out.println( "测试结束！" );
		//释放队列所占用的空间
		st.SQTypeFree( stack );

	}

}
