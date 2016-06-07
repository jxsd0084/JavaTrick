package bj.powernode.basic.day07.exercise.exercise03.exception01;

/*

	检查时异常. CheckedException  编译阶段.

*/
public class MustStringArgumentException extends Exception {

	public MustStringArgumentException() {

	}

	public MustStringArgumentException( String msg ) {

		super( msg );
	}

}
