package bj.mldn.javase02.ch16.no01;

class Demo3 < T > {

	private T var;

	public T getVar() {

		return this.var;
	}

	public void setVar( T var ) {

		this.var = var;
	}
}

public class SuppressWarningsAnnotationDemo01 {

	@SuppressWarnings("unchecked")
	public static void main( String args[] ) {

		Demo3 d = new Demo3();
		d.setVar( "李兴华" );
		System.out.println( "内容：" + d.getVar() );
	}
}
