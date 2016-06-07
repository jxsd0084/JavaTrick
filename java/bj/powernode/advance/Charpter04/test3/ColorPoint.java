package bj.powernode.advance.Charpter04.test3;


// 合成/聚合代码复用原则

// 以后再考虑代码复用的使用,要首先合成/聚合代码复用原则,而不要使用继承关系
public class ColorPoint {

	private Point p = new Point();

	public void draw( int x, int y, int r ) {
		p.draw( x, y, r );
	}

	public void fill() {
		System.out.println( "ColorPoint在填充颜色" );
	}

}
