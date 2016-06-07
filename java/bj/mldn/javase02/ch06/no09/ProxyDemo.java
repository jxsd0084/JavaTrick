package bj.mldn.javase02.ch06.no09;

interface Network {

	public void browse();    // 浏览
}

class Real implements Network {

	public void browse() {

		System.out.println("上网浏览信息");
	}
}

class Proxy implements Network {

	private Network network;    // 代理对象

	public Proxy(Network network) {

		this.network = network;
	}

	public void check() {

		System.out.println("检查用户是否合法。");
	}

	public void browse() {

		this.check();
		this.network.browse();    // 调用真实的主题操作
	}
}

public class ProxyDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		Network net = null;
		net = new Proxy(new Real());//  指定代理操作
		net.browse();    // 客户只关心上网浏览一个操作
	}
}
