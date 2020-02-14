package ming.jin.tiantian.api.bean.dish;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/9 10:21
 * <p>
 * order_sys
 */
public class DishTaste implements Serializable  {
    private String id;
    private String dishTasteName;
    private List<Dish> dishes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishTasteName() {
        return dishTasteName;
    }

    public void setDishTasteName(String dishTasteName) {
        this.dishTasteName = dishTasteName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
