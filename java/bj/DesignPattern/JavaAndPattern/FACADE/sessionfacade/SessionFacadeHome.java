/* Generated by Together */

package bj.DesignPattern.JavaAndPattern.FACADE.sessionfacade;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

public interface SessionFacadeHome extends EJBHome {

	SessionFacade create() throws CreateException, EJBException, RemoteException;

	/** @link dependency */
	/*#SessionFacadeBean lnkSession1Bean;*/
}
