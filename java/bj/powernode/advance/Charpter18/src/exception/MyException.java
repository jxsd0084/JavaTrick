package bj.powernode.advance.Charpter18.src.exception;

// 此处定义了一个自定义异常,
// 注意一个细节:继承的是RunTimeException("运行时异常")
public class MyException extends RuntimeException {

	// 构造方法1,参数:String类型 msg,并调用super传参
	public MyException( String msg ) {

		super( msg );
	}

	// 构造方法2,参数:Throwable类型 t,并调用super传参
	public MyException( Throwable t ) {

		super( t );
	}
}
