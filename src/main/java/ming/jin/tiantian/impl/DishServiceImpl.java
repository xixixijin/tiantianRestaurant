package ming.jin.tiantian.impl;
import ming.jin.tiantian.api.bean.dish.CookType;
import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.bean.dish.DishTaste;
import ming.jin.tiantian.api.bean.dish.DishType;
import ming.jin.tiantian.api.service.DishService;
import ming.jin.tiantian.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Haokun
 * @date 2020/1/9 22:47
 * <p>
 * order_sys
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DishServiceImpl implements DishService {
    @Autowired
    DishMapper dishMapper;

    @Override
    public List<Dish> getDishList() {
        return dishMapper.getDishList();
    }

    @Override
    public List<DishTaste> getDishTasteList() {
        return dishMapper.getDishTasteList();
    }

    @Override
    public List<DishType> getDishTypeList() {
        return dishMapper.getDishTypeList();
    }

    @Override
    public List<CookType> getCookTypeList() {
        return dishMapper.getCookTypeList();
    }

    @Override
    public int addDishTaste(DishTaste dishTaste) {
        return dishMapper.addDishTaset(dishTaste);
    }

    @Override
    public int delDishTaste(String id) {

        dishMapper.delByTaste(id);
        int a=dishMapper.delDishTaste(id);
        return a;
    }

    @Override
    public int editDishTaste(DishTaste dishTaste) {
        return dishMapper.editDishTaste(dishTaste);
    }

    @Override
    public int addDishType(DishType dishType) {
        return dishMapper.addDishType(dishType);
    }

    @Override
    public int delDishType(String id) {
        dishMapper.delByType(id);
        int a =dishMapper.delDishType(id);
        return a;
    }

    @Override
    public int editDishType(DishType dishType) {
        return dishMapper.editDishType(dishType);
    }

    @Override
    public int addCookType(CookType cookType) {
        return dishMapper.addCookType(cookType);
    }

    @Override
    public int delCookType(String id) {
        return dishMapper.delCookType(id);
    }

    @Override
    public int editCookType(CookType cookType) {
        return dishMapper.editCookType(cookType);
    }

    @Override
    public void addDish(Dish dish) {
        dishMapper.addDish(dish);
    }


}

