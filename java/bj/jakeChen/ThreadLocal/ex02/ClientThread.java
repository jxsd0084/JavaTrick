package bj.jakeChen.ThreadLocal.ex02;

/**
 * Created by Administrator on 2016/6/2.
 */
public class ClientThread extends Thread {

	private Sequence sequence;

	public ClientThread( Sequence sequence ) {

		this.sequence = sequence;
	}

	@Override
	public void run() {

		for ( int i = 0; i < 3; i++ ) {

			System.out.println( Thread.currentThread().getName() + " => " + sequence.getNumber() );
		}
	}

}
