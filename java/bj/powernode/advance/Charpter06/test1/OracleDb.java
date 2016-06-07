package bj.powernode.advance.Charpter06.test1;

// OracleDb继承AbsDb,实现方法:connect();execute();
public class OracleDb extends AbsDb {

	public void connect() {

		System.out.println( "连接Oracle数据库" );
	}

	public void execute() {

		System.out.println( "执行Oracle数据库操作" );
	}

}
