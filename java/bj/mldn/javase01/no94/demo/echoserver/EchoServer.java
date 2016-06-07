package bj.mldn.javase01.no94.demo.echoserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(8888); // 在8888端口上开启服务
		Socket       client = null; // 表示连接的客户端
		boolean      flag   = true;
		while (flag) {
			System.out.println("等待客户端连接。。。。。");
			client = server.accept(); // 接受客户端的连接
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintStream pout = new PrintStream(client.getOutputStream());   // 得到客户端的输出流
			boolean     temp = true;
			while (temp) {  // 循环接收用户输入的内容并回应
				String str = buf.readLine();
				if (str == null || "".equals(str)) {
					temp = false;
					break;
				}
				if ("bye".equals(str)) {
					temp = false;
					break;
				}
				pout.println("ECHO:" + str); // 回送信息
			}
			pout.close();
			client.close();
		}
		server.close();
	}

}
