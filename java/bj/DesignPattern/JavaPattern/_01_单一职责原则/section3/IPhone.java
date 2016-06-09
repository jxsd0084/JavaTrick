package bj.DesignPattern.JavaPattern._01_单一职责原则.section3;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         电话的接口
 */
public interface IPhone {

	// 拨通电话
	public void dial( String phoneNumber );

	// 通话
	public void call( Object o );

	// 回应，只有自己说话而没有回应，那算啥？！
	public void answer( Object o );

	// 通话完毕，挂电话
	public void huangup();

}

/*



我不是有意要冒犯IPhone的，同名纯属巧合，我们来看一个这个过程的代码，如代码清
单1-2所示。

代码清单1-2 电话过程
public interface IPhone {
 //拨通电话
 public void dial(String phoneNumber);
 //通话
 public void chat(Object o);
 //通话完毕，挂电话 public void hangup();
}


实现类也比较简单，我就不再写了，大家看看这个接口有没有问题？我相信大部分的读
者都会说这个没有问题呀，以前我就是这么做的呀，某某书上也是这么写的呀，还有什么什
么的源码也是这么写的！是的，这个接口接近于完美，看清楚了，是“接近”！


单一职责原则
要求一个接口或类只有一个原因引起变化，也就是一个接口或类只有一个职责，它就负责一
件事情，看看上面的接口只负责一件事情吗？是只有一个原因引起变化吗？好像不是！


IPhone这个接口可不是只有一个职责，它包含了两个职责：一个是协议管理，一个是数
据传送。dial()和hangup()两个方法实现的是协议管理，分别负责拨号接通和挂机；chat()实现
的是数据的传送，把我们说的话转换成模拟信号或数字信号传递到对方，然后再把对方传递
过来的信号还原成我们听得懂的语言。


我们可以这样考虑这个问题，协议接通的变化会引起
这个接口或实现类的变化吗？会的！那数据传送（想想看，电话不仅仅可以通话，还可以上
网）的变化会引起这个接口或实现类的变化吗？会的！那就很简单了，这里有两个原因都引
起了类的变化。这两个职责会相互影响吗？电话拨号，我只要能接通就成，甭管是电信的还
是网通的协议；电话连接后还关心传递的是什么数据吗？通过这样的分析，我们发现类图上
的IPhone接口包含了两个职责，而且这两个职责的变化不相互影响，那就考虑拆分成两个接
口，


注意　单一职责原则提出了一个编写程序的标准，用“职责”或“变化原因”来衡量接口或
类设计得是否优良，但是“职责”和“变化原因”都是不可度量的，因项目而异，因环境而异。

 */
