package bj.powernode.basic.day07.compute;

/*

	实现计算器:  + - * /

*/
public class _06_Compute{

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String[] args){  

		if(args.length != 3){ //命令行必须传递3个参数

			System.out.println("useAge:num1 oprator num2. operator contains '+ - x /'");

			return;
		}
		
		/*
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
		*/
		
		
		
		//1.将接收到的字符串转换成数值类型. "11" --> 11
		/*
			在java语言中每一个基本类型的数据都会对应一个引用类型的数据.

			例如: 
			      byte      --> java.lang.Byte;
			      short     --> java.lang.Short;
			      long      --> java.lang.Long;
			      float     --> java.lang.Float;
			      double    --> java.lang.Double;
			      boolean   --> java.lang.Boolean;
			      
			      char      --> java.lang.Character;
			      int       --> java.lang.Integer
		*/
		
		String strFirstNum = args[0];
		
		String operator = args[1];  // java.lang.ArrayIndexOutOfBoundsException  数组下标越界
		
		String strSecondNum = args[2];
		
		//将字符串转换成数值类型
		double firstNum = Double.parseDouble(strFirstNum);   // java.lang.NumberFormatException  数字格式化异常.
		double secondNum = Double.parseDouble(strSecondNum);
		
		//判断是 + - x /
		
		double result = 0.0;
		
		if(operator.equals("+")){
			result = firstNum + secondNum;

		}else if(operator.equals("-")){
			result = firstNum - secondNum;

		}else if(operator.equals("x")){
			result = firstNum * secondNum;

		}else if(operator.equals("/")){
			result = firstNum / secondNum;

		}
		
		System.out.println(result);

		
	}
	
}
