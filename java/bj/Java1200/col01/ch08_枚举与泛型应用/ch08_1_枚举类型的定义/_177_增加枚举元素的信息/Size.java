package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._177_增加枚举元素的信息;

public enum Size {
	SMALL( "我是小号匹萨" ), MEDIUM( "我是中号匹萨" ), LARGE( "我是大号匹萨" );
	private String description;

	private Size( String description ) {

		this.description = description;
	}

	public String getDescription() {

		return description;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		for ( Size size : Size.values() ) {

			System.out.println( size + ":" + size.getDescription() );
		}

	}

}
