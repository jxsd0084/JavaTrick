package bj.DesignPattern.JavaPattern._37_规格模式.section2;

import bj.DesignPattern.JavaPattern._37_规格模式.section1.User;

import java.util.ArrayList;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public interface IUserProvider {

	// 根据条件查找用户
	public ArrayList< User > findUser( boolean condition );

}
