package ming.jin.tiantian.controller;


import ming.jin.tiantian.api.bean.order.Order;
import ming.jin.tiantian.api.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/16 15:32
 * <p>
 * order_sys
 */
@Controller
@RequestMapping("order")
public class OrderManagement {
    @Autowired
    OrderService orderService;
private static Logger log= LoggerFactory.getLogger(OrderManagement.class);
    @RequestMapping("first")
    public String firstPage(ModelMap map, String statusId) {
        List<Order> orders = null;
        if ("0".equals(statusId)) {
            orders = orderService.getOrderList();
        }else {
            orders=orderService.getOrderByStatusId(statusId);
        }
        map.put("orders", orders);
        log.info("查询所有订单");
        return "order/orderlist.html";
    }

    @RequestMapping("add")
    @ResponseBody
    public String addOrder(String deskId) {


        return "success";
    }


}
