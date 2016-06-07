package bj.mldn.javase02.ch16.no01;

@Deprecated
class Demo4 < T > {

	private T var;

	public T getVar() {

		return this.var;
	}

	public void setVar( T var ) {

		this.var = var;
	}
}

public class SuppressWarningsAnnotationDemo02 {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main( String args[] ) {

		Demo4 d = new Demo4();
		d.setVar( "李兴华" );
		System.out.println( "内容：" + d.getVar() );
	}
}
