package bj.mldn.javase02.ch14.no04;

interface Print2 {

	public String getColor();
}

enum Color2 implements Print2 {
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
	}
}

public class InterfaceEnumDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		for ( Color2 c : Color2.values() ) {
			System.out.print( c.getColor() + "、" );
		}
	}
}
