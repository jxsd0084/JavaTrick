package bj.powernode.advance.Charpter02.上次的作业;

/*
【程序2】
 某市的出租车计费标准为：3公里以内10元，3公里以后每
 加0.5公里加收1元；每等待2.5分钟加收1元；超过15公里
 的加收原价的50%为空驶费。
 要求编写程序，对于任意给定的里程数（单位：公里）和
 等待时间（单位：秒）计算出应付车费
 */

//---------源代码------------
public class Fare {

	/*
	public static void main(String[] args){
	    int kilometre = 34;
		int waitTime = 300;

		double money = 0.0;
		if (kilometre <= 3) {
			money = 10.0;
		}// 如果大于15公里,在正常车费的基础上要加收50%的空驶费用
		else if (kilometre > 15) {
			// 计算出基本的收费
			float count = kilometre / 0.5f;
			money = count * 1.0 + 10.0;
			money += money * 0.5;

			// 如果等待时间大于150秒,每150秒增加1元
			double waitTimeMoney = 0.0;
			if (waitTime > 150) {
				waitTimeMoney = waitTime / 150 * 1.0;
			}

			// 总的金额 = 车费 + 等候费
			money += waitTimeMoney;
		}
		// 如果小于15公里,不加收50%的空驶费
		else {
			// 计算出基本的收费
			float count = kilometre / 0.5f;
			money = count * 1.0 + 10.0;

			// 如果等待时间大于150秒,每150秒增加1元
			double waitTimeMoney = 0.0;
			if (waitTime > 150) {
				waitTimeMoney = waitTime / 150 * 1.0;
			}
			// 总的金额 = 车费 + 等候费
			money += waitTimeMoney;
		}		
		System.out.println("行驶里程:" + kilometre + " 公里,等待时间:" + waitTime + " 的车费是:" +  money + "元");	
	}
	*/


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Fare   f     = new Fare();
		double money = f.accountFare( 18, 500 );
		System.out.println( money );
	}


	/**
	 * 计算车费
	 *
	 * @param kilometre 输入的公里数
	 * @param waitTime  等待的时间(单位:秒)
	 * @return 车费的金额
	 */
	public double accountFare( int kilometre, int waitTime ) {

		double money = 0.0;
		if ( kilometre <= 3 ) {
			money = 10.0;

		} else if ( kilometre > 15 ) { // 如果大于15公里,在正常车费的基础上要加收50%的空驶费用
			// 计算出基本的收费
			float count = kilometre / 0.5f;
			money = count * 1.0 + 10.0;
			money += money * 0.5;

			// 如果等待时间大于150秒,每150秒增加1元
			double waitTimeMoney = 0.0;
			if ( waitTime > 150 ) {

				waitTimeMoney = waitTime / 150 * 1.0;
			}

			// 总的金额 = 车费 + 等候费
			money += waitTimeMoney;

		} else { // 如果小于15公里,不加收50%的空驶费
			// 计算出基本的收费
			float count = kilometre / 0.5f;
			money = count * 1.0 + 10.0;

			// 如果等待时间大于150秒,每150秒增加1元
			double waitTimeMoney = 0.0;
			if ( waitTime > 150 ) {

				waitTimeMoney = waitTime / 150 * 1.0;
			}

			// 总的金额 = 车费 + 等候费
			money += waitTimeMoney;
		}

		return money;
	}

}
