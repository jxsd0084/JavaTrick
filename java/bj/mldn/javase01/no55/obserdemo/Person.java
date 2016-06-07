package bj.mldn.javase01.no55.obserdemo;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {

	// arg表示改变之后的内容
	// o表示观察的对象
	public void update( Observable o, Object arg ) {

		System.out.println( o + "*** 被观察的操作有所更改。" + arg );
	}

}
