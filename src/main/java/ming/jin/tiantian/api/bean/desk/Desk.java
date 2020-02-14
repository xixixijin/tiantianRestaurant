package ming.jin.tiantian.api.bean.desk;




import ming.jin.tiantian.api.bean.order.Order;

import java.io.Serializable;
import java.util.List;


/**
 * @author Haokun
 * @date 2020/1/7 15:54
 * <p>
 * order_sys
 */
public class Desk implements Serializable {
    private String id;
    private String deskName;
    private String deskAreaId;
    private String deskTypeId;
    private String deskStatusId;
    private String isLocked;

    private DeskArea deskArea;
    private DeskType deskType;
    private DeskStatus deskStatus;
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public DeskArea getDeskArea() {
        return deskArea;
    }

    public void setDeskArea(DeskArea deskArea) {
        this.deskArea = deskArea;
    }

    public DeskType getDeskType() {
        return deskType;
    }

    public void setDeskType(DeskType deskType) {
        this.deskType = deskType;
    }

    public DeskStatus getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(DeskStatus deskStatus) {
        this.deskStatus = deskStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskAreaId() {
        return deskAreaId;
    }

    public void setDeskAreaId(String deskAreaId) {
        this.deskAreaId = deskAreaId;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public String getDeskTypeId() {
        return deskTypeId;
    }

    public void setDeskTypeId(String deskTypeId) {
        this.deskTypeId = deskTypeId;
    }

    public String getDeskStatusId() {
        return deskStatusId;
    }

    public void setDeskStatusId(String deskStatusId) {
        this.deskStatusId = deskStatusId;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }
}
