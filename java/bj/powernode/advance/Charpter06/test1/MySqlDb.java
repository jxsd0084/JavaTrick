package bj.powernode.advance.Charpter06.test1;

// MySqlDb继承AbsDb,实现方法:connect();execute();
public class MySqlDb extends AbsDb {

	public void connect() {

		System.out.println( "连接MySql数据库" );
	}

	public void execute() {

		System.out.println( "执行MySql数据库操作" );
	}

}
