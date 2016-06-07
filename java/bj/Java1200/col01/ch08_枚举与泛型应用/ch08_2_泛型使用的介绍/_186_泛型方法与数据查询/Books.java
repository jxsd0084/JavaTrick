package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._186_泛型方法与数据查询;

public class Books {

	private int    id;
	private String name;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	@Override
	public String toString() {

		return id + "：" + name;
	}
}
