package ming.jin.tiantian.api.bean.dish;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/9 22:27
 * <p>
 * order_sys
 */
public class CookType implements Serializable  {
    private String id;
    private String cookTypeName;
    private List<Dish> dishes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCookTypeName() {
        return cookTypeName;
    }

    public void setCookTypeName(String cookTypeName) {
        this.cookTypeName = cookTypeName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
