package ming.jin.tiantian.mapper;
import ming.jin.tiantian.api.bean.desk.Desk;
import ming.jin.tiantian.api.bean.desk.DeskArea;
import ming.jin.tiantian.api.bean.desk.DeskStatus;
import ming.jin.tiantian.api.bean.desk.DeskType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/7 17:29
 * <p>
 * order_sys
 */
@Mapper
public interface DeskMapper {


    @Select("select * from desk_info")
    @Results(id = "id",value = {
            @Result(column = "desk_area_id",property = "deskArea",one =@One(
                   select = "ming.jin.tiantian.mapper.DeskMapper.getDeskAreaById",fetchType = FetchType.DEFAULT
            )),
            @Result(column = "desk_type_id",property = "deskType",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskTypeById"
            )),
            @Result(column = "desk_status_id",property = "deskStatus",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskStatusById"
            )),
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "orders",javaType = List.class,many = @Many(
                    select = "ming.jin.tiantian.mapper.OrderMapper.getOrderByDeskId"
            ))
    })
    List<Desk> getDeskInfo();

    @Insert("insert into desk_info (desk_name,desk_area_id,desk_type_id,desk_status_id,is_locked) values ( #{deskName},#{deskAreaId},#{deskTypeId},#{deskStatusId},#{isLocked} )")
    int addDesk(Desk desk);
    @Delete("delete from desk_info where id=#{deskId}")
    int deleteDesk(String deskId);
    @Update("update desk_info set desk_area_id=#{deskAreaId},desk_name=#{deskName},desk_type_id=#{deskTypeId},desk_status_id=#{deskStatusId},is_locked=#{isLocked}  where id=#{id}")
    int editDeskInfo(Desk desk);

    @Select("select * from desk_info where desk_name=#{deskName}")
    @Results(value = {
            @Result(column = "desk_area_id",property = "deskArea",one =@One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskAreaById",fetchType = FetchType.DEFAULT
            )),
            @Result(column = "desk_type_id",property = "deskType",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskTypeById"
            )),
            @Result(column = "desk_status_id",property = "deskStatus",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskStatusById"
            ))
    })
    Desk getDeskByName(String deskName);

    @Select("select * from desk_info where id=#{deskId}")
    @Results(value = {
            @Result(column = "desk_area_id",property = "deskArea",one =@One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskAreaById",fetchType = FetchType.DEFAULT
            )),
            @Result(column = "desk_type_id",property = "deskType",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskTypeById"
            )),
            @Result(column = "desk_status_id",property = "deskStatus",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskStatusById"
            ))
    })
    Desk getDeskById(String deskId);



    @Select("select * from desk_info where desk_status_id=#{statusId}")
    @Results(value = {
            @Result(column = "desk_area_id",property = "deskArea",one =@One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskAreaById",fetchType = FetchType.DEFAULT
            )),
            @Result(column = "desk_type_id",property = "deskType",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskTypeById"
            )),
            @Result(column = "desk_status_id",property = "deskStatus",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskStatusById"
            ))
    })
    List<Desk> getDeskByStatusId(String statusId);

    @Select("select * from desk_status where id=#{deskStatusId}")
    @Results(value = {
            @Result(column = "id",property = "desks",many = @Many(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskByStatusId"
            ))
    })
    List<Desk> getDeskByStatus(String deskStatusId);

    @Select("select *from desk_info where desk_type_id=#{deskTypeId}")
    @Results(value = {
            @Result(column = "desk_area_id",property = "deskArea",one =@One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskAreaById",fetchType = FetchType.DEFAULT
            )),
            @Result(column = "desk_type_id",property = "deskType",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskTypeById"
            )),
            @Result(column = "desk_status_id",property = "deskStatus",one = @One(
                    select = "ming.jin.tiantian.mapper.DeskMapper.getDeskStatusById"
            ))
    })
    List<Desk> getDeskByTypeId(String deskTypeId);

    @Select("select * from desk_area where id=#{deskAreaId}")
    List<Desk> getDeskByArea(String deskAreaId);



    @Select("select * from desk_area")
    List<DeskArea> getDeskArea();
    @Select("select * from desk_area where id=#{areaId}")
    DeskArea getDeskAreaById(String areaId);
    @Select("select * from desk_area where area_name=#{areaName}")
    List<DeskArea> getDeskAreaByName(String areaName);
    @Select("select * from desk_area where area_floor=#{areaFloor}")
    List<DeskArea> getDeskAreaByFloor(String areaFloor);

    @Insert("insert into desk_area (area_name,area_desc,area_floor) values(#{areaName},#{areaDesc},#{areaFloor})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addDeskArea(DeskArea deskArea);
    @Delete("delete from desk_area where id =#{deskAreaId}")
    int deleteDeskArea(String deskAreaId);
    @Update("update desk_area set area_name=#{areaName},area_desc=#{areaDesc},area_floor=#{areaFloor} where id=#{id}")
    int editDeskArea(DeskArea deskArea);


    @Select("select * from desk_type")
    List<DeskType> getDeskType();
    @Select("select * from desk_type where id=#{typeId}")
    DeskType getDeskTypeById(String typeId);
    @Insert("insert into desk_type(desk_type_name,max_users,min_users) values (#{deskTypeName},#{maxUsers},#{minUsers})")
    int addDeskType(DeskType deskType);
    @Delete("delete from desk_type where id=#{id}")
    int deleteDeskType(String id);
    @Update("update desk_type set desk_type_name=#{deskTypeName},max_users=#{maxUsers},min_users=#{minUsers} where id=#{id}")
    int editDeskType(DeskType deskType);

    @Select("select * from desk_status ")
    List<DeskStatus> getDeskStatus();
    @Select("select * from desk_status where id=#{statusId}")
    DeskStatus getDeskStatusById(String statusId);




}
