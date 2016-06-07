package bj.mldn.javase02.ch12.no06;

import java.io.*;

class Send implements Runnable {             // 线程类

	private PipedOutputStream pos = null;    // 管道输出流

	public Send() {

		this.pos = new PipedOutputStream();  // 实例化输出流
	}

	public void run() {

		String str = "Hello World!!!";       // 要输出的内容
		try {
			this.pos.write( str.getBytes() );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		try {
			this.pos.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public PipedOutputStream getPos() {     // 得到此线程的管道输出流
		return this.pos;
	}
};

class Receive implements Runnable {

	private PipedInputStream pis = null;    // 管道输入流

	public Receive() {

		this.pis = new PipedInputStream();  // 实例化输入流
	}

	public void run() {

		byte b[] = new byte[ 1024 ];        // 接收内容
		int  len = 0;
		try {
			len = this.pis.read( b );       // 读取内容
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		try {
			this.pis.close();               // 关闭
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		System.out.println( "接收的内容为：" + new String( b, 0, len ) );
	}

	public PipedInputStream getPis() {

		return this.pis;
	}
}

public class PipedDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Send    s = new Send();
		Receive r = new Receive();
		try {
			s.getPos().connect( r.getPis() );    // 连接管道
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		new Thread( s ).start();                 // 启动线程
		new Thread( r ).start();                 // 启动线程
	}
}
