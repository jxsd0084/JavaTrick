package bj.JavaAlgorithm.basic02.ch02;

public class ch2_3
{
	public static  final  double MONEYRATE=0.0171;
	public static void main(String[] args) {
  
		//年利率,设置为常量
  
  
		//定义一个长度为48的数组，用来装每个月月初还剩下的存款
		double money[]=new double[48];
		
		//最后一个月月初1000元
		money[47]=1000;
		System.out.printf("48月初的剩余存款数为：%.2f\n",money[47]);
		//通过循环逆推出前一个月的剩余存款
		for(int i=47;i>0;i--){
			money[i-1]=1000+money[i]/(1+MONEYRATE/12);
			System.out.printf("%d月初的剩余存款数为：%.2f\n",i,money[i-1]);
		}
		//算出最初要存入的钱，即第一个剩余存款数
		System.out.printf("\n最初要存入%.2f元。",money[0]);
  
/*		//第48个月初小龙取走最后的1000元,于是给第48个元素赋值为0,表示第48个月初的存款为0;
		money[47]=0;
  
		System.out.println(48+"月初的剩余存款数为："+money[47]);
		//通过循环逆推出前一个月的剩余存款
		for(int i=47;i>0;i--){
			money[i-1]=money[i]/(1+MONEYRATE/12)+1000;
			System.out.println(i+"月初的剩余存款数为："+money[i-1]);
		}
  
		//算出最初要存入的钱
		double saveMoney=money[0]/(1+MONEYRATE/12)+1000;
		System.out.println("最初要存入"+saveMoney+"元");*/
	}
}
