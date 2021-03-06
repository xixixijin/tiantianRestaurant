package ming.jin.tiantian.api.bean.order;
import ming.jin.tiantian.api.bean.dish.Dish;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Haokun
 * @date 2020/1/9 0:23
 * <p>
 * order_sys
 */
public class OrderDish implements Serializable {
    private String id;
    private String orderInfoId;//订单id
    private String dishId;//菜的id
    private String dishNum;//菜的数量

    private String isFinished;
    private Date finishTime;
    private Dish dish;
    private String cooking; // 1代表后厨在做 0代表还没开始做

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(String orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishNum() {
        return dishNum;
    }

    public void setDishNum(String dishNum) {
        this.dishNum = dishNum;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
