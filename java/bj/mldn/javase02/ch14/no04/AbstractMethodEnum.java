package bj.mldn.javase02.ch14.no04;

enum Color implements Print2 {
	RED {
		public String getColor() {

			return "红色";
		}
	}, GREEN {
		public String getColor() {

			return "绿色";
		}
	}, BLUE {
		public String getColor() {

			return "蓝色";
		}
	};

	public abstract String getColor();
}

public class AbstractMethodEnum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		for ( Color c : Color.values() ) {
			System.out.print( c.getColor() + "、" );
		}
	}
}
