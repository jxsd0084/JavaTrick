package bj.powernode.basic.day08.exception.exception_application;

//定义一个检查时异常.
public class IllegalNameException extends Exception {

	public IllegalNameException() {

	}

	public IllegalNameException( String msg ) {

		super( msg );
	}
}
