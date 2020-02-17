package ming.jin.tiantian.mapper;
import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.bean.order.Order;
import ming.jin.tiantian.api.bean.order.OrderDish;
import ming.jin.tiantian.api.bean.order.OrderStatus;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/10 18:25
 * <p>
 * order_sys
 */
@Mapper
public interface OrderMapper {

    /** 查询所有订单*/
    @Select("select * from order_info")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "desk_id",property = "desk",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskById"
            )),
            @Result(column = "status_id",property = "status",one = @One(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderStatusById"
            )),
            @Result(column = "id",property = "dishes",javaType = List.class,many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderDishByOrderId"
            ))
    })
    List<Order> getOrderList();

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into order_info (desk_id,user_num,order_time,order_member,is_start,total_price,status_id,preset_time,finish_time,is_finished) values (#{deskId},#{userNum},#{orderTime},#{orderMember},#{isStart},#{totalPrice},#{statusId},#{presetTime},#{finishTime},#{isFinished} )")
    void addOrder(Order order);


    //根据id查询订单状态
    @Select("select * from order_status where id=#{statusId}")
    OrderStatus getOrderStatusById(String statusId);

    //根据订单id查询订单点的菜
    @Select("select * from order_dish where order_info_id=#{orderId}")
    @Results({
            @Result(column = "dish_id",property = "dish",javaType = Dish.class,one = @One(
                    select = "ming.jin.tiantian.mapper.DishMapper.getDishById"
            ))
    })
    List<OrderDish> getOrderDishByOrderId(String orderId);
    //添加订单中的菜
    @Insert("insert into order_dish (order_info_id,dish_id,dish_num,is_finished,finish_time,cooking) values(#{orderId},#{dishId},#{dishNum},#{isFinished},#{finishTime},#{cooking})")
    void addOrderDish(OrderDish orderDish);

    //查询未完成订单
    @Select("select *from order_info where is_finished=0")
    @Results(value = {

            @Result(column = "desk_id",property = "desk",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskById"
            )),
            @Result(column = "status_id",property = "status",one = @One(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderStatusById"
            )),
            @Result(column = "id",property = "dishes",many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderDishByOrderId"
            ))
    })
    List<Order> getUnfinishedOrder();
    //查询已完成订单
    @Select("select *from order_info where is_finished=1")
    @Results(value = {

            @Result(column = "desk_id",property = "desk",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskById"
            )),
            @Result(column = "status_id",property = "status",one = @One(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderStatusById"
            )),
            @Result(column = "id",property = "dishes",many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderDishByOrderId"
            ))
    })
    List<Order> getFinishedOrder();
//    根据订单号查询订单
    @Select("select *from order_info where id={orderId}")
    @Results(value = {

            @Result(column = "desk_id",property = "desk",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskById"
            )),
            @Result(column = "status_id",property = "status",one = @One(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderStatusById"
            )),
            @Result(column = "id",property = "dishes",many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderDishByOrderId"
            ))
    })
    Order getOrderById(String orderId);

    /**
     * 根据订单status查询订单
     * @param statusId
     * @return
     */
    @Select("select * from order_info where status_id=#{statusId}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "desk_id",property = "desk",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskById"
            )),
            @Result(column = "status_id",property = "status",one = @One(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderStatusById"
            )),
            @Result(column = "id",property = "dishes",javaType = List.class,many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderDishByOrderId"
            ))
    })
    List<Order> getOrderByStatusId(String statusId);
    @Select("select * from order_info where desk_id=#{deskId} and (status_id=1 or status_id=2)")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "status_id",property = "status",one = @One(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderStatusById"
            )),
            @Result(column = "id",property = "dishes",javaType = List.class,many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderDishByOrderId"
            ))
    })
    List<Order> getOrderByDeskId(String deskId);
}
