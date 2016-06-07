package bj.mldn.javase01.no69.persondemo;

public class Operate {

	public static void add() {

		InputData   input   = new InputData();
		String      name    = input.getString( "输入姓名：" );
		int         age     = input.getInt( "输入年龄：", "输入的不是数字，" );
		Person      per     = new Person( name, age );
		FileOperate operate = new FileOperate( "d:\\pers.ser" );
		try {
			operate.save( per );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void find() {

		FileOperate operate = new FileOperate( "d:\\pers.ser" );
		Person      per     = null;
		try {
			per = (Person) operate.load();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		if ( per != null ) {
			System.out.println( per );
		} else {
			System.out.println( "没有任何的数据。" );
		}
	}

	public static void update() {

		FileOperate operate = new FileOperate( "d:\\pers.ser" );
		Person      per     = null;
		try {
			per = (Person) operate.load();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		InputData input = new InputData();
		String    name  = input.getString( "输入姓名（原姓名：" + per.getName() + "）：" );
		int       age   = input.getInt( "输入年龄（原年龄：" + per.getAge() + "）：", "输入的不是数字，" );
		per = new Person( name, age );
		operate = new FileOperate( "d:\\pers.ser" );
		try {
			operate.save( per );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void delete() {

		FileOperate operate = new FileOperate( "d:\\pers.ser" );
		try {
			operate.save( null );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
