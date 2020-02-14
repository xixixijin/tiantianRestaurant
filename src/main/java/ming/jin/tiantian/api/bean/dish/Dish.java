package ming.jin.tiantian.api.bean.dish;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Haokun
 * @date 2020/1/9 0:28
 * 菜品
 * order_sys
 */
public class Dish implements Serializable {
    private String id;
    private String dishName;
    private String dishTypeId;
    private String dishTasteId;
    private BigDecimal price;
    private String picPath;
    private String cookTypeId;
    private CookType cookType;
    private DishTaste dishTaste;
    private DishType dishType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishTypeId() {
        return dishTypeId;
    }

    public void setDishTypeId(String dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public String getDishTasteId() {
        return dishTasteId;
    }

    public void setDishTasteId(String dishTasteId) {
        this.dishTasteId = dishTasteId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getCookTypeId() {
        return cookTypeId;
    }

    public void setCookTypeId(String cookTypeId) {
        this.cookTypeId = cookTypeId;
    }

    public CookType getCookType() {
        return cookType;
    }

    public void setCookType(CookType cookType) {
        this.cookType = cookType;
    }

    public DishTaste getDishTaste() {
        return dishTaste;
    }

    public void setDishTaste(DishTaste dishTaste) {
        this.dishTaste = dishTaste;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }
}
