package ming.jin.tiantian.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import ming.jin.tiantian.api.bean.order.Order;
import ming.jin.tiantian.api.bean.order.OrderDish;
import ming.jin.tiantian.api.service.OrderService;
import ming.jin.tiantian.api.utils.JedisUtils;
import ming.jin.tiantian.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/10 18:25
 * <p>
 * order_sys
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    JedisUtils jedisUtils;

    /**
     * 查询所有订单
     *
     * @return 返回订单列表
     */
    @Override
    public List<Order> getOrderList() {
        String list = jedisUtils.get("orderList");
        if (list == null || list.isEmpty()) {
            List<Order> orders = orderMapper.getOrderList();
            if (orders == null) {
                jedisUtils.set("orderList", null);
            } else {
                String str = JSON.toJSONString(orders);
                jedisUtils.set("orderList", str);
            }
            return orders;
        } else {
            List<Order> orders = JSON.parseArray(list, Order.class);
            return orders;
        }

    }

    @Override
    public List<Order> getUnfinishedOrder() {
        return orderMapper.getUnfinishedOrder();
    }

    @Override
    public List<Order> getFinishedOrder() {
        return orderMapper.getFinishedOrder();
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public List<Order> getOrderByStatusId(String s) {
        return orderMapper.getOrderByStatusId(s);
    }

    @Override
    public void addOrder(Order order) {

        orderMapper.addOrder(order);
        jedisUtils.del("orderList");
    }

    @Override
    public void addOrderDish(OrderDish orderDish) {
        orderMapper.addOrderDish(orderDish);
    }
}
