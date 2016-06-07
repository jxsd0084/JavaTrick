package bj.bigData.HBase.ex03.query.service;

import com.boco.DataPlatform.hbase.common.Monitor;
import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.common.utils.HbaseConfigUtils;
import com.boco.DataPlatform.hbase.query.exception.ClientParameterException;
import com.boco.DataPlatform.hbase.query.service.common.CurrentPage;
import com.boco.DataPlatform.hbase.query.service.common.IdcTableInfos;
import com.boco.DataPlatform.hbase.query.service.common.SessionStore;
import com.boco.DataPlatform.hbase.query.service.common.SessionStore.Session;
import com.boco.DataPlatform.hbase.query.thrift.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseQuery implements
		com.boco.DataPlatform.hbase.query.thrift.QueryService.Iface {

	// 日志
	protected static final Logger             logger          = Logger.getLogger( QueryServer.class );
	// 获取配置参数
	protected static       Properties         pro             = HbaseConfigUtils.getConfigs();
	// 最大线程数
	private static final   int                max_pool_size   = Integer.parseInt( pro.getProperty( "server.threadpool.size" ) );
	// 配置zookeeper访问地址参数
	private static final   String             quorum          = pro.getProperty( "hbase.zookeeper.quorum" );
	private static final   String             clientPort      = pro.getProperty( "hbase.zookeeper.property.clientPort" );
	// 监视时隔
	private static final   int                monitor_inteval = Integer.parseInt( pro.getProperty( "server.monitor.inteval" ) );
	protected              ThreadPoolExecutor threadPool      = null; // 线程池
	// thrift监听端口
	private static final   int                listen_port     = Integer.parseInt( pro.getProperty( "server.listen.port" ) );
	
	protected final  TThreadPoolServer server;
	protected        SessionStore      sessionStore; // Session
	protected static HTablePool        pool; //
	protected        Configuration     conf; // hbase配置

	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public BaseQuery() throws TTransportException {

		Factory                protocolFactory = new Factory( true, true );
		TServerTransport       serverTransport = new TServerSocket( listen_port );
		QueryService.Processor processor       = new QueryService.Processor( this );
		server = new TThreadPoolServer( new Args( serverTransport ).processor(
				processor ).protocolFactory( protocolFactory ) );
		initialize();
	}

	// 配置HBase参数
	private void initialize() {

		threadPool = new ThreadPoolExecutor( max_pool_size, max_pool_size, 16,
				TimeUnit.SECONDS, new ArrayBlockingQueue< Runnable >( 16 ) );
		sessionStore = new SessionStore();
		conf = HBaseConfiguration.create();
		conf.set( "hbase.zookeeper.quorum", quorum );
		conf.set( "hbase.zookeeper.property.clientPort", clientPort );
		pool = new HTablePool( conf, 16 );
		
	}

	//启动监控程序
	protected void startMoniter() {

		new Monitor( monitor_inteval, conf ).start();
	}

	// 启动thrift服务
	protected void run() {

		logger.info( "Server started......" );
		server.serve();
	}

	//计数
	protected Result startCount( Session s, Runnable task ) {

		long before = System.currentTimeMillis();
		s.setRunnable( task );
		// 获取锁
		Object sLock = s.getLock();
		// 另起查询线程
		threadPool.execute( task );
		// 同步块
		synchronized ( sLock ) {
			try {
				sLock.wait( s.getTimeout() );
			} catch ( InterruptedException e ) {
				logger.info( "query success:" + e.getMessage() );
			}
		}
		long cost = System.currentTimeMillis() - before;
		if ( cost >= s.getTimeout() ) {
			return buildErrorResult( s.getSid() + "", -1, "timeOut" );
		}
		logger.info( "COST:" + cost + " ms" );
		if ( s.getErrorcode() != 0 ) {
			return new Result( String.format( "%d", s.getSid() ), s.getErrorcode(),
					s.getErrormsg(), null );
		} else {
			String sstr = String.format( "%d", s.getSid() );
			logger.info( "session:" + sstr + " size:" + s.getPage().getCountrs() );
			List< String >         mt = new ArrayList< String >();
			List< List< String > > rs = new ArrayList< List< String > >();
			Result result = new Result( String.format( "%d", s.getSid() ),
					s.getErrorcode(), s.getErrormsg(), new ResultData( ( int ) s.getPage().getCountrs(), mt, rs ) );
			return result;
		}
	}
	
	//查询
	protected Result startQuery( Session s, Runnable task ) {

		long before = System.currentTimeMillis();
		s.setRunnable( task );
		// 获取锁
		Object sLock = s.getLock();
		// 另起查询线程
		threadPool.execute( task );
		// 同步块
		synchronized ( sLock ) {
			try {
				sLock.wait( s.getTimeout() );
			} catch ( InterruptedException e ) {
				logger.info( "query success:" + e.getMessage() );
			}
		}
		long cost = System.currentTimeMillis() - before;
		if ( cost >= s.getTimeout() ) {
			return buildErrorResult( s.getSid() + "", -1, "timeOut" );
		}
		logger.info( "COST:" + cost + " ms" );
		return buildResult( s, s.getSid(), s.getPage() );
	}

	//创建结果
	protected Result buildResult( Session s, long sid, CurrentPage page ) {

		if ( s.getErrorcode() != 0 ) {
			return new Result( String.format( "%d", sid ), s.getErrorcode(),
					s.getErrormsg(), null );
		} else {
			if ( page.getRowCount() > 0 ) {
				String sstr = String.format( "%d", sid );
				logger.info( "session:" + sstr + " size:" + page.getRowCount() );
				Result result = new Result( String.format( "%d", sid ),
						s.getErrorcode(), s.getErrormsg(), new ResultData(
						page.getResultsize(), page.getMetadata(),
						page.getStringRows() ) );
				return result;
				
			} else {
				return new Result( String.format( "%d", sid ), 0,
						"No Result is here", null );
			}
		}
	}
	
	/**
	 * 检查输入参数的合法化
	 *
	 * @param condition
	 * @param tableName
	 * @throws ClientParameterException
	 */
	protected void checkInArgs( MainCondition condition, String tableName ) throws ClientParameterException {

		if ( condition == null ) {
			throw new ClientParameterException( TableConstants.ERROR_CODE_1, "condition can not null!" );
		}
		if ( condition.filters != null && condition.filters.size() > 0 ) {
			for ( Filter filter : condition.filters ) {
				IdcTableInfos.checkFilter( tableName, filter.getField() );
			}
		}
	}
	
	/**
	 * @param session
	 * @param errorCode
	 * @param errorMsg
	 * @return
	 */
	protected Result buildErrorResult( String session, int errorCode, String errorMsg ) {

		Result er = new Result();
		er.setSession( session );
		er.setErrorcode( errorCode );
		er.setErrormsg( errorMsg );
		return er;
	}
}
