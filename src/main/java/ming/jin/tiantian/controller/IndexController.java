package ming.jin.tiantian.controller;

import ming.jin.tiantian.api.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Haokun
 * @date 2020/1/14 12:44
 * <p>
 * order_sys
 */
@Controller
public class IndexController {
    private static Logger log = LoggerFactory.getLogger(IndexController.class);
    private String string;


    @RequestMapping({"/", "index"})
    public String index(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            Cookie cookie = CookieUtils.getCookieByName(cookies, "sessionId");
            if (cookie != null) {
                if (!session.getId().equals(cookie.getValue())) {
                    cookie.setValue(session.getId());
                    response.addCookie(cookie);
                }
            } else {
                Cookie newcookie = new Cookie("sessionId", session.getId());
                response.addCookie(newcookie);
            }

        } else {
            Cookie cookie = new Cookie("sessionId", session.getId());
            response.addCookie(cookie);
        }

        return "index.html";
    }


}
