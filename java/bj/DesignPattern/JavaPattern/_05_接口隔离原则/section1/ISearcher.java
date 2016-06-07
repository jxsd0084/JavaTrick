package bj.DesignPattern.JavaPattern._05_接口隔离原则.section1;

public interface ISearcher {

	// 接口是无法关联接口的, 因为关联接口的引用无法从实现类传递过来
//	public IPettyGirl pettyGirl = null;
//	public void getPrettyGirl(IPettyGirl _pettyGirl);

	// 搜索美女，列出美女信息
	public void show();

}
