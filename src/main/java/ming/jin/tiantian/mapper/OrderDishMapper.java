package ming.jin.tiantian.mapper;

import ming.jin.tiantian.api.bean.order.OrderDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/2/17 20:06
 * <p>
 * tiantianRestaurant
 */
@Mapper
public interface OrderDishMapper {

    @Select("select * from order_dish where cooking=0 order by dish_id")
    public List<OrderDish> getOrderDishList();

    @Update("update from order_dish where id=#{id}")
    public void finishDish(String id);

}
