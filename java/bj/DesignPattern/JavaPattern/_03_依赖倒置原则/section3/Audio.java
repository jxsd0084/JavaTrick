package bj.DesignPattern.JavaPattern._03_依赖倒置原则.section3;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Audio implements ICar {

	@Override
	public void run() {

		System.out.println( "Audio is running..." );
	}

}
