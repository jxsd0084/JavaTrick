package bj.jakeChen.Proxy.ex01;

/**
 * Created by chenlong on 2016/5/23.
 */
public class UserServiceBean implements UserService {

	private String name;

	public UserServiceBean() {
	}

	public UserServiceBean( String name ) {
		this.name = name;
	}


	@Override
	public void say() {
		System.out.println( "欢迎你来到此地..." );
		this.hello();
	}

	@Override
	public void hello() {
		System.out.println( "欢迎您!" );
	}

	public String getName() {
		return name;
	}

}
