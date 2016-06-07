package bj.powernode.basic.day07.exercise.exercise03.exception02;

/*

	运行时异常. UnCheckedException  运行阶段.

*/
public class MustStringArgumentException extends RuntimeException {

	public MustStringArgumentException() {

	}

	public MustStringArgumentException( String msg ) {

		super( msg );
	}

}
