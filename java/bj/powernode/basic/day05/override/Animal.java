/*

	java语言中的重写(Over Ride / Over Write)
	注意：构成重写的前提是,发生在不同的类中,并且要求这两个类之间有继承关系.
	
	构成重写: 两个方法必须分布在不同的类中，并且这两个类之间有继承关系.
	
	什么时候用重写？  将方法重新写一遍
	
	父类中方法的实现已经无法满足子类的需求.就需要将父类中的run方法进行重写.
	将方法重写之后，子类对象自然会调用重写以后的方法.
	
	重写的条件是：方法名一致,参数列表相同.方法的修饰符(访问权限)不能更小.
	

*/

package bj.powernode.basic.day05.override;

public class Animal{

	public void run(){

		System.out.println("动物在奔跑");
	}
	
}
