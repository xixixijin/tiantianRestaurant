package ming.jin.tiantian.mapper;

import ming.jin.tiantian.api.bean.dish.CookType;
import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.bean.dish.DishTaste;
import ming.jin.tiantian.api.bean.dish.DishType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/9 22:46
 * <p>
 * order_sys
 */
@Mapper
public interface DishMapper {
    /**
     * 查询所有菜品
     * @return
     */
    @Select("select * from dish_info")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "dish_type_id",property = "dishType",one = @One(
                    select = "ming.jin.tiantian.mapper.DishMapper.getDishTypeById"
            )),
            @Result(column = "dish_taste_id",property = "dishTaste",one = @One(
                    select = "ming.jin.tiantian.mapper.DishMapper.getTasteById"
            )),
            @Result(column = "cook_type_id",property = "cookType",one = @One(
                    select = "ming.jin.tiantian.mapper.DishMapper.getCookTypeById"
            ))
    })
    List<Dish> getDishList();

    @Select("select * from dish_info where id=#{dishId}")
    Dish getDishById(String dishId);

    /**
     * 删除口味后将菜肴的口味设为空
     * @param id
     */
    @Update("update dish_info set dish_taste_id=null where dish_taste_id=#{id}")
    void delByTaste(String id);
    /**
     * 删除菜系后将菜肴的菜系设为空
     * @param id
     */
    @Update("update dish_info set dish_type_id=null where dish_type_id=#{id}")
    void delByType(String id);
    //添加菜肴
    @Insert("insert into dish_info (dish_name,dish_type_id,dish_taste_id,price,pic_path,cook_type_id) values (#{dishName},#{dishTypeId},#{dishTasteId},#{price},#{picPath},#{cookTypeId})")
    void addDish(Dish dish);
    @Delete("delete from dish_info where id=#{id}")
    void delDish(String id);

    /**
     * 查询所有口味
     * @return
     */
    @Select("select * from dish_taste")
    List<DishTaste> getDishTasteList();
    //根据id查询taste
    @Select("select * from dish_taste where id=#{tasteId}")
    DishTaste getTasteById(String tasteId);

    /**
     * 查询所有菜的类别
     * @return
     */
    @Select("select * from dish_type")
    List<DishType> getDishTypeList();
    //根据id查询type
    @Select("select * from dish_type where id=#{typeId}")
    DishType getDishTypeById(String typeId);
    /**
     * 查询所有菜的做法
     * @return
     */
    @Select("select * from cook_type")
    List<CookType> getCookTypeList();


    @Select("select * from cook_type where id=#{cookTypeId}")
    CookType getCookTypeById(String cookTypeId);

    //添加口味
    @Insert("insert into dish_taste (dish_taste_name) values(#{dishTasteName})")
    int addDishTaset(DishTaste dishTaste);
    //删除口味
    @Delete("delete from dish_taste where id=#{id}")
    int delDishTaste(String id);
    //更改口味
    @Update("update dish_taste set dish_taste_name=#{dishTasteName} where id=#{id}")
    int editDishTaste(DishTaste dishTaste);

    //添加菜系
    @Insert("insert into dish_type (dish_type_name) values(#{dishTypeName})")
    int addDishType(DishType dishType);
    //删除菜系
    @Delete("delete from dish_type where id=#{id}")
    int delDishType(String id);
    //修改菜系
    @Update("update dish_type set dish_type_name=#{dishTypeName} where id=#{id}")
    int editDishType(DishType dishType);
    //添加做法
    @Insert("insert into cook_type (cook_type_name) values(#{cookTypeName}) ")
    int addCookType(CookType cookType);
    //删除做法
    @Delete("delete from cook_type where id=#{id}")
    int delCookType(String id);
    //
    @Update("update cook_type set cook_type_name=#{cookTypeName} where id=#{id}")
    int editCookType(CookType cookType);

}
