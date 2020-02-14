package ming.jin.tiantian.impl;



import ming.jin.tiantian.api.bean.desk.Desk;
import ming.jin.tiantian.api.bean.desk.DeskArea;
import ming.jin.tiantian.api.bean.desk.DeskStatus;
import ming.jin.tiantian.api.bean.desk.DeskType;
import ming.jin.tiantian.api.service.DeskService;
import ming.jin.tiantian.mapper.DeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/7 22:02
 * <p>
 * order_sys
 */
@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    DeskMapper deskMapper;

    @Override
    public List<Desk> getDeskInfo() {
        return deskMapper.getDeskInfo();
    }

    @Override
    public int addDesk(Desk desk) {
        return deskMapper.addDesk(desk);
    }

    @Override
    public int deleteDesk(String deskId) {
        return deskMapper.deleteDesk(deskId);
    }

    @Override
    public int editDeskInfo(Desk desk) {
        return deskMapper.editDeskInfo(desk);
    }

    @Override
    public Desk getDeskByName(String deskName) {
        return deskMapper.getDeskByName(deskName);
    }

    @Override
    public List<Desk> getDeskByStatusId(String deskStatusId) {
        return deskMapper.getDeskByStatusId(deskStatusId);
    }

    @Override
    public List<Desk> getDeskByTypeId(String deskTypeId) {
        return deskMapper.getDeskByTypeId(deskTypeId);
    }

    @Override
    public List<DeskArea> getDeskArea() {
        return deskMapper.getDeskArea();
    }

    @Override
    public DeskArea getDeskAreaById(String areaId) {
        return deskMapper.getDeskAreaById(areaId);
    }

    @Override
    public List<DeskArea> getDeskAreaByName(String areaName) {
        return deskMapper.getDeskAreaByName(areaName);
    }

    @Override
    public List<DeskArea> getDeskAreaByFloor(String areaFloor) {
        return deskMapper.getDeskAreaByFloor(areaFloor);
    }

    @Override
    public int addDeskArea(DeskArea deskArea) {
        return deskMapper.addDeskArea(deskArea);
    }

    @Override
    public int deleteDeskArea(String deskAreaId) {
        return deskMapper.deleteDeskArea(deskAreaId);
    }

    @Override
    public int editDeskArea(DeskArea deskArea) {
        return deskMapper.editDeskArea(deskArea);
    }

    @Override
    public List<DeskType> getDeskType() {
        return deskMapper.getDeskType();
    }

    @Override
    public DeskType getDeskTypeById(String typeId) {
        return deskMapper.getDeskTypeById(typeId);
    }

    @Override
    public int addDeskType(DeskType deskType) {
        return deskMapper.addDeskType(deskType);
    }

    @Override
    public int deleteDeskType(String deskTypeId) {
        return deskMapper.deleteDeskType(deskTypeId);
    }

    @Override
    public int editDeskType(DeskType deskType) {
        return deskMapper.editDeskType(deskType);
    }

    @Override
    public List<DeskStatus> getDeskStatus() {
        return deskMapper.getDeskStatus();
    }

    @Override
    public DeskStatus getDeskStatusById(String statusId) {
        return deskMapper.getDeskStatusById(statusId);
    }
}
