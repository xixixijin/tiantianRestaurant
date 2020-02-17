package ming.jin.tiantian.impl;


import com.alibaba.fastjson.JSON;
import ming.jin.tiantian.api.bean.desk.Desk;
import ming.jin.tiantian.api.bean.desk.DeskArea;
import ming.jin.tiantian.api.bean.desk.DeskStatus;
import ming.jin.tiantian.api.bean.desk.DeskType;
import ming.jin.tiantian.api.service.DeskService;
import ming.jin.tiantian.api.utils.JedisUtils;
import ming.jin.tiantian.mapper.DeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
    @Autowired
    JedisUtils jedisUtils;

    @Override
    public List<Desk> getDeskInfo() {
        String list = jedisUtils.get("deskList");
        if (list == null || list.isEmpty()) {
            List<Desk> desks = deskMapper.getDeskInfo();
            if (desks == null) {
                jedisUtils.set("deskList", null);
            } else {
                String str = JSON.toJSONString(desks);
                jedisUtils.set("deskList", str);
            }
            return desks;
        } else {
            List<Desk> desks = JSON.parseArray(list, Desk.class);
            return desks;

        }


    }

    @Override
    public int addDesk(Desk desk) {
        jedisUtils.del("deskList", "getDeskByStatusId*", "getDeskByTypeId*");
        int a = deskMapper.addDesk(desk);
        jedisUtils.del("deskList", "getDeskByStatusId*", "getDeskByTypeId*");
        return a;
    }

    @Override
    public int deleteDesk(String deskId) {
        jedisUtils.del("deskList", "getDeskByStatusId*", "getDeskByTypeId*");
        int a = deskMapper.deleteDesk(deskId);
        jedisUtils.del("deskList", "getDeskByStatusId*", "getDeskByTypeId*");
        return a;
    }

    @Override
    public int editDeskInfo(Desk desk) {
        jedisUtils.del("deskList", "getDeskByStatusId*", "getDeskByTypeId*");
        int a = deskMapper.editDeskInfo(desk);
        jedisUtils.del("deskList", "getDeskByStatusId*", "getDeskByTypeId*");
        return a;
    }

    @Override
    public Desk getDeskByName(String deskName) {
        String deskStr = jedisUtils.get(deskName);
        if (deskStr == null || deskStr.isEmpty()) {
            Desk desk = deskMapper.getDeskByName(deskName);
            if (desk == null) {
                jedisUtils.setex(deskName, 60 * 2, null);
            } else {
                String str = JSON.toJSONString(desk);
                jedisUtils.setex(deskName,60*2,str);
            }
            return desk;
        } else {
            Desk desk = JSON.parseObject(deskStr, Desk.class);
            return desk;
        }
    }

    @Override
    public List<Desk> getDeskByStatusId(String deskStatusId) {
        String desk = jedisUtils.get("getDeskByStatusId" + deskStatusId);
        if (desk == null || desk.isEmpty()) {
            List<Desk> desks = deskMapper.getDeskByStatusId(deskStatusId);
            if (desks == null) {
                jedisUtils.setex("getDeskByStatusId" + deskStatusId, 60 * 2, null);
            } else {
                String str = JSON.toJSONString(desks);
                jedisUtils.setex("getDeskByStatusId" + deskStatusId, 60 * 2, str);
            }
            return desks;
        } else {
            List<Desk> desks = JSON.parseArray(desk, Desk.class);
            return desks;
        }
    }

    @Override
    public List<Desk> getDeskByTypeId(String deskTypeId) {
        String desk = jedisUtils.get("getDeskByTypeId" + deskTypeId);
        if (desk == null || desk.isEmpty()) {
            List<Desk> desks = deskMapper.getDeskByTypeId(deskTypeId);
            if (desks == null) {
                jedisUtils.setex("getDeskByTypeId" + deskTypeId, 60 * 2, null);
            } else {
                String str = JSON.toJSONString(desks);
                jedisUtils.setex("getDeskByTypeId" + deskTypeId, 60 * 2, str);
            }
            return desks;
        } else {
            List<Desk> desks = JSON.parseArray(desk, Desk.class);
            return desks;
        }


    }

    @Override
    public List<DeskArea> getDeskArea() {
        String list = jedisUtils.get("deskAreaList");
        if (list == null || list.isEmpty()) {
            List<DeskArea> deskAreas = deskMapper.getDeskArea();
            if (deskAreas == null) {
                jedisUtils.setex("deskAreaList", 60 * 2, null);
            } else {
                String str = JSON.toJSONString(deskAreas);
                jedisUtils.set("deskAreaList", str);
            }
            return deskAreas;
        } else {
            List<DeskArea> deskAreas = JSON.parseArray(list, DeskArea.class);
            return deskAreas;
        }
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
        deskMapper.addDeskArea(deskArea);
        jedisUtils.del("deskAreaList");
        return 1;

    }

    @Override
    public int deleteDeskArea(String deskAreaId) {

        deskMapper.deleteDeskArea(deskAreaId);
        jedisUtils.del("deskAreaList");
        return 1;
    }

    @Override
    public int editDeskArea(DeskArea deskArea) {
        jedisUtils.del("deskAreaList");
        deskMapper.editDeskArea(deskArea);
        return 1;
    }

    @Override
    public List<DeskType> getDeskType() {
        String list = jedisUtils.get("deskTypeList");
        if (list == null || list.isEmpty()) {
            List<DeskType> deskTypes = deskMapper.getDeskType();
            if (deskTypes == null) {
                jedisUtils.setex("deskTypeList", 60 * 2, null);
            } else {
                String str = JSON.toJSONString(deskTypes);
                jedisUtils.set("deskTypeList", str);
            }
            return deskTypes;
        } else {
            List<DeskType> deskTypes = JSON.parseArray(list, DeskType.class);
            return deskTypes;
        }
    }


    @Override
    public DeskType getDeskTypeById(String typeId) {
        DeskType deskType = deskMapper.getDeskTypeById(typeId);
        return deskType;
    }

    @Override
    public int addDeskType(DeskType deskType) {
        deskMapper.addDeskType(deskType);
        jedisUtils.del("deskTypeList");
        return 1;
    }

    @Override
    public int deleteDeskType(String deskTypeId) {
        deskMapper.deleteDeskType(deskTypeId);
        jedisUtils.del("deskTypeList");
        return 1;
    }

    @Override
    public int editDeskType(DeskType deskType) {
        deskMapper.editDeskType(deskType);
        jedisUtils.del("deskTypeList");
        return 1;
    }

    @Override
    public List<DeskStatus> getDeskStatus() {
        String list=jedisUtils.get("deskStatus");
        if (list==null||list.isEmpty()){
            List<DeskStatus> deskStatuses=deskMapper.getDeskStatus();
            if (deskStatuses==null){
                jedisUtils.setex("deskStatus",60*2,null);
            }else {
                String str=JSON.toJSONString(deskStatuses);
                jedisUtils.set("deskStatus",str);
            }
            return deskStatuses;
        }else{
            List<DeskStatus> deskStatuses=JSON.parseArray(list,DeskStatus.class);
            return deskStatuses;
        }
    }

    @Override
    public DeskStatus getDeskStatusById(String statusId) {
        return deskMapper.getDeskStatusById(statusId);
    }
}
