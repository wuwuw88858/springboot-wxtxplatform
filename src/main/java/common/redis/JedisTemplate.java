package common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: Wxplatform
 * @description: jedis具体类
 * @author: zhijie
 * @create: 2019-02-20 20:50
 **/
@Repository("JedisTmeplate")
public class JedisTemplate {
    private static final Logger log = LoggerFactory.getLogger(JedisTemplate.class);

    //@Autowried 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    @Autowired
    private RedisDataSource redisDataSource;

    public void disConnect() {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.disconnect();
    }

    /*
      * @Description:相当于命令：set
      * @Param: [key, value]
      * @return: java.lang.String
      * @Author:  zhijie
      * @Date: 2019/2/20
      */
    public String set(String key, String value) {
        String result = null;

        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }
    /*
       * @Description:  相当于命令hmset
       * @Param: [key]
       * @return: java.lang.String
       * @Author:  zhijie
       * @Date: 2019/2/20
       */

    public String hmset(String key, Map<String, String> hashMap) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hmset(key, hashMap);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public List<String> hmget(String key, String... fields) {
        List<String> result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hmget(key, fields);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Long hset(String key, String field, String val) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hset(key, field, val);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;

    }

    public String hget(String key, String field) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hget(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hgetAll(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }


    /*
      * @Description: set类型集合添加，相当于命令sadd
      * @Param: [key, members]
      * @return: java.lang.Long
      * @Author:  zhijie
      * @Date: 2019/2/22
      */
    public Long sadd(String key, String... members) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sadd(key, members);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;

    }


    public Set<String> smembers(String key) {
        Set<String> result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.smembers(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Set<String> hkeys(String key) {
        Set<String> result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hkeys(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public List<String> hvals(String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hvals(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Long del(String key) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        boolean broken = false;
        try {
            result = shardedJedis.del(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;

    }

    public Long hdel(String key, String... field) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hdel(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;

    }

    public Long hlen(String key) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hlen(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;

    }

    public Boolean hexists(String key, String field) {
        boolean result = false;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hexists(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Long expire(String key, int seconds) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expire(key, seconds);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }


    public Long zadd(String key, double score, String member) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zadd(key, score, member);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zadd(key, scoreMembers);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Set<String> zrange(String key, long start, long stop) {
        Set<String> result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrange( key,  start,  stop);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }


    public Long zcard(String key) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zcard(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }


    public Long srem(String key, String... members) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.srem(key, members);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    public Long zremrangeByRank(String key, long start, long stop) {
        Long result = 0L;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zremrangeByRank( key,  start,  stop);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }


}
