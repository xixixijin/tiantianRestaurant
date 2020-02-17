package ming.jin.tiantian.api.service;

import ming.jin.tiantian.api.bean.order.Order;
import ming.jin.tiantian.api.bean.order.OrderDish;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/10 18:25
 * <p>
 * order_sys
 */
public interface OrderService {

    List<Order> getOrderList();

    List<Order> getUnfinishedOrder();

    List<Order> getFinishedOrder();

    Order getOrderById(String orderId);

    List<Order> getOrderByStatusId(String s);

    void addOrder(Order order);

    void addOrderDish(OrderDish orderDish);
}
