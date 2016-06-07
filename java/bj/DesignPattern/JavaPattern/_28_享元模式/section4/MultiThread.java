package bj.DesignPattern.JavaPattern._28_享元模式.section4;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class MultiThread extends Thread {

	private SignInfo signInfo;

	public MultiThread( SignInfo _signInfo ) {
		this.signInfo = _signInfo;
	}

	public void run() {
//		try {
//			Thread.currentThread().sleep(1000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		if ( !signInfo.getId()
				.equals( signInfo.getLocation() ) ) {
			System.out.println( "编号：" + signInfo.getId() );
			System.out.println( "考试地址：" + signInfo.getLocation() );
			System.out.println( "线程不安全了！" );

		} else {
//			System.out.println("编号：" + signInfo.getId());
//			System.out.println("考试地址：" + signInfo.getLocation());
			System.out.println( " + " );

		}
	}

}
