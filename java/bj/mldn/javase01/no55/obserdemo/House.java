package bj.mldn.javase01.no55.obserdemo;

import java.util.Observable;

public class House extends Observable {

	private float price;

	public House( float price ) {

		this.price = price;
	}

	public String toString() {

		return "房子";
	}

	public float getPrice() {

		return price;
	}

	public void setPrice( float price ) {

		super.setChanged();             // 通知内容已经可以被修改了
		this.price = price;
		// 一旦修改，则表示价格改变，那么价格改变之后，实际上应该立刻通知所有的观察者
		super.notifyObservers( price );   // 通知所有的观察者已经改变
	}

}
