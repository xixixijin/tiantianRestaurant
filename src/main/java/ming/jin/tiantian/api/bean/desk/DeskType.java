package ming.jin.tiantian.api.bean.desk;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/7 16:16
 * <p>
 * order_sys
 */
public class DeskType implements Serializable {
    private String id;
    private String deskTypeName;
    private String maxUsers;
    private String minUsers;
    private List<Desk> desks;

    public List<Desk> getDesks() {
        return desks;
    }

    public void setDesks(List<Desk> desks) {
        this.desks = desks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskTypeName() {
        return deskTypeName;
    }

    public void setDeskTypeName(String deskTypeName) {
        this.deskTypeName = deskTypeName;
    }

    public String getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(String maxUsers) {
        this.maxUsers = maxUsers;
    }

    public String getMinUsers() {
        return minUsers;
    }

    public void setMinUsers(String minUsers) {
        this.minUsers = minUsers;
    }
}
