package bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.command_name.df;

import bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.CommandVO;
import bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.command_name.os.DiskManager;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class DF extends AbstractDF {

	// 定义一下自己能处理什么参数
	protected String getOperateParam() {
		return super.DEFAULT_PARAM;
	}

	// 命令处理
	protected String echo( CommandVO vo ) {
		return DiskManager.df();
	}

}
