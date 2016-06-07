package bj.mldn.javase01.no94.demo.udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {

	public static void main(String[] args) throws Exception {

		DatagramSocket socket = new DatagramSocket(9000);       // 服务器端在9000端口等待接收服务器发来的信息
		String         str    = "hello world!!!";
		DatagramPacket pack = new DatagramPacket(str.getBytes(), 0, str
				.length(), InetAddress.getLocalHost(), 3000);   // 开辟1024的空间
		socket.send(pack);
	}

}
