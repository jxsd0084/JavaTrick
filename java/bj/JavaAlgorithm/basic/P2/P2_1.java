package bj.JavaAlgorithm.basic.P2;

import java.util.Scanner;

//保存顺序表的结构数组 
class DATA {

	String key;                //结点的关键字
	String name;
	int    age;
}

//定义顺序表结构
class SLType {

	static final int MAXLEN = 100;
	DATA[] ListData = new DATA[ MAXLEN + 1 ];    //保存顺序表的结构数组
	int ListLen;                    //顺序表已存结点的数量

	//初始化顺序表
	void SLInit( SLType SL ) {

		SL.ListLen = 0;                //初始化为空表
	}

	//返回顺序表的元素数量
	int SLLength( SLType SL ) {

		return SL.ListLen;
	}

	int SLInsert( SLType SL, int n, DATA data ) {

		int i;
		if ( SL.ListLen >= MAXLEN ) {    //顺序表结点数量已超过最大数量
			System.out.print( "顺序表已满，不能插入结点!\n" );
			return 0;                //返回0表示插入不成功
		}
		if ( n < 1 || n > SL.ListLen - 1 ) {    //插入结点序号不正确
			System.out.print( "插入元素序号错误，不能插入元素！\n" );
			return 0;                //返回0，表示插入不成功
		}
		for ( i = SL.ListLen; i >= n; i-- ) {    //将顺序表中的数据向后移动
			SL.ListData[ i + 1 ] = SL.ListData[ i ];
		}
		SL.ListData[ n ] = data;            //插入结点
		SL.ListLen++;               //顺序表结点数量增加1

		return 1;                    //成功插入，返回1
	}

	//增加元素到顺序表尾部
	int SLAdd( SLType SL, DATA data ) {

		if ( SL.ListLen >= MAXLEN ) {    //顺序表已满
			System.out.print( "顺序表已满，不能再添加结点了！\n" );
			return 0;
		}
		SL.ListData[ ++ SL.ListLen ] = data;
		return 1;
	}

	//删除顺序表中的数据元素
	int SLDelete( SLType SL, int n ) {

		int i;
		if ( n < 1 || n > SL.ListLen + 1 ) {    //删除结点序号不正确
			System.out.print( "删除结点序号错误，不能删除结点！\n" );
			return 0;                //删除不成功，返回0
		}
		for ( i = n; i < SL.ListLen; i++ ) {    //将顺序表中的数据向前移动
			SL.ListData[ i ] = SL.ListData[ i + 1 ];
		}
		SL.ListLen--;                //顺序表元素数量减1

		return 1;                    //成功删除，返回1
	}

	//根据序号返回数据元素
	DATA SLFindByNum( SLType SL, int n ) {

		if ( n < 1 || n > SL.ListLen + 1 ) {       //元素序号不正确
			System.out.print( "结点序号错误，不能返回结点！\n" );
			return null;                //不成功，则返回0
		}

		return SL.ListData[ n ];
	}

	//按关键字查询结点
	int SLFindByCont( SLType SL, String key ) {

		int i;
		for ( i = 1; i <= SL.ListLen; i++ ) {
			if ( SL.ListData[ i ].key.compareTo( key ) == 0 ) {    //如果找到所需结点
				return i;                            //返回结点序号
			}
		}
		return 0;                                //搜索整个表后仍没有找到，则返回0
	}

	//显示顺序表中的所有结点
	int SLAll( SLType SL ) {

		int i;
		for ( i = 1; i <= SL.ListLen; i++ ) {
			System.out.printf( "(%s,%s,%d)\n", SL.ListData[ i ].key, SL.ListData[ i ].name, SL.ListData[ i ].age );
		}
		return 0;
	}
}

public class P2_1 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int    i;
		SLType SL = new SLType();                //定义顺序表变量
//	    DATA data = new DATA();       			//定义结点保存数据类型变量
		DATA   pdata;                //定义结点保存指针变量
		String key;                //保存关键字
		System.out.print( "顺序表操作演示!\n" );

		//初始化顺序表 
		SL.SLInit( SL );
		System.out.print( "初始化顺序表完成!\n" );

		Scanner input = new Scanner( System.in );
		do {
			//循环添加结点数据
			System.out.print( "输入添加的结点(学号 姓名 年龄)：" );
			DATA data = new DATA();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();
			if ( data.age != 0 ) {               //若年龄不为0
				if ( SL.SLAdd( SL, data ) == 0 ) {   //若添加结点失败
					break;            //退出死循环
				}
			} else {                //若年龄为0
				break;                //退出死循环
			}
		} while ( true );

		System.out.print( "\n顺序表中的结点顺序为：\n" );
		//显示所有结点数据
		SL.SLAll( SL );

		System.out.print( "\n要取出结点的序号：" );
		i = input.nextInt();               //输入结占点序号
		//按序号查找结点
		pdata = SL.SLFindByNum( SL, i );
		if ( pdata != null ) {                    //若返回的结点指针不为NULL
			System.out.printf( "第%d个结点为：(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age );
		}

		System.out.print( "\n要查找结点的关键字：" );
		key = input.next();            //输入关键字
		//按关键字查找 ，返回结点序号
		i = SL.SLFindByCont( SL, key );

		//按序号查询，返回结点指针
		pdata = SL.SLFindByNum( SL, i );
		if ( pdata != null ) {                     //若结点指针不为NULL
			System.out.printf( "第%d个结点为：(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age );
		}


	}

}


