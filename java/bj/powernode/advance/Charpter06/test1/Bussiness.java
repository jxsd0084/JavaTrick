package bj.powernode.advance.Charpter06.test1;

public class Bussiness {

	// fun1方法,参数:IDb db
	public void fun1( IDb db ) {

		// 在方法中调用方法,connect();execute();close();
		db.connect();
		db.execute();
		db.close();

	}

}
