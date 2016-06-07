package bj.bigData.FlumeNG.ex01;

import org.junit.Test;

import java.util.List;

public class RedisTest {
	
	String host  = "192.168.3.243";
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
			boolean flag = testLogin( ip );
			System.out.println( i + " -- " + flag );
		}
	}

	private boolean testLogin( String ip ) {

		String value = jedis.get( ip );
		System.out.println( "value -> " + value );
		if ( value == null ) {
			jedis.set( ip, 1 + "" ); // 保存ip
			jedis.expire( ip, 60 ); // 设置60s之后失效
		} else {
			int parseInt = Integer.parseInt( value );
			if ( parseInt > 10 ) {
				System.out.println( "访问受限!!!" );
				return false;
			}
			jedis.incr( ip ); // 自增1
		}
		return true;
	}
	
	@Test
	public void test4() throws Exception {

		String value = jedis.get( "crxy" );
		System.out.println( "value -> " + value );
		int parseInt = Integer.parseInt( value );
		System.out.println( "休息一会 -> " + parseInt );
		Thread.sleep( 3000 );
		parseInt++;
		jedis.set( "crxy", parseInt + "" );
		System.out.println( "final -> " + jedis.get( "crxy" ) );
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

}
