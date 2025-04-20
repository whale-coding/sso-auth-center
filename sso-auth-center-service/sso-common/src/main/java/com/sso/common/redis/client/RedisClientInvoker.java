package com.sso.common.redis.client;

import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * redis client 工具
 *
 * @author 聂建强
 */
public interface RedisClientInvoker<T> {

	/**
	 * invoke
	 *
	 * @param jedis
	 * @return
	 * @throws IOException
	 */
	T invoke(Jedis jedis) throws IOException;
}
