package bj.powernode.advance.Charpter10.homework.test5;

import java.io.*;

public class Student extends Person {

	// 在方法覆盖的时候,异常不能扩大
	public void f1() throws FileNotFoundException {

	}

	public void f2() throws FileNotFoundException {

	}

	// 在方法重载的时候,异常没有限制
	public void f2( int i ) {

	}

	public void f2( byte i ) throws Exception {

	}

	public void f2( short i ) throws IOException {

	}

}
