package bj.powernode.basic.day06.casting;


public class Test2 {


	//  编译阶段  运行阶段
	public static void main( String[] args ) {

		Animal a1 = new Cat( "tom", 3, "tom's attr" );  //  动态绑定.

		//  System.out.println(a1.catAttr);             //  编译无法通过.编译阶段只认为 a1 是Animal类型.

		a1.run();                                       //   动态绑定.	代码的扩展能力强.


	}

}
