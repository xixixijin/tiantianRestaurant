package ming.jin.tiantian.impl;



import ming.jin.tiantian.api.bean.order.Order;
import ming.jin.tiantian.api.service.OrderService;
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

    /**
     * 查询所有订单
     * @return 返回订单列表
     */
    @Override
    public List<Order> getOrderList() {
        return orderMapper.getOrderList();
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
}
