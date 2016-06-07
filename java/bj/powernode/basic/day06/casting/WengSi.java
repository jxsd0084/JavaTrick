package bj.powernode.basic.day06.casting;

public class WengSi {

	//  喂养动物.
	//  public void feed(Dog dog){
	//  	dog.eat();
	//  }

	//  public void feed(Cat cat){
	//  	cat.eat();
	//  }

	//  public void feed(Tiger tiger){
	//  	tiger.eat();
	//  }


	//  多态实现扩展能力
	public void feed( Animal a ) {

		a.eat();
	}


}
