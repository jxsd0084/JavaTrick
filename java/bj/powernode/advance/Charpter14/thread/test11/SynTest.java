package bj.powernode.advance.Charpter14.thread.test11;

//同步测试类
public class SynTest {

	// 主方法测试
	public static void main( String[] args ) {

		// 创建堆对象
		Stock stock = new Stock( "堆栈1" );

		// 创建生产者对象
		Producer pro = new Producer( stock, "生产者" );

		// 创建消费者对象
		Customer cus = new Customer( stock, "消费者" );

	}

}

/**
 * 生产者线程
 *
 * @author Administrator
 */
class Producer extends Thread {

	// 堆类型的属性
	private Stock theStock;

	// 有参构造方法
	public Producer( Stock theStock, String name ) {

		super( name );
		this.theStock = theStock;
		//当创建线程对象时自动启动线程
		this.start();
	}

	// 重写的run方法
	public void run() {
		// 准备String类型的变量,初始化为null
		String goods = null;
		// for循环0到199赋值给String goods
		for ( int i = 0; i < 200; i++ ) {
			//将从Stock类中得到的 point赋给goods
			goods = "goods" + ( this.theStock.getPoint() + 1 );
			//调用Stock类的进栈方法
			this.theStock.push( goods );

			System.out.println( getName() + ": 压入 " + goods + " " + " 成功" );
			// 暂停当前线程
			this.yield();
		}
	}
}

/**
 * 消费者线程
 *
 * @author Administrator
 */
class Customer extends Thread {

	// 准备Stock类型的属性
	private Stock theStock;

	// 有参构造方法
	public Customer( Stock theStock, String name ) {
		// name传给父类
		super( name );
		this.theStock = theStock;
		this.start();
	}

	// 重写Thread的run方法
	public void run() {
		// 准备String类型的局部变量,并初始化为null
		String goods = null;
		// for循环0到199赋值给String goods
		for ( int i = 0; i < 200; i++ ) {
			// 调用pop方法并赋值给String goods
			goods = this.theStock.pop();
			// 输出信息
			System.out.println( getName() + ": 取出 " + goods + " " + " 成功" );
			// 暂停当前线程
			this.yield();
		}
	}
}

// Stock类
class Stock {

	// String类型的属性
	private String name;
	// String[]类型 buffers数组属性
	private String[] buffers     = new String[ 100 ];
	// int类型的属性
	private int      point       = - 1;
	// boolean类型的属性,判断数据是否已经准备好了
	private boolean  dataIsReady = false;

	// 构造方法
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

	// synchronized同步线程方法(将进栈方法给锁住了)
	// public synchronized String pop() {
	// 将buffers数组赋值给String goods
	// String goods = buffers[point];
	// 将数组清空
	// buffers[point] = null;
	// 暂停当前线程
	// Thread.yield();
	// int属性point自减
	// point--;
	// 将得到的String goods返回
	// return goods;
	// }

	// synchronized同步线程方法(将弹栈方法给锁住了)
	// public synchronized void push(String goods) {
	// int属性point自加
	// point++;
	// 暂停当前线程
	// Thread.yield();
	// 将得到的String goods赋值给buffers数组
	// buffers[point] = goods;
	// }

	// 进栈push方法传入参数String goods
	public void push( String goods ) {

		// 加同步线程锁(块)
		synchronized ( this ) {
			// while循环,但tatIsReady为true时,让线程wait等待
			while ( dataIsReady ) {
				try {

					// 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待
					this.wait();
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
			}

			// int类型的局部变量point自加一次
			point++;
			// 暂停当前线程
			Thread.yield();
			// 将局部变量String goods接收到的值赋给buffers数组
			buffers[ point ] = goods;
			// 此时将dataIsReady改为true
			dataIsReady = true;
			// 再通知wait中的线程启动
			this.notifyAll();
		}
	}

	// 弹栈POP方法
	public String pop() {
		// 同步线程锁(块)
		synchronized ( this ) {
			// 如果dataIsReady为false
			while ( ! dataIsReady ) {
				try {
					// 让线程wait直到notify或notifyAll通知线程启动
					this.wait();
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
			}
			// 将buffers数组赋给String goods
			String goods = buffers[ point ];
			// 然后将buffers数组清空
			buffers[ point ] = null;
			// 暂停当前弹栈线程
			Thread.yield();
			// 局部变量point自减一次
			point--;
			// 将dataIsReady改为false
			dataIsReady = false;
			// 通知处于wait状态中的线程
			this.notifyAll();
			// 将得到的String goods返回
			return goods;
		}
	}

}
