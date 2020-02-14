package ming.jin.tiantian.controller;

import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/21 12:06
 * <p>
 * order_sys
 */
@Controller
@RequestMapping("customer")
public class CustomerManage {
    @Autowired
    DishService dishService;

    @RequestMapping("menu")
    public String menu(ModelMap map,String deskId){
        List<Dish> dishes = dishService.getDishList();
        map.put("dishes", dishes);
        map.put("deskId",deskId);
        return "customer/orderDish.html";
    }



}
