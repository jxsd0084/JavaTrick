package bj.powernode.advance.Charpter10.homework.test4;

public class Student {

	private String name;

	public Student() {

		super();
	}

	public Student( String name ) {

		super();
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	@Override
	public String toString() {

		return this.getName();
	}

	public void printName( Object o ) throws MustStringArgumentException {

		if ( o instanceof String ) {
			System.out.println( o );
		} else {
			MustStringArgumentException e = new MustStringArgumentException(
					"名字格式不合法" );
			throw e;
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Student s = new Student( "小强" );

		System.out.println( s );

		try {

			s.printName( new Object() );

		} catch ( MustStringArgumentException e ) {

			e.printStackTrace();

		}


		// try {
		// s.printName(24);
		// } catch (MustStringArgumentException e) {
		// e.printStackTrace();
		// }

	}

}
