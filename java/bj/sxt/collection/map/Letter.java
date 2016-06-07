package bj.sxt.collection.map;

/**
 * javabean 存储数据 po bo vo  包含setter与getter访问器的类
 *
 * @author com.bj.com.bj
 */
public class Letter {

	private String name;  // 单词
	private int    count; // 次数

	// alt+/
	public Letter() {
	}

	public Letter( String name ) {
		this.name = name;
	}

	// alt + shif+s --> o
	public Letter( String name, int count ) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount( int count ) {
		this.count = count;
	}

	// setter与getter  访问器
	// alt + shift + s --> r --> tab --> enter --> shift + tab --> enter

}
