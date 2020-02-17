package ming.jin.tiantian.impl;
import com.alibaba.fastjson.JSON;
import ming.jin.tiantian.api.bean.dish.CookType;
import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.bean.dish.DishTaste;
import ming.jin.tiantian.api.bean.dish.DishType;
import ming.jin.tiantian.api.service.DishService;
import ming.jin.tiantian.api.utils.JedisUtils;
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
    @Autowired
    JedisUtils jedisUtils;

    @Override
    public List<Dish> getDishList() {
        String list = jedisUtils.get("dishList");
        if (list==null|| list.isEmpty()){
            List<Dish> dishes=dishMapper.getDishList();
            if (dishes==null){
                jedisUtils.setex("dishList",60*2,null);
            }else{
                String str= JSON.toJSONString(dishes);
                jedisUtils.set("dishList",str);
            }
            return dishes;
        }else {
            List<Dish> dishes=JSON.parseArray(list,Dish.class);
            return dishes;
        }
    }

    @Override
    public void addDish(Dish dish) {
        dishMapper.addDish(dish);
        jedisUtils.del("dishList");
    }

    @Override
    public List<DishTaste> getDishTasteList() {
        String list=jedisUtils.get("dishTasteList");
        if (list==null||list.isEmpty()){
            List<DishTaste> dishTastes=dishMapper.getDishTasteList();
            if (dishTastes==null){
                jedisUtils.setex("dishTasteList",60*2,null);
            }else {
                String str=JSON.toJSONString(dishTastes);
                jedisUtils.set("dishTasteList",str);
            }
            return dishTastes;

        }else {
            List<DishTaste> dishTastes=JSON.parseArray(list,DishTaste.class);
            return dishTastes;
        }
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
        dishMapper.addDishTaset(dishTaste);
        jedisUtils.del("dishTasteList");
        return 1;
    }

    @Override
    public int delDishTaste(String id) {

        dishMapper.delByTaste(id);
        int a=dishMapper.delDishTaste(id);
        jedisUtils.del("dishTasteList");
        return a;
    }

    @Override
    public int editDishTaste(DishTaste dishTaste) {
        dishMapper.editDishTaste(dishTaste);
        jedisUtils.del("dishTasteList");
        return 1;

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


}

