package bj.bigData.HBase.ex03.query.exception;

/**
 * 客户端输入了错误的参数
 *
 * @author ranhualin
 * @date 2013-7-24
 */
public class ClientParameterException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int errorCode = -1;

	public ClientParameterException() {

		super();
	}

	public int getErrorCode() {

		return errorCode;
	}

	public ClientParameterException( String message ) {

		super( message );
	}
	
	public ClientParameterException( int errorCode, String message ) {

		super( message );
		this.errorCode = errorCode;
	}

	public ClientParameterException( String message, Throwable cause ) {

		super( message, cause );
	}

	public ClientParameterException( Throwable cause ) {

		super( cause );
	}
}
