package bj.mldn.javase01.no94.demo.udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static void main(String[] args) throws Exception {

		DatagramSocket socket = new DatagramSocket(3000);                   // 客户端在3000端口等待接收服务器发来的信息
		DatagramPacket pack   = new DatagramPacket(new byte[1024], 1024);   // 开辟1024的空间
		socket.receive(pack);
		System.out.println("接收到的内容是：" + new String(pack.getData()));
	}

}
