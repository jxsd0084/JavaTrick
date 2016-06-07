package bj.bigData.HBase.ex03.query.service.common;

import org.apache.log4j.Logger;

import java.util.Hashtable;

/**
 * 
 * @author ranhualin
 * @date 2013-1-5
 */
public class SessionStore {
	private Hashtable<Long, Session> sessions = null;
	private static final Logger logger = Logger.getLogger(SessionStore.class);
	private int defaultSessionCapacity = 100;

	public SessionStore() {
		sessions = new Hashtable<Long, Session>(defaultSessionCapacity); // default
	}

	public Session addSession(long sid, CurrentPage page, int timeout) {
		Session s = new Session(sid, page, timeout);
		sessions.put(sid, s);
		return s;
	}

	public void delSession(long sid) {
		logger.info("delete session:"+sid);
		synchronized (sessions) {
			Session s = sessions.remove(sid);
			s.getPage().clear();
			s=null;
		}
	}
	public Session getSession(long sid) {
		return sessions.get(sid);
	}

	public CurrentPage getPage(long sid) {
		Session s = sessions.get(sid);
		if (s != null) {
			return s.getPage();
		}
		return null;
	}
	public void destroyAll() {

	}
	public class Session {		
		private CurrentPage page = null;
		private int timeout = 0;// 查询超时时间
		private Object sessionLock = null;
		protected int errorcode;
		protected String errormsg;
		private Runnable task = null;
		private long sid;

		public Session(long sid, CurrentPage page, int timeout) {
			this.page = page;
			this.timeout = timeout;
			this.sid = sid;
			sessionLock = new Object();
		}
		public CurrentPage getPage() {
			return page;
		}
		public void setRunnable(Runnable task) {
			this.task = task;
		}
		public Object getLock() {
			return sessionLock;
		}
		public Runnable getTask() {
			return task;
		}
		public int getTimeout() {
			return timeout;
		}

		public void notifyMe() {
			logger.info("NotifyAll......");
			synchronized (sessionLock) {
				sessionLock.notifyAll();
			}
		}
		public int getErrorcode() {
			return errorcode;
		}

		public void setErrorcode(int errorcode) {
			this.errorcode = errorcode;
		}

		public String getErrormsg() {
			return errormsg;
		}

		public void setErrormsg(String errormsg) {
			this.errormsg = errormsg;
		}
		public long getSid() {
			return sid;
		}
		public void setSid(long sid) {
			this.sid = sid;
		}
	}

	public static void main(String[] args) {
	}
}
