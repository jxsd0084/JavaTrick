/* Generated by Together */

package bj.DesignPattern.JavaAndPattern.FACADE.sessionfacade;

import javax.ejb.EJBException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Business2 extends EJBObject {

	void BusinessMethod1() throws RemoteException, EJBException;

	void BusinessMethod2() throws RemoteException, EJBException;

	void BusinessMethod3() throws RemoteException, EJBException;

	/** @link dependency */
	/*#Business1Bean lnkSession1Bean;*/
}
