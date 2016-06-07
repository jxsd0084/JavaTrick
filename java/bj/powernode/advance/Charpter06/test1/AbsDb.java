package bj.powernode.advance.Charpter06.test1;

// 抽象类AbsDb实现IDb接口
public abstract class AbsDb implements IDb {

	// 普通方法close();
	@Override
	public void close() {

		System.out.println( "关闭数据库连接" );
	}

}
