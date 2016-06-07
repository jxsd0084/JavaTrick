package bj.mldn.javase01.no83.Enum.demo03;

public class TestDemo05 {

	public static void main(String[] args) {

		Color c = Color.valueOf(Color.class, "RED");
		System.out.println(c.ordinal() + " --> " + c.name());
		System.out.println(Color.RED.ordinal() + " --> " + Color.RED.name());
	}

}
