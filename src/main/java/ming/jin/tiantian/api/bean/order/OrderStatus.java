package ming.jin.tiantian.api.bean.order;

import java.io.Serializable;

/**
 * @author Haokun
 * @date 2020/1/9 0:23
 * <p>
 * order_sys
 */
public class OrderStatus implements Serializable {
    private String id;
    private String statusName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
