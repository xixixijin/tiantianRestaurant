package ming.jin.tiantian.api.bean.order;

import ming.jin.tiantian.api.bean.desk.Desk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/9 0:23
 * <p>
 * order_sys
 */
public class Order implements Serializable {
    private String id;
    private String deskId;
    private String statusId;
    private String userNum;
    private Date orderTime;
    private String orderMember;
    private String isStart;
    private BigDecimal totalPrice;
    private String presetTime;
    private Date finishTime;
    private String isFinished;
    private Desk desk;
    private List<OrderDish> dishes;
    private OrderStatus status;

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

    public String getPresetTime() {
        return presetTime;
    }

    public void setPresetTime(String presetTime) {
        this.presetTime = presetTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderMember() {
        return orderMember;
    }

    public void setOrderMember(String orderMember) {
        this.orderMember = orderMember;
    }

    public String getIsStart() {
        return isStart;
    }

    public void setIsStart(String isStart) {
        this.isStart = isStart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public List<OrderDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<OrderDish> dishes) {
        this.dishes = dishes;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
