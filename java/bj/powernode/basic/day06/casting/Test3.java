package bj.powernode.basic.day06.casting;


//  测试软件扩展能力
public class Test3 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		WengSi ws = new WengSi();

		//  1.翁私喂狗
		//  Dog d1 = new Dog();

		Animal d1 = new Dog();
		ws.feed( d1 );





		//  2.翁私喂猫
		//  Cat c1 = new Cat();

		Animal c1 = new Cat();
		ws.feed( c1 );





		//  3.翁私喂虎
		//  Tiger t1 = new Tiger();

		Animal t1 = new Tiger();
		ws.feed( t1 );


	}

}
