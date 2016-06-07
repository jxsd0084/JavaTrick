package bj.powernode.basic.day05.override;

public class Cat extends Animal{

	public void run(){

		System.out.println("猫在走猫步.");
	}
	
	public static void main(String[] args){
		Cat c = new Cat();
		c.run();
	}
	
}
