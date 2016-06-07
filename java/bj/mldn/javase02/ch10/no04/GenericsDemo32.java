package bj.mldn.javase02.ch10.no04;

interface Info1 {                    // 只有此接口的子类才是表示人的信息

}

class Contact1 implements Info1 {    // 表示联系方式

	private String address;          // 联系地址
	private String telphone;         // 联系方式
	private String zipcode;          // 邮政编码

	public Contact1( String address, String telphone, String zipcode ) {

		this.setAddress( address );
		this.setTelphone( telphone );
		this.setZipcode( zipcode );
	}

	public void setAddress( String address ) {

		this.address = address;
	}

	public void setTelphone( String telphone ) {

		this.telphone = telphone;
	}

	public void setZipcode( String zipcode ) {

		this.zipcode = zipcode;
	}

	public String getAddress() {

		return this.address;
	}

	public String getTelphone() {

		return this.telphone;
	}

	public String getZipcode() {

		return this.zipcode;
	}

	public String toString() {

		return "联系方式：" + "\n" +
		       "\t|- 联系电话：" + this.telphone + "\n" +
		       "\t|- 联系地址：" + this.address + "\n" +
		       "\t|- 邮政编码：" + this.zipcode;
	}
};

class Introduction1 implements Info1 {

	private String name;        // 姓名
	private String sex;         // 性别
	private int    age;         // 年龄

	public Introduction1( String name, String sex, int age ) {

		this.setName( name );
		this.setSex( sex );
		this.setAge( age );
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setSex( String sex ) {

		this.sex = sex;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public String getSex() {

		return this.sex;
	}

	public int getAge() {

		return this.age;
	}

	public String toString() {

		return "基本信息：" + "\n" +
		       "\t|- 姓名：" + this.name + "\n" +
		       "\t|- 性别：" + this.sex + "\n" +
		       "\t|- 年龄：" + this.age;
	}
}

class Person1 < T extends Info1 > {

	private T info;

	public Person1( T info ) {        // 通过构造方法设置信息属性内容
		this.setInfo( info );
	}

	public void setInfo( T info ) {

		this.info = info;
	}

	public T getInfo() {

		return this.info;
	}

	public String toString() {        // 覆写Object类中的toString()方法
		return this.info.toString();
	}
}

public class GenericsDemo32 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person1< Contact1 > per = null;        // 声明Person对象
		per = new Person1< Contact1 >( new Contact1( "北京市", "01051283346", "100088" ) );
		System.out.println( per );
	}
}
