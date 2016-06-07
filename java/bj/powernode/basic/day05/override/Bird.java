package bj.powernode.basic.day05.override;

public class Bird extends Animal{

	public void run(){

		System.out.println("鸟在飞翔.");
	}
	
	public static void main(String[] args){

		Bird b = new Bird();

		b.run();
	}
	
}
