package bj.bigData.Redis.ex01;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
	
	private static JedisPool jedisPool = null;
	
	/**
	 * 获取一个链接
	 *
	 * @return
	 */
	public static synchronized Jedis getJedis() {

		if ( jedisPool == null ) {
			JedisPoolConfig poolConfig = new JedisPoolConfig();
			poolConfig.setMaxTotal( 100 );
			poolConfig.setMaxIdle( 10 );
			poolConfig.setMaxWaitMillis( 1000 );
			poolConfig.setTestOnBorrow( true );
			jedisPool = new JedisPool( poolConfig, "192.168.3.243", 6379 );
		}
		Jedis jedis = jedisPool.getResource();
		return jedis;
	}
	
	/**
	 * 返回一个链接
	 *
	 * @param jedis
	 */
	public static void returnJedis( Jedis jedis ) {

		jedisPool.returnResourceObject( jedis );
	}
	
	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Jedis jedis = RedisUtils.getJedis();
		System.out.println( "jedis -> " + jedis );
	}
	
}
