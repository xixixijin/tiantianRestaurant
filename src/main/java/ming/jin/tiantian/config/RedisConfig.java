package ming.jin.tiantian.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.validation.Valid;

/**
 * @author Haokun
 * @date 2020/2/15 21:11
 * <p>
 * tiantianRestaurant
 */
@Configuration
@Slf4j
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWailMillis;

    @Value("${spring.redis.password}")
    private String password;

    //    配置jedis数据库连接池
    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        log.info("JedisPool注入成功");
        log.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //   连接耗尽是否阻塞， false异常 true阻塞到超时 默认true
        jedisPoolConfig.setBlockWhenExhausted(true);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);
        return jedisPool;
    }
}
