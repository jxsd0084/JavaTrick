package bj.powernode.advance.Charpter14.thread.test8;

// 银行账户类
public class Account {

	// 账户的余额
	private int balance = 1000;

	// 取款方法1(带有同步线程块),参数(int money)抛出自定义异常AccountException
	public int getMoney( int money ) throws AccountException {

		// 同步线程块
		synchronized ( this ) {
			// 如果账户余额部小于取款金额的话
			if ( this.balance >= money ) {
				try {
					// 让线程睡上10毫秒以制造混乱
					Thread.sleep( 10 );
				} catch ( InterruptedException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 账户余额=现有金额-取款金额
				balance -= money;
				// 将确定的现金金额返回
				return money;
			} else {
				// 否则抛出自定义异常AccountException
				throw new AccountException( "账户余额不足!" );
			}
		}
	}

	// 取款方法2(同步线程锁方法)参数(int money)抛出自定义异常AccountException
	public synchronized int getMoney1( int money ) throws AccountException {

		// 如果账户金额不小于取款金额
		if ( this.balance >= money ) {
			try {
				// sleep()的时候,锁并不会被释放
				Thread.sleep( 10 );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
			// 账户剩余金额= 账户现有金额-取款金额
			balance -= money;
			// 将取到的现金金额返回
			return money;
		} else {
			// 否则,抛出自定义异常AccountException
			throw new AccountException( "账户余额不足!" );
		}
	}
}
