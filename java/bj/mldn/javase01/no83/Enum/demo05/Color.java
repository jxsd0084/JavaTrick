package bj.mldn.javase01.no83.Enum.demo05;

public enum Color implements ColorInfo {
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
}
