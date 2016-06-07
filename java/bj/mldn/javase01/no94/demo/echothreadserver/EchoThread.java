package bj.mldn.javase01.no94.demo.echothreadserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable {

	private Socket client;

	public EchoThread(Socket client) {

		this.client = client;
	}

	public void run() {

		try {
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
		} catch (Exception e) {
		}
	}
}
