package bj.powernode.basic.day24.EMS.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 抽象项目中的javabean,实体类(管理员实体类)
 * 包含两个属性:
 * username
 * password
 *
 * @author Administrator
 */
public class Administrator implements Serializable {

	private static final long serialVersionUID = - 6740958520367544258L; //在反序列化的时候用

	private String username;
	private String password;

	public String getUsername() {

		return username;
	}

	public void setUsername( String username ) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword( String password ) {

		this.password = password;
	}

	public Administrator() {

		super();
	}

	public Administrator( String username, String password ) {

		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * 管理员具有登录行为
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功后返回true, 否之返回false
	 */
	public boolean login() {

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream( new FileInputStream( "c:/emsdb/admin.dll" ) );
			Object obj = ois.readObject();
			if ( obj instanceof Administrator ) {
				Administrator admin = (Administrator) obj;
				if ( this.getUsername().equals( admin.getUsername() ) && this.getPassword().equals( admin.getPassword() ) ) {
					return true;
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if ( ois != null ) {
				try {
					ois.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {

		final int prime  = 31;
		int       result = 1;
		result = prime * result
		         + ( ( username == null ) ? 0 : username.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( getClass() != obj.getClass() ) {
			return false;
		}
		Administrator other = (Administrator) obj;
		if ( username == null ) {
			if ( other.username != null ) {
				return false;
			}
		} else if ( ! username.equals( other.username ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "Administrator [username=" + username + "]";
	}

}
