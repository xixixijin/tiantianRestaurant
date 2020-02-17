package ming.jin.tiantian.impl;

import ming.jin.tiantian.api.bean.order.OrderDish;
import ming.jin.tiantian.api.service.OrderDishService;
import ming.jin.tiantian.mapper.OrderDishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/2/17 22:01
 * <p>
 * tiantianRestaurant
 */
@Service
public class OrderDishServiceImpl implements OrderDishService {
    @Autowired
    OrderDishMapper mapper;

    @Override
    public List<OrderDish> getOrderDishList() {
        return mapper.getOrderDishList();
    }

    @Override
    public void finishDish(String id) {
        mapper.finishDish(id);
    }
}
