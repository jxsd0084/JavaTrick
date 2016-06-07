package bj.powernode.basic.day05;


public class Leaf {

	//  属性
	private static int sid;             //  静态变量
	private        int id;              //  实例变量 (成员变量)
	private String name = "Feng Ye";    //  实例变量

	//  构造无参方法
	public Leaf() {

	}

	//  实例方法
	public void increment() {

		id = sid++;
	}


	//  主方法
	public static void main( String[] args ) {

		//  创建Leaf类型的对象 a
		Leaf a = new Leaf();
		a.increment();


		//  创建Leaf类型的对象 b
		Leaf b = new Leaf();
		b.increment();


		//  如果sid是static的.
		System.out.println( a.id );     //  0
		System.out.println( b.id );     //  1
		System.out.println( Leaf.sid ); //  2


		//  如果sid是实例变量
		//  System.out.println(a.id);   //  0
		//  System.out.println(b.id);   //  0
		//  System.out.println(a.sid);  //  1
		//  System.out.println(b.sid);  //  1

	}


}
