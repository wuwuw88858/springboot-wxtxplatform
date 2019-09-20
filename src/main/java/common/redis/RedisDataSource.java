package common.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * @program: Wxplatform
 * @description: 操作SharedJedis
 * @author: zhijie
 * @create: 2019-02-20 20:43
 **/
public interface RedisDataSource {

    public abstract ShardedJedis getRedisClient(); //连接

    public void returnResource(ShardedJedis shardedJedis);

    public void returnResource(ShardedJedis shardedJedis, boolean borken);

}
