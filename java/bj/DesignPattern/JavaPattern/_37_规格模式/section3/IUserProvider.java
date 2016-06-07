package bj.DesignPattern.JavaPattern._37_规格模式.section3;

import java.util.ArrayList;


/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public interface IUserProvider {

	// 根据条件查找用户
	public ArrayList< User > findUser( IUserSpecification userSpec );

}
