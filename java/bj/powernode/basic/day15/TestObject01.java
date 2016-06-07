package bj.powernode.basic.day15;

import java.io.*;


/*

	对象的输出流.

	将内存中的对象持久化到硬盘文件上. (持久化的过程)
	
	将临时态数据转换成持久态数据.
	
	持久化过程： 将对象的状态保留下来.
	
	被持久化的对象必须实现可序列化接口: java.io.Serializable

*/

public class TestObject01 {  // java.io.ObjectOutputStream;

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.创建ObjectOutputStream对象
		FileOutputStream   fos = new FileOutputStream( "D:/course/JavaProjects/day15/users.dll" );
		ObjectOutputStream oos = new ObjectOutputStream( fos );



		// 2.准备一个User对象
		User u = new User( "admin", "123" );



		// 3.持久化.
		oos.writeObject( u );


		oos.flush();

		oos.close();

	}

}


// java.io.Serializable 仅仅是一个标识接口.该接口中没有任何方法.

// JVM看到User是可以被序列化的，进行一些特殊的处理.
class User implements Serializable {

	// 添加序列化版本号.

	// 当User类型升级以后,为了防止反序列化出现异常，需要添加序列化版本号.
	private static final long serialVersionUID = 1234567891023451145L;

	// 属性
	private           String username;
	private transient String password;  // 被transient关键字修饰的属性,在对象持久化阶段不予理睬.


	// 构造方法
	public User() {

	}

	public User( String username, String password ) {

		this.username = username;
		this.password = password;
	}


	// setter and getter
	public void setUsername( String username ) {

		this.username = username;
	}

	public String getUsername() {

		return username;
	}

	public void setPassword( String password ) {

		this.password = password;
	}

	public String getPassword() {

		return password;
	}


}



