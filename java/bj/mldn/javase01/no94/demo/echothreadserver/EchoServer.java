package bj.mldn.javase01.no94.demo.echothreadserver;

import java.net.ServerSocket;

public class EchoServer {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(8888); // 在8888端口上开启服务
		boolean      flag   = true;
		while (flag) {
			System.out.println("等待客户端连接。。。。。");
			new Thread(new EchoThread(server.accept())).start();
		}
		server.close();
	}
}
