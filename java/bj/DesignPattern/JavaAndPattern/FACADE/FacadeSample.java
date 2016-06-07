package bj.DesignPattern.JavaAndPattern.FACADE;

public class FacadeSample {

	/**
	 * 测试
 	 * @param args
	 */
	static public void main( String args[] ) {

		Facade facade = new Facade();

		facade.ProcessTitle();
		facade.ProcessSubTitle();
		facade.ProcessItem();
		facade.ProcessItem();
		facade.ProcessItem();

	}

}

