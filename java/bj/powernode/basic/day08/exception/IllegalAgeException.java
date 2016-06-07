package bj.powernode.basic.day08.exception;

public class IllegalAgeException extends RuntimeException{ //运行时异常.

	public IllegalAgeException(){}
	
	public IllegalAgeException(String msg){

		super(msg);	
	}

}
