package bj.mldn.javase01.no83.Enum.demo06;

public enum Color {
	RED {
		public String getColor() {

			return "红色";
		}
	},
	GREEN {
		public String getColor() {

			return "绿色";
		}
	},
	BLUE {
		public String getColor() {

			return "蓝色";
		}
	};

	public abstract String getColor(); // 定义抽象方法
}
