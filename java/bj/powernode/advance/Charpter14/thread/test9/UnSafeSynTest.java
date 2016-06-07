package bj.powernode.advance.Charpter14.thread.test9;

//非同步的生产者与消费者模式
public class UnSafeSynTest {

	// 主方法测试
	public static void main( String[] args ) {
		// 创建Stock类的对象,并传String类型的值
		Stock stock = new Stock( "堆栈1" );
		// 创建生产者对象并传参
		Producer pro = new Producer( stock, "生产者" );
		// 创建消费者对象并传参
		Customer cus = new Customer( stock, "消费者" );
	}
}

/**
 * 生成者线程,专门负责压栈
 *
 * @author Administrator
 */
class Producer extends Thread {

	// Stock类型的属性
	private Stock theStock;

	// 有参构造方法
	public Producer( Stock theStock, String name ) {

		super( name );
		this.theStock = theStock;
		// 当对象创建后自动启动线程
		this.start();
	}

	// 重写父类的run方法
	public void run() {
		// 准备String类型的goods
		String goods = null;
		// for循环0到199
		for ( int i = 0; i < 200; i++ ) {
			// 将接收到的point赋给goods
			goods = "goods" + ( this.theStock.getPoint() + 1 );
			// 调用Stock的压栈方法
			this.theStock.push( goods );
			// 将得到的goods信息输出
			System.err.println( getName() + ": 压入 " + goods + " " + " 成功" );
			// 暂停当前线程
			this.yield();
		}
	}
}

/**
 * 消费者线程,专门负责弹栈
 *
 * @author Administrator
 */
class Customer extends Thread {

	// Stock类型的属性
	private Stock theStock;

	// 有参构造方法
	public Customer( Stock theStock, String name ) {

		super( name );
		this.theStock = theStock;
		// 创建线程对象时自动启动线程
		start();
	}

	// 重写父类的run方法
	public void run() {
		// 准备String类型的goods
		String goods = null;
		// for循环0到199
		for ( int i = 0; i < 200; i++ ) {
			// 调用Stock类的弹栈方法并赋给goods
			goods = this.theStock.pop();
			// 输出取得的goods信息
			System.out.println( getName() + ": 取出 " + goods + " " + " 成功" );
			// 暂停当前线程
			this.yield();
		}
	}
}

// Stock类
class Stock {

	// String类型属性name
	private String name;

	// String类型数组buffers
	private String[] buffers = new String[ 100 ];

	// 设置int类型point并赋值为-1
	private int point = - 1;

	// 有参构造方法
	public Stock( String name ) {

		this.name = name;
	}

	// setter and getter
	public String getName() {

		return this.name;
	}

	public int getPoint() {

		return point;
	}

	// 同步线程方法弹栈pop
	public synchronized String pop() {
		// 将buffers数组得到的point赋值给String goods
		String goods = buffers[ point ];
		// 将buffers数组清空
		buffers[ point ] = null;
		// 暂停当前线程
		Thread.yield();
		// point自减一次
		point--;
		// 将得到的goods返回
		return goods;
	}

	// 同步线程压栈方法push,将String goods传入
	public synchronized void push( String goods ) {
		// point自加一次
		point++;
		// 暂停当前线程
		Thread.yield();
		// 将goods赋值给buffers数组
		buffers[ point ] = goods;
	}

}
