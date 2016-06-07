package bj.mldn.javase01.no77.IOExec.demo;

public class Operate {

	private Student   stu[] = null;
	private InputData input = null;

	public Operate( Student stu[] ) {

		this.stu = stu; // 对象数组的内容由外部决定
		this.input = new InputData();
	}

	public void list() {

		for ( int i = 0; i < this.stu.length; i++ ) {
			System.out.println( this.stu[ i ].getStuno() + "："
			                    + this.stu[ i ].getName() + "【" + this.stu[ i ].getCount()
			                    + "票】" );
		}
	}

	public boolean vote() { // 完成具体的投票功能
		boolean flag = true;
		int stuno = this.input.getInt( "请输入班长候选人代号（数字0结束）：",
		                               "此选票无效，请输入正确的候选人代号！" );
		switch ( stuno ) {
			case 1: {
				this.stu[ 0 ].setCount( this.stu[ 0 ].getCount() + 1 );// 修改选票
				break;
			}
			case 2: {
				this.stu[ 1 ].setCount( this.stu[ 1 ].getCount() + 1 );// 修改选票
				break;
			}
			case 3: {
				this.stu[ 2 ].setCount( this.stu[ 2 ].getCount() + 1 );// 修改选票
				break;
			}
			case 4: {
				this.stu[ 3 ].setCount( this.stu[ 3 ].getCount() + 1 );// 修改选票
				break;
			}
			case 0: {
				flag = false;
				break;
			}
			default: {
				System.out.println( "此选票无效，请输入正确的候选人代号！" );
			}
		}
		return flag;
	}

	public void result() {

		java.util.Arrays.sort( this.stu );// 排序
		System.out.println( "投票最终结果：" + this.stu[ 0 ].getName() + "同学，最后以"
		                    + this.stu[ 0 ].getCount() + "票当选班长！" );
	}
}
