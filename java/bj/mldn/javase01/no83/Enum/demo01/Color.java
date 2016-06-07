package bj.mldn.javase01.no83.Enum.demo01;

public class Color {

	private String name;
	private static final Color RED   = new Color("红色");
	private static final Color GREEN = new Color("绿色");
	private static final Color BLUE  = new Color("蓝色");

	private Color(String name) {

		this.name = name;
	}

	public static Color getInstance(int num) {

		if (num == 0) {
			return RED;
		}
		if (num == 1) {
			return GREEN;
		}
		if (num == 2) {
			return BLUE;
		}
		return null;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

}
