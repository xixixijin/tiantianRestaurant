package ming.jin.tiantian.controller;

import ming.jin.tiantian.api.bean.order.OrderDish;
import ming.jin.tiantian.api.service.OrderDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/2/17 20:04
 * <p>
 * tiantianRestaurant
 */
@Controller
@RequestMapping("kitchen")
public class KitchenController {
    @Autowired
    OrderDishService orderDishService;

    @RequestMapping("/")
    public String kitchen(ModelMap map){
        List<OrderDish> orderDishes=orderDishService.getOrderDishList();
        List<List<OrderDish>> orderDishLists=new ArrayList<>();
        for (int i=0,j=0;i<orderDishes.size();i++){
            if (j>=orderDishLists.size()) {
                orderDishLists.add(new ArrayList<OrderDish>());
            }
            if (i>0&&!orderDishes.get(i).getDishId().equals(orderDishes.get(i-1).getDishId()) ){
                j++;
                orderDishLists.add(new ArrayList<OrderDish>());
                orderDishLists.get(j).add(orderDishes.get(i));
            }else {
                orderDishLists.get(j).add(orderDishes.get(i));

            }
        }
        map.put("orderDishLists",orderDishLists);
        return "kitchen/first.html";

    }
    @RequestMapping("cook")
    public String cook(){


        return "forward:../kitchen";
    }
}
