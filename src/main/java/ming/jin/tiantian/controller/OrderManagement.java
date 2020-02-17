package ming.jin.tiantian.controller;


import ming.jin.tiantian.api.bean.order.Order;
import ming.jin.tiantian.api.bean.order.OrderDish;
import ming.jin.tiantian.api.service.OrderService;
import ming.jin.tiantian.api.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Haokun
 * @date 2020/1/16 15:32
 * <p>
 * 订单管理
 */
@Controller
@RequestMapping("order")
public class OrderManagement {
    @Autowired
    OrderService orderService;

    private static Logger log = LoggerFactory.getLogger(OrderManagement.class);

    @RequestMapping("first")
    public String firstPage(ModelMap map, String statusId) {
        List<Order> orders = null;
        if ("0".equals(statusId)) {
            orders = orderService.getOrderList();
        } else {
            orders = orderService.getOrderByStatusId(statusId);
        }
        map.put("orders", orders);
        log.info("查询所有订单");
        return "order/orderlist.html";
    }

    /**
     * 将餐桌信息和订单内容存到cookie里
     *
     * @return 转发到点菜页面
     */
    @RequestMapping("addDish")
    public String addOrderDish(String deskId, String dishId, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie dishCookie = CookieUtils.getCookieByName(cookies, "dishId");

        if (CookieUtils.getCookieByName(cookies, "deskId") == null) {
            Cookie cookie = new Cookie("deskId", deskId);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        if (dishCookie == null) {
            Cookie cookie = new Cookie("dishId", dishId);
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            String dishIds = dishCookie.getValue();
            dishCookie.setValue(dishIds + "|" + dishId);
            dishCookie.setPath("/");
            response.addCookie(dishCookie);
        }
        return "forward:/customer/menu?deskId=" + deskId;
    }

    /**
     * 下订单
     *
     * @return 订单页面
     */
    @RequestMapping("add")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class})
    public String addOrder(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie deskCookie=CookieUtils.getCookieByName(cookies, "deskId");
        Cookie dishCookie= CookieUtils.getCookieByName(cookies, "dishId");
        String deskId = deskCookie.getValue();
        String dishIds =dishCookie.getValue();
        String[] str = dishIds.split("\\|");
        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        Order order = new Order();
        order.setOrderTime(new Date());
        order.setDeskId(deskId);
        order.setStatusId("2");
        orderService.addOrder(order);
        String orderId = order.getId();
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            OrderDish orderDish = new OrderDish();
            orderDish.setOrderInfoId(orderId);
            orderDish.setDishId(entry.getKey());
            orderDish.setDishNum(entry.getValue().toString());
            orderDish.setIsFinished("0");
            orderService.addOrderDish(orderDish);
        }
        deskCookie.setMaxAge(0);
        deskCookie.setPath("/");
        dishCookie.setMaxAge(0);
        dishCookie.setPath("/");
        response.addCookie(deskCookie);
        response.addCookie(dishCookie);
        return "success";
    }


}
