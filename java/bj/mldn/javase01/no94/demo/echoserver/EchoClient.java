package bj.mldn.javase01.no94.demo.echoserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception {

		Socket client = new Socket("localhost", 8888);  // 表示连接的主机及端口
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedReader buf = null;
		buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintStream out  = new PrintStream(client.getOutputStream());
		boolean     flag = true;
		while (flag) {
			System.out.print("请输入要发送的内容：");
			String str = input.readLine();  // 接收回应的内容
			if (str == null || "".equals(str)) {
				flag = false;
				break;
			}
			if ("bye".equals(str)) {
				flag = false;
				break;
			}
			out.println(str);
			System.out.println(buf.readLine());
		}
		client.close();
	}

}
