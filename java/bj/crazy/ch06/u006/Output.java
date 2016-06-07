
package bj.crazy.ch06.u006;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public interface Output {

	// 接口里定义的属性只能是常量
	int MAX_CACHE_LINE = 50;

	// 接口里定义的只能是public的抽象实例方法
	void out();

	void getData( String msg );
}
