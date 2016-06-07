package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._114_transient关键字的作用;

import java.io.*;

public class Login114 implements Serializable {

	private static final long serialVersionUID = 181569760561269743L;
	private           String username;
	private transient String password;

	public Login114( String username, String password ) {

		this.username = username;
		this.password = password;
	}

	public String getUsername() {

		return username;
	}

	public String getPassword() {

		return password;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "用户名：" + username + ", " );
		sb.append( "密码：" + password );
		return sb.toString();
	}

	@Override
	public Login114 clone() {

		Login114              login = null;
		ByteArrayOutputStream baos  = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream( baos );
			oos.writeObject( this );
			oos.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		ByteArrayInputStream bais = new ByteArrayInputStream( baos.toByteArray() );
		try {
			ObjectInputStream ois = new ObjectInputStream( bais );
			login = (Login114) ois.readObject();
			ois.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return login;
	}
}
