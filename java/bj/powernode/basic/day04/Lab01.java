package bj.powernode.basic.day04;

public class Lab01 {

	public static int getInt() {        //    创建getInt()方法.
		//  int i = 10;
		//  return i;

		return 0; //结束方法
	}

	//    创建m()方法
	public static void m() {

		if ( 1 == 1 ) {                 //    注意:编译阶段和运行阶段!
			
		/*
		  Java编译运行过程:

		        当你一段代码写完之后一般会经历两个阶段：

		  1、编译阶段:使用指令：javac

			这个阶段，Java编译器(也就是JVM:java虚拟机，后称JVM)，首先把你的代码加载完成，然后开始检查语法。

			如果出现语法错误则提示错误。这个阶段提示的错误我们一般称为编译器错误！

		  2、运行阶段:使用指令：java

			这个阶段，JVM将执行java代码，这个时期出现的错误我们一般称为运行期错误！

		  3、总结:编译器错误一般都是语法错误！运行期错误一般都是程序内部(或者程序逻辑)错误！

		  4、例子:public class hello{
			    int i=10;
			    public static void main(String args[]){
			        System.out.println(i++);
			    }
			}

			 静态方法中非法访问非静态变量，错误在编译的时候就会不通过，javac的时候就会报错啊？

		         以上错误就是语法错误！

                 因为java规定了在静态方法中不能调用非静态的方法。这个错误已经被整合到了语法错误里面！
		*/

			return; //  结束方法
			
			/*
			  return关键字引申---> Java中的return语句总是和方法有密切关系，return语句总是用在方法中，有两个作用，
			  
                  一个是返回方法指定类型的值(这个值总是确定的)，一个是结束方法的执行(仅仅一个return语句)。

                  return语句用在非void返回值类型的方法中，不但能返回基本类型，还可以返回(包括用户自定义类的)对象。
			*/

		}


		System.out.println( "m method execute here!" );
	}


	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		
			/*
			  static关键字引申---> 通常，在一个类中定义一个方法为static，那就是说，无需本类的对象即可调用此方法。
			  
			                      调用一个静态方法就是“类名.方法名”,一般来说，静态方法常常为应用程序中的其它类提供一些实用工具所用.
			 
			  如果该方法中有static关键字,有两种调用方式:
			
			  1.    类名.方法名(实参列表);
			
			  2.    方法名(实参列表);
			*/


		// 第一种方式:类名.方法名(实参列表);即,基本数据类型 变量名 赋值运算符 类名.方法名();---> Lab01.getInt()
		int result = Lab01.getInt();

		System.out.println( result );

		//  第二种方式:方法名(实参列表);即,基本数据类型 变量名 赋值运算符 方法名();---> getInt()
		int result2 = getInt();

		System.out.println( result2 );

	}

}
