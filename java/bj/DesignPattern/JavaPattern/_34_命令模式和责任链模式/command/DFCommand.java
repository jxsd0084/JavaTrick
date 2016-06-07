package bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.command;

import bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.CommandVO;
import bj.DesignPattern.JavaPattern._34_命令模式和责任链模式.command_name.df.AbstractDF;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class DFCommand extends Command {

	public String execute( CommandVO vo ) {
		return super.buildChain( AbstractDF.class ).get( 0 ).handleMessage( vo );
	}

}
