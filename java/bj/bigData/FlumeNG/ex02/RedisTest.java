package bj.bigData.FlumeNG.ex02;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedisTest {

	String host  = "192.168.1.170";
	int    port  = 6379;
	Jedis  jedis = new Jedis( host, port );

	@Test
	public void test1() throws Exception {

		String value = jedis.get( "crxy" );
		jedis.set( "crxy", "www.crxy.cn" );
	}

	@Test
	public void test2() throws Exception {

		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal( 100 );
		poolConfig.setMaxIdle( 10 );
		poolConfig.setMaxWaitMillis( 1000 );
		poolConfig.setTestOnBorrow( true );
		JedisPool jedisPool = new JedisPool( poolConfig, host, port );
		Jedis     jedis     = jedisPool.getResource();
		String    value     = jedis.get( "crxy" );
		System.out.println( value );
		jedisPool.returnResourceObject( jedis );
	}

	/**
	 * 限制网站访客的访问频率
	 *
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {

		String ip = "127.0.0.1";
		for ( int i = 0; i < 20; i++ ) {
			boolean falg = testLogin( ip );
			System.out.println( i + "--" + falg );
		}
	}

	private boolean testLogin( String ip ) {

		String value = jedis.get( ip );
		if ( value == null ) {
			jedis.set( ip, 1 + "" );
			jedis.expire( ip, 60 );
		} else {
			int parseInt = Integer.parseInt( value );
			if ( parseInt > 10 ) {
				System.out.println( "访问受限!!!" );
				return false;
			}
			jedis.incr( ip );
		}
		return true;
	}

	@Test
	public void test4() throws Exception {

		String value    = jedis.get( "crxy" );
		int    parseInt = Integer.parseInt( value );
		System.out.println( "休息一会" );
		Thread.sleep( 3000 );
		parseInt++;
		jedis.set( "crxy", parseInt + "" );
	}

	@Test
	public void test5() throws Exception {

		jedis.watch( "crxy" );
		String value    = jedis.get( "crxy" );
		int    parseInt = Integer.parseInt( value );
		parseInt++;
		System.out.println( "休息一会！！" );
		Thread.sleep( 3000 );

		Transaction multi = jedis.multi();
		multi.set( "crxy", parseInt + "" );
		List< Object > exec = multi.exec();
		if ( exec == null ) {
			System.out.println( "值被修改了" );
			test5();
		} else {
			System.out.println( "正常执行了。、" );
		}

	}

	@Test
	public void test6() throws Exception {

		long starttime = System.currentTimeMillis();
		for ( int i = 0; i < 10000; i++ ) {
			jedis.set( "a" + i, i + "" );
		}
		System.out.println( System.currentTimeMillis() - starttime );
	}

	@Test
	public void test7() throws Exception {

		long     starttime = System.currentTimeMillis();
		Pipeline pipelined = jedis.pipelined();
		for ( int i = 0; i < 10000; i++ ) {
			pipelined.set( "b" + i, i + "" );
		}
		pipelined.sync();
		System.out.println( System.currentTimeMillis() - starttime );
	}

	/**
	 * 通过sentinel获取jedis链接
	 *
	 * @throws Exception
	 */
	@Test
	public void test8() throws Exception {

		Set< String > sentinels = new HashSet< String >();
		sentinels.add( "192.168.1.172:26379" );
		sentinels.add( "192.168.1.173:26379" );
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// TODO---
		JedisSentinelPool jedisSentinelPool = new JedisSentinelPool( "mymaster", sentinels, poolConfig );
		HostAndPort       currentHostMaster = jedisSentinelPool.getCurrentHostMaster();
		System.err.println( currentHostMaster.getHost() + "--" + currentHostMaster.getPort() );
		Jedis jedis = jedisSentinelPool.getResource();

		jedis.set( "crxy", "www.crxy.cn" );

		String value = jedis.get( "crxy" );
		System.out.println( value );

		jedisSentinelPool.returnResourceObject( jedis );

	}

	@Test
	public void test9() throws Exception {

		Set< HostAndPort > nodes = new HashSet< HostAndPort >();
		nodes.add( new HostAndPort( "192.168.1.170", 7000 ) );
		nodes.add( new HostAndPort( "192.168.1.170", 7001 ) );
		nodes.add( new HostAndPort( "192.168.1.170", 7002 ) );
		nodes.add( new HostAndPort( "192.168.1.170", 7003 ) );
		nodes.add( new HostAndPort( "192.168.1.170", 7004 ) );
		nodes.add( new HostAndPort( "192.168.1.170", 7005 ) );

		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// TODO--
		JedisCluster jedisCluster = new JedisCluster( nodes, poolConfig );
		String       value        = jedisCluster.get( "crxy" );
		System.out.println( value );
		
	}

}
