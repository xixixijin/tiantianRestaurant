package ming.jin.tiantian.api.service;
import ming.jin.tiantian.api.bean.dish.CookType;
import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.bean.dish.DishTaste;
import ming.jin.tiantian.api.bean.dish.DishType;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/9 22:46
 * <p>
 * order_sys
 */
public interface DishService {

    List<Dish> getDishList();

    List<DishTaste> getDishTasteList();

    List<DishType> getDishTypeList();

    List<CookType> getCookTypeList();

    int addDishTaste(DishTaste dishTaste);

    int delDishTaste(String id);

    int editDishTaste(DishTaste dishTaste);

    int addDishType(DishType dishType);

    int delDishType(String id);

    int editDishType(DishType dishType);

    int addCookType(CookType cookType);

    int delCookType(String id);

    int editCookType(CookType cookType);

    void addDish(Dish dish);

}
