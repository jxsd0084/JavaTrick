package bj.mldn.javase01.no69.pipeddemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Send implements Runnable {    // 发送数据的线程

	private PipedOutputStream output = null;

	public Send() {

		this.output = new PipedOutputStream();
	}

	public PipedOutputStream getPipedOutputStream() {

		return this.output;
	}

	public void run() {

		String str = "hello world!!!";  // 要发送的数据
		try {
			this.output.write( str.getBytes() );  // 发送
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		try {
			this.output.close(); // 关闭
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}

class Receive implements Runnable { // 接收数据的线程

	private PipedInputStream input = null;

	public Receive() {

		this.input = new PipedInputStream();
	}

	public PipedInputStream getPipedInputStream() {

		return this.input;
	}

	public void run() {

		byte b[] = new byte[ 1024 ]; // 接收内容
		int  len = 0;
		try {
			len = this.input.read( b );// 内容读取
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		try {
			this.input.close(); // 关闭
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		System.out.println( new String( b, 0, len ) );
	}
}

public class ThreadConnectDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws IOException {

		Send    send = new Send();
		Receive rec  = new Receive();
		send.getPipedOutputStream().connect( rec.getPipedInputStream() ); // 进行管道连接
		new Thread( send ).start(); // 启动线程
		new Thread( rec ).start();  // 启动线程
	}

}
