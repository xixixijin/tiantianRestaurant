package ming.jin.tiantian.api.utils;

import javax.servlet.http.Cookie;

/**
 * @author Haokun
 * @date 2020/2/13 20:32
 * <p>
 * tiantian-springboot
 */
public class CookieUtils {
    public static Cookie getCookieByName(Cookie[] cookies, String cookieName) {
        if (cookies == null) {
            return null;

        } else {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie;
                }
            }
            return null;
        }
    }
    public static Cookie createCookie(String cookieName,String cookieValue){
        return new Cookie(cookieName,cookieValue);
    }

}
