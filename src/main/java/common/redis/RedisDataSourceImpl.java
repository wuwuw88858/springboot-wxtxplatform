package common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @program: Wxplatform
 * @description: 实现类
 * @author: zhijie
 * @create: 2019-02-20 20:45
 **/
@Repository("redisDataSource")  //用于标注数据访问组件,即DAO组件
public class RedisDataSourceImpl implements RedisDataSource {
    private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    /*
       * @Description:与redis服务端获取连接
       * @Param: []
       * @return: redis.clients.jedis.ShardedJedis
       * @Author:  zhijie
       * @Date: 2019/2/20
       */
    @Override
    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardedJedis = shardedJedisPool.getResource();
            return shardedJedis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * @Description:关闭连接池
    * @Param: [shardedJedis]
    * @return: void
    * @Author:  zhijie
    * @Date: 2019/2/20
    */
    @Override
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.close();
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis, boolean borken) {
        if (borken) {
            shardedJedisPool.close();
        } else {
            shardedJedis.close();
        }
    }
}
