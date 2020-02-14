package ming.jin.tiantian.controller;
import ming.jin.tiantian.api.bean.desk.Desk;
import ming.jin.tiantian.api.bean.desk.DeskArea;
import ming.jin.tiantian.api.bean.desk.DeskType;
import ming.jin.tiantian.api.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/14 15:13
 * <p>
 * order_sys
 */
@Controller
@RequestMapping("deskManagement")
public class DeskManagement {

    @Autowired
    DeskService deskService;

    @RequestMapping("first")
    public String firstPage(ModelMap map, String statusId) {

        List<Desk> desks = null;

        if (statusId == null) {
            desks = deskService.getDeskInfo();
        } else {
            // 空闲餐桌(1) 就餐中(2) 已预订(3)
            desks = deskService.getDeskByStatusId(statusId);
        }
        map.put("desks", desks);
        return "tableManagement/first.html";
    }

    @RequestMapping("deskSaveUI")
    public String saveDeskUi(String id, ModelMap map) {
        List<DeskArea> deskAreas=null;
        List<DeskType> deskTypes=null;
        if (id==null) {
            deskTypes = deskService.getDeskType();
            deskAreas = deskService.getDeskArea();
        } else {

        }
        map.put("deskTypes", deskTypes);
        map.put("deskAreas", deskAreas);
        return "tableManagement/saveDesk.html";
    }

    @RequestMapping("saveDesk")
    public String saveDesk(Desk desk) {
    if (desk.getId()==null){
        desk.setDeskStatusId("1");
        desk.setIsLocked("0");
    }else {
        deskService.editDeskInfo(desk);
    }
        return "forward:first";
    }

    @RequestMapping("second")
    public String secondPage(ModelMap map) {

        List<DeskArea> deskAreas = deskService.getDeskArea();
        map.put("deskAreas", deskAreas);

        return "tableManagement/second.html";
    }

    @RequestMapping("areaSaveUI")
    public String areaSaveUi(String id, ModelMap map) {
        if (id != null) {
            DeskArea deskArea=deskService.getDeskAreaById(id);
            map.put("deskArea", deskArea);
        }
        return "tableManagement/saveArea.html";
    }

    @RequestMapping("saveArea")
    public String saveArea(DeskArea deskArea) {
        if (deskArea.getId().isEmpty()) {
            deskService.addDeskArea(deskArea);
        } else {
            deskService.editDeskArea(deskArea);
        }
        //转发列表页面
        return "forward:second";
    }

    @RequestMapping("delete/{id}")
    public void dele(@PathVariable("id") String id) {
        deskService.deleteDeskArea(id);
    }


    @RequestMapping("third")
    public String thirdPage(ModelMap map) {

        List<DeskType> deskAreas = deskService.getDeskType();
        map.put("deskTypes", deskAreas);

        return "tableManagement/third.html";
    }

    @RequestMapping("typeSaveUI")
    public String typeSaveUi(String id, ModelMap map) {
        if (id != null) {
            map.put("deskType", deskService.getDeskTypeById(id));
        }
        return "tableManagement/saveType.html";
    }

    @RequestMapping("saveType")
    public String saveType(DeskType deskType) {
        if (deskType.getId().isEmpty()) {
            deskService.addDeskType(deskType);
        } else {
            deskService.editDeskType(deskType);
        }
        return "forward:third";
    }


}
