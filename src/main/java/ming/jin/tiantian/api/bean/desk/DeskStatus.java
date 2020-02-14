package ming.jin.tiantian.api.bean.desk;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/7 16:21
 * <p>
 * order_sys
 */
public class DeskStatus implements Serializable {
    private String id;
    private String deskStatusName;
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

    public String getDeskStatusName() {
        return deskStatusName;
    }

    public void setDeskStatusName(String deskStatusName) {
        this.deskStatusName = deskStatusName;
    }
}
