package ming.jin.tiantian;

import ming.jin.tiantian.api.bean.desk.Desk;
import ming.jin.tiantian.api.service.DeskService;
import ming.jin.tiantian.api.utils.JedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class TiantianSpringbootApplicationTests {

    @Autowired
    JedisPool jedisPool;
    @Autowired
    DeskService deskService;
    @Test
    void contextLoads() {
        Desk desk=deskService.getDeskByName("第一桌");
        System.out.println(1);
    }

}
