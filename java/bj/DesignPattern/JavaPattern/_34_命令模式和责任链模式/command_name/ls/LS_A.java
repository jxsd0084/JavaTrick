package bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.command_name.ls;

import bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.CommandVO;
import bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.command_name.os.FileManager;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class LS_A extends AbstractLS {

	// ls -a命令
	protected String echo( CommandVO vo ) {
		return FileManager.ls_a( vo.formatData() );
	}

	protected String getOperateParam() {
		return super.A_PARAM;
	}

}
