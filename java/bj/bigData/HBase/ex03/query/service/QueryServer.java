package bj.bigData.HBase.ex03.query.service;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.query.exception.ClientParameterException;
import com.boco.DataPlatform.hbase.query.service.common.CurrentPage;
import com.boco.DataPlatform.hbase.query.service.common.IdcTableInfos;
import com.boco.DataPlatform.hbase.query.service.common.SessionStore.Session;
import com.boco.DataPlatform.hbase.query.service.common.TCommonCondition;
import com.boco.DataPlatform.hbase.query.service.scan.*;
import com.boco.DataPlatform.hbase.query.thrift.CommonCondition;
import com.boco.DataPlatform.hbase.query.thrift.CountCondition;
import com.boco.DataPlatform.hbase.query.thrift.MainCondition;
import com.boco.DataPlatform.hbase.query.thrift.Result;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

import java.util.Calendar;

/**
 * thrift服务端入口
 *
 * @author ranhualin
 * @date 2013-7-18
 */
public class QueryServer extends BaseQuery {

	public QueryServer() throws TTransportException {

		super();
	}

	public static void main( String[] args ) {
		//初始化IDC Table信息
		IdcTableInfos.initTableInfo();
		try {
			QueryServer server = new QueryServer();
			server.startMoniter();
			server.run();
		} catch ( TTransportException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * 统计表的数据量
	 */
	@Override
	public Result count( CountCondition condition ) throws TException {

		long        sid  = Calendar.getInstance().getTimeInMillis();
		CurrentPage page = new CurrentPage( 1, 100 );
		// 添加Session对象
		Session  s    = sessionStore.addSession( sid, page, condition.getTimeout() );
		Runnable task = new CountScanner( s, condition.getTable(), pool, conf );
		Result   rs   = super.startCount( s, task );
		return rs;
	}

	/**
	 * 访问日志查询
	 */
	@Override
	public Result queryAccessLog( CommonCondition commonCondition,
	                              MainCondition mainCondition ) throws TException {
		// 检查输入参数的合法性
		try {
			super.checkInArgs( mainCondition, TableConstants.TO_NET_ODS_ACCESSLOGS );
		} catch ( ClientParameterException e ) {
			logger.info( "error in args:" + e.getErrorCode() + ":"
			             + e.getMessage() );
			return super.buildErrorResult( System.currentTimeMillis() + "", e.getErrorCode(), e.getMessage() );
		}
		String           baseTable = pro.getProperty( "table.accesslogs.name" );
		long             sid       = Calendar.getInstance().getTimeInMillis();
		TCommonCondition tcc       = new TCommonCondition( commonCondition );
		logger.info( "call in query pageNo:" + tcc.getPageNo() + ",pageSize:"
		             + tcc.getPageSize() );
		CurrentPage page = new CurrentPage( tcc.getPageNo(), tcc.getPageSize() );
		// 添加Session对象
		Session s = sessionStore.addSession( sid, page, tcc.getTimeout() );
		//Session s = sessionStore.addSession(sid, page, 500*1000);
		// 查询任务
		Runnable task = new AccessLogScanner( s, tcc, mainCondition, baseTable,
				pool, conf );
		Result rs = super.startQuery( s, task );
		return rs;
	}
	
	/**
	 * 监测日志查询
	 */
	@Override
	public Result queryMonitorLog( CommonCondition commonCondition,
	                               MainCondition mainCondition ) throws TException {
		// 检查输入参数的合法性
		try {
			super.checkInArgs( mainCondition, TableConstants.TO_NET_ODS_MONITORLOGS );
		} catch ( ClientParameterException e ) {
			logger.info( "error in args:" + e.getErrorCode() + ":"
			             + e.getMessage() );
			return super.buildErrorResult( System.currentTimeMillis() + "", e.getErrorCode(), e.getMessage() );
		}
		String           baseTable = pro.getProperty( "table.monitorlogs.name" );
		long             sid       = Calendar.getInstance().getTimeInMillis();
		TCommonCondition tcc       = new TCommonCondition( commonCondition );
		logger.info( "call in query pageNo:" + tcc.getPageNo() + ",pageSize:"
		             + tcc.getPageSize() );
		CurrentPage page = new CurrentPage( tcc.getPageNo(), tcc.getPageSize() );
		// 添加Session 对象
		Session s = sessionStore.addSession( sid, page, tcc.getTimeout() );
		// 查询任务
		Runnable task = new MonitorLogScanner( s, tcc, mainCondition, baseTable, pool, conf );
		Result   rs   = super.startQuery( s, task );
		page = null;
		return rs;
	}
	
	/**
	 * 过滤日志查询
	 */
	@Override
	public Result queryFilterLog( CommonCondition commonCondition,
	                              MainCondition mainCondition ) throws TException {
		// 检查输入参数的合法性
		try {
			super.checkInArgs( mainCondition, TableConstants.TO_NET_ODS_FILTERLOGS );
		} catch ( ClientParameterException e ) {
			logger.info( "error in args:" + e.getErrorCode() + ":"
			             + e.getMessage() );
			return super.buildErrorResult( System.currentTimeMillis() + "", e.getErrorCode(), e.getMessage() );
		}
		String           baseTable = pro.getProperty( "table.filterlogs.name" );
		long             sid       = Calendar.getInstance().getTimeInMillis();
		TCommonCondition tcc       = new TCommonCondition( commonCondition );
		logger.info( "call in query pageNo:" + tcc.getPageNo() + ",pageSize:"
		             + tcc.getPageSize() );
		CurrentPage page = new CurrentPage( tcc.getPageNo(), tcc.getPageSize() );
		//添加Session 对象
		Session s = sessionStore.addSession( sid, page, tcc.getTimeout() );
		//查询任务
		Runnable task = new FilterLogScanner( s, tcc, mainCondition, baseTable, pool, conf );
		Result   rs   = super.startQuery( s, task );
		page = null;
		return rs;
	}
	
	/**
	 * 异常IP监测  查询
	 */
	@Override
	public Result queryMonitorIpInfo( CommonCondition commonCondition,
	                                  MainCondition mainCondition ) throws TException {
		// 检查输入参数的合法性
		try {
			super.checkInArgs( mainCondition, TableConstants.TO_NET_ODS_MONITOR_IPINFO );
		} catch ( ClientParameterException e ) {
			logger.info( "error in args:" + e.getErrorCode() + ":"
			             + e.getMessage() );
			return super.buildErrorResult( System.currentTimeMillis() + "", e.getErrorCode(), e.getMessage() );
		}
		String           baseTable = pro.getProperty( "table.monitoripinfo.name" );
		long             sid       = Calendar.getInstance().getTimeInMillis();
		TCommonCondition tcc       = new TCommonCondition( commonCondition );
		logger.info( "call in query pageNo:" + tcc.getPageNo() + ",pageSize:"
		             + tcc.getPageSize() );
		CurrentPage page = new CurrentPage( tcc.getPageNo(), tcc.getPageSize() );
		// 添加Session 对象
		Session s = sessionStore.addSession( sid, page, tcc.getTimeout() );
		//查询任务
		Runnable task = new MonitorIpInfoScanner( s, tcc, mainCondition, baseTable, pool, conf );
		Result   rs   = super.startQuery( s, task );
		page = null;
		return rs;
	}
	
	/**
	 * 违法违规网站查询
	 */
	@Override
	public Result queryIllegalInfo( CommonCondition commonCondition,
	                                MainCondition mainCondition ) throws TException {
		// 检查输入参数的合法性
		try {
			super.checkInArgs( mainCondition, TableConstants.TO_NET_ODS_ILLEGALINFO );
		} catch ( ClientParameterException e ) {
			logger.info( "error in args:" + e.getErrorCode() + ":"
			             + e.getMessage() );
			return super.buildErrorResult( System.currentTimeMillis() + "", e.getErrorCode(), e.getMessage() );
		}
		String           baseTable = pro.getProperty( "table.illegalinfo.name" );
		long             sid       = Calendar.getInstance().getTimeInMillis();
		TCommonCondition tcc       = new TCommonCondition( commonCondition );
		logger.info( "call in query pageNo:" + tcc.getPageNo() + ",pageSize:"
		             + tcc.getPageSize() );
		CurrentPage page = new CurrentPage( tcc.getPageNo(), tcc.getPageSize() );
		// 添加Session 对象
		Session s = sessionStore.addSession( sid, page, tcc.getTimeout() );
		//查询任务
		Runnable task = new IllegalInfoScanner( s, tcc, mainCondition, baseTable, pool, conf );
		Result   rs   = super.startQuery( s, task );
		return rs;
	}
}
