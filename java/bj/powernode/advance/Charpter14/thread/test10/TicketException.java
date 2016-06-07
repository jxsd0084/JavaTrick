package bj.powernode.advance.Charpter14.thread.test10;

//自定义异常类,继承RunTimeException(运行时异常)
public class TicketException extends RuntimeException {

	// 无参构造
	public TicketException() {

	}

	// 有参构造
	public TicketException( String msg ) {

		super( msg );
	}
}
