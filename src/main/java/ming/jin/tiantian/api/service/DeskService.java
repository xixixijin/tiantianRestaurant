package ming.jin.tiantian.api.service;

import ming.jin.tiantian.api.bean.desk.Desk;
import ming.jin.tiantian.api.bean.desk.DeskArea;
import ming.jin.tiantian.api.bean.desk.DeskStatus;
import ming.jin.tiantian.api.bean.desk.DeskType;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/7 17:16
 * <p>
 * order_sys
 */
public interface DeskService {

    /**
     * 查询所有桌位信息
     * @return
     */
    List<Desk> getDeskInfo();

    int addDesk(Desk desk);
    int deleteDesk(String deskId);
    int editDeskInfo(Desk desk);


    /**
     * 根据餐桌名字查找餐桌信息
     * @param deskName
     * @return
     */
    Desk getDeskByName(String deskName);

    /**
     * 根据餐桌状态查询餐桌
     * @param deskStatusId
     * @return
     */
    List<Desk> getDeskByStatusId(String deskStatusId);

    /**
     * 根据餐桌类型查询餐桌
     * @param deskType
     * @return
     */
    List<Desk> getDeskByTypeId(String deskType);

    /**
     * 查询所有餐桌区域
     * @return
     */
    List<DeskArea> getDeskArea();

    /**
     * 根据区域id查询区域信息
     * @param areaId
     * @return
     */
    DeskArea getDeskAreaById(String areaId);

    /**
     * 根据区域名字查询区域信息
     * @param areaName
     * @return
     */
    List<DeskArea> getDeskAreaByName(String areaName);

    /**
     * 根据区域楼层查询区域信息
     * @param areaFloor
     * @return
     */
    List<DeskArea> getDeskAreaByFloor(String areaFloor);

    int addDeskArea(DeskArea deskArea);
    int deleteDeskArea(String deskAreaId);
    int editDeskArea(DeskArea deskArea);



    /**
     * 查询餐桌类型
     * @return
     */
    List<DeskType> getDeskType();

    /**
     * 根据状态id查询餐桌类型
     * @param typeId
     * @return
     */
    DeskType getDeskTypeById(String typeId);

    int addDeskType(DeskType deskType);
    int deleteDeskType(String deskTypeId);
    int editDeskType(DeskType deskType);

    /**
     * 查询餐桌状态
     * @return
     */
    List<DeskStatus> getDeskStatus();
    DeskStatus getDeskStatusById(String statusId);




}
