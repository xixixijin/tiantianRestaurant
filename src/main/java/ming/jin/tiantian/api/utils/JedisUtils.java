package ming.jin.tiantian.api.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @author Haokun
 * @date 2020/2/15 21:33
 * <p>
 * tiantianRestaurant
 */
@Component
@Slf4j
public class JedisUtils {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 将连接返还到连接池
     *
     * @param jedisPool
     * @param jedis
     */
    public static void returnPool(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 通过key获取存储在redis中的value并释放连接
     *
     * @param key     key
     * @return 成功返回value 失败返回null
     */
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnPool(jedisPool, jedis);
        }
        return value;
    }

    /**
     * 通过key获取存储在redis中的value并释放连接
     *
     * @param key     key
     * @return 成功返回value 失败返回null
     */
    public byte[] get(byte[] key ) {
        Jedis jedis = null;
        byte[] value = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnPool(jedisPool, jedis);
        }
        return value;
    }

    /**
     * 向redis中存入key和value并释放连接资源
     * 如果key存在 则覆盖
     *
     * @param key
     * @param value
     * @return 成功返回ok 失败返回0
     */
    public String set(String key, String value ) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error("redis添加失败");
            return "0";
        } finally {
            returnPool(jedisPool, jedis);
        }
    }

    /**
     * 向redis中存入key和value并释放连接资源
     * 如果key存在 则覆盖
     *
     * @param key
     * @param value
     * @return 成功返回ok 失败返回0
     */
    public String set(byte[] key, byte[] value ) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error("redis添加失败");
            return "0";
        } finally {
            returnPool(jedisPool, jedis);
        }
    }

    /**
     * 新增key 并设置key的生存时间
     * @param key
     * @param seconds
     *          生存时间（秒）
     * @param value
     * @return 设置成功时返回 OK
     */
    public String setex(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.setex(key, seconds, value);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnPool(jedisPool, jedis);
        }
        return null;
    }

    /**
     *  新增key，value 如果key存在则返回0，nx为not exist
     * @param key
     * @param value
     * @return 成功返回1 存在和异常返回0
     */
    public Long setnx(String key,String value){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            return jedis.setnx(key,value);
        }catch (Exception e){
            log.error(e.getMessage());
            return 0L;
        }finally {
            returnPool(jedisPool,jedis);
        }
    }


    /**
     * 删除指定的key，也可与传入一个包含key的数组
     *
     * @param keys 一个key 或者string数组
     * @return 返回删除成功的个数
     */
    public Long del(String... keys) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(keys);
        } catch (Exception e) {
            log.error("删除失败");
            return 0L;
        } finally {
            returnPool(jedisPool, jedis);
        }
    }

    /**
     * 通过key向指定的value值追加值
     *
     * @param key
     * @param str
     * @return
     */
    public Long append(String key, String str) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = jedisPool.getResource();
            res = jedis.append(key, str);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        } finally {
            returnPool(jedisPool, jedis);
        }
        return res;
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return true或者false
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        } finally {
            returnPool(jedisPool, jedis);
        }
    }

    /**
     * 为给定的key设置过期时间，当key过期时 会自动被删除
     *
     * @param key
     * @param value   过期时间，单位；秒
     * @param indexdb
     * @return 成功返回 1  存在和异常返回0
     */
    public Long expire(String key, int value, int indexdb) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.expire(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        } finally {
            returnPool(jedisPool, jedis);
        }

    }

    /**
     * 以秒为单位返回指定key的剩余生存时间
     *
     * @param key
     * @param value
     * @param indexdb
     * @return 当key不存在时返回-2 当key存在但没有设置过期时间时 返回-1
     * 否者以秒为单位返回key的生存时间
     * 发生异常则返回0
     */
    public Long ttl(String key, int value, int indexdb) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.ttl(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        } finally {
            returnPool(jedisPool, jedis);
        }
    }

    /**
     * 移除给定key的生存时间
     *
     * @param key
     * @return 当生存时间移除成功时 返回 1，如果key不存在或者key没有设置生存时间返回0
     * 发生异常返回-1
     */
    public Long persist(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.persist(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return -1L;
        } finally {
            returnPool(jedisPool, jedis);
        }
    }


}
