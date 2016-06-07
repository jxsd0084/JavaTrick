package bj.mldn.javase01.no94.demo.helloserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {

	public static void main(String[] args) throws Exception {

		Socket         client = new Socket("localhost", 8888);  // 表示连接的主机及端口
		BufferedReader buf    = null;
		buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str = buf.readLine();    // 接收回应的内容
		System.out.println("内容是：" + str);
		client.close();
	}

}
