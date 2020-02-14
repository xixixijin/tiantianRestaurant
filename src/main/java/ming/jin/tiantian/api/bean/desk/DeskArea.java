package ming.jin.tiantian.api.bean.desk;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/7 16:09
 * <p>
 * order_sys
 */
public class DeskArea implements Serializable {
    private String id;
    private String areaName;
    private String areaDesc;
    private String areaFloor;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaDesc() {
        return areaDesc;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }

    public String getAreaFloor() {
        return areaFloor;
    }

    public void setAreaFloor(String areaFloor) {
        this.areaFloor = areaFloor;
    }
}
