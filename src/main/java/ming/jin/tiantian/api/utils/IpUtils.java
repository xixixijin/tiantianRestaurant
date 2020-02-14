package ming.jin.tiantian.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Haokun
 * @date 2020/2/13 19:06
 * <p>
 * 获取ip的方法
 *
 */


public class IpUtils {
    private static final String LOCAL_IP="127.0.0.1";
    private static Logger log= LoggerFactory.getLogger(IpUtils.class);

    public static String getIpAddr(HttpServletRequest request){
        if (request==null){
            return "unknown";
        }
        String ip=request.getHeader("x-forwarded-for");



return "111";


    }





}
