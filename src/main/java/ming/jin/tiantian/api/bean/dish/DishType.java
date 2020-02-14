package ming.jin.tiantian.api.bean.dish;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/9 10:21
 * <p>
 * order_sys
 */
public class DishType implements Serializable {
    private String id;
    private String dishTypeName;
    private List<Dish> dishes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishTypeName() {
        return dishTypeName;
    }

    public void setDishTypeName(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
