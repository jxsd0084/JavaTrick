package bj.mldn.javase02.ch06.no04;

class A2 {

	public final void print() {    // 使用final声明的方法不能被覆写
		System.out.println("HELLO");
	}
}

class B2 extends A2 {

	/*

		public void print() {    // 错误，不能被覆写
			System.out.println("MLDN");
		}

	*/
}
