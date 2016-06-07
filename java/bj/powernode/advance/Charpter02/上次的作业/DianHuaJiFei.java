package bj.powernode.advance.Charpter02.上次的作业;

/*
【程序1】  
 某电信公司的市内通话费计算标准如下：三分钟内0.2元，
 三分钟后每增加一分钟增加0.1元，不足一分钟的按一分
 钟计算。要求编写程序，给定一个通话时间（单位：秒）
 计算出应收费金额。
 */

//---------源代码------------
public class DianHuaJiFei {

	/*
	public static void main(String args[]){

		 int second = 720;
         float money = 0.0F;

		 if(second <= 180 ){
		     money = 0.2f;
		 }else{
		     int i =  (second-180);
			 // 如果时间能够被60整除,既整分钟的情况
			 if(i % 60 == 0){
			    money = ( i/60 )*0.1f +0.2f;
			 }else{
			    money = ( i/60 )*0.1f + 0.1f +0.2f;
			 }
		 }

		 System.out.println(second+ " 秒的电话费是:" + money + "元");
	}
	*/


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		DianHuaJiFei jf    = new DianHuaJiFei();
		float        money = jf.spendMoney( 300 );
		System.out.println( "电话费是:" + money );
	}


	/**
	 * 计算一个时间所花费的金额
	 *
	 * @param second 输入的时间(秒数)
	 * @return flaot类型的钱数
	 */
	public float spendMoney( int second ) {

		float money = 0.2f;
		// 如果时间是在3分钟之内
		if ( second <= 180 ) {
			money = 0.2f;

		} else {  // 三分钟之外
			int mintue = 0;
			// 如果秒数是整分钟数
			if ( ( second % 60 ) == 0 ) {
				mintue = second / 60 - 3;

			} else { // 如果不是整分钟数
				mintue = second / 60 - 3 + 1;

			}

			System.out.println( "超出的分钟数是:" + mintue );
			money = money + 0.1f * mintue;
		}

		return money;
	}

}

