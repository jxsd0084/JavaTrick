package bj.powernode.basic.day07.exercise.exercise01;

public class YAMAHA implements IEngine {

	//重写一个方法的时候:访问权限不能比原方法更低
   	/*
   		重写要求:
   			1.方法名一致
   			2.方法的返回值类型一致
   			3.方法的参数列表一致.
   			4.访问权限不能更低.
   			5.抛出的异常不能更宽泛.(********)
   	
   	*/
	public void start() {

		System.out.println( "YAMAHA启动，速度60" );
	}

	public void stop() {

		System.out.println( "YAMAHA停止，速度0" );
	}

	public void speedup() {

		System.out.println( "YAMAHA加速，速度80" );
	}

}
