package bj.mldn.javase02.ch10.no02;

class Info9<T> {

	private T var;        // 定义泛型变量

	public void setVar(T var) {

		this.var = var;
	}

	public T getVar() {

		return this.var;
	}

	public String toString() {    // 直接打印
		return this.var.toString();
	}
}

public class GenericsDemo21 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		Info9<String> i1 = new Info9<String>();        // 声明String的泛型对象
		Info9<Object> i2 = new Info9<Object>();        // 声明Object的泛型对象
		i1.setVar("hello");
		i2.setVar(new Object());
		fun(i1);
		fun(i2);
	}

	public static void fun(Info9<? super String> temp) {    // 只能接收String或Object类型的泛型
		System.out.print(temp + "、");
	}
}
