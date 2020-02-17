package ming.jin.tiantian.api.service;

import ming.jin.tiantian.api.bean.order.OrderDish;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/2/17 21:59
 * <p>
 * tiantianRestaurant
 */
public interface OrderDishService {

    List<OrderDish> getOrderDishList();

    void finishDish(String id);
}
