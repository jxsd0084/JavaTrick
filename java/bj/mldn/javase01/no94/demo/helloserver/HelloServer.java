package bj.mldn.javase01.no94.demo.helloserver;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(8888); // 在8888端口上开启服务
		Socket       client = null; // 表示连接的客户端
		System.out.println("等待客户端连接。。。。。");
		client = server.accept();   // 接受客户端的连接
		OutputStream out  = client.getOutputStream(); // 得到客户端的输出流
		PrintStream  pout = new PrintStream(out);
		pout.println("hello world!!!");
		pout.close();
		out.close();
		client.close();
		server.close();
	}

}
