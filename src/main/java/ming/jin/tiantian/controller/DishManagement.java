package ming.jin.tiantian.controller;

import ming.jin.tiantian.api.bean.dish.Dish;
import ming.jin.tiantian.api.bean.dish.DishTaste;
import ming.jin.tiantian.api.bean.dish.DishType;
import ming.jin.tiantian.api.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Haokun
 * @date 2020/1/16 15:39
 * <p>
 * 菜单管理
 */
@Controller
@RequestMapping("dish")
public class DishManagement {
    @Autowired
    DishService dishService;
    private static final String URL_PREFIX = "http://localhost:8001";

    @RequestMapping("first")
    public String firstPage(ModelMap map) {

        List<Dish> dishes = dishService.getDishList();
        map.put("dishes", dishes);
        return "dish/menu.html";
    }

    @RequestMapping("taste.html")
    public String tastePage(ModelMap map) {
        List<DishTaste> tastes = dishService.getDishTasteList();
        map.put("tastes", tastes);
        return "dish/taste.html";
    }

    @RequestMapping("type.html")
    public String typePage(ModelMap map) {
        List<DishType> types=dishService.getDishTypeList();
        map.put("types",types);
        return "dish/type.html";
    }

    @RequestMapping("dishSaveUI")
    public String dishSaveUi(ModelMap map, String id) {

            List<DishTaste> tastes = dishService.getDishTasteList();
            List<DishType> types=dishService.getDishTypeList();
            map.put("dishTastes",tastes);
            map.put("dishTypes",types);
        return "dish/saveDish.html";
    }
    @RequestMapping("saveDish")
    public String saveDish(Dish dish){
        dishService.addDish(dish);
        return "forward:first";
    }




    @RequestMapping("dishTasteSaveUI")
    public String dishTasteSaveUi(){
        return "/dish/saveTaste.html";
    }
    @RequestMapping("saveTaste")
    public String saveTaste(DishTaste dishTaste){
        if (dishTaste.getId().isEmpty()){
            dishService.addDishTaste(dishTaste);
        }else {
            dishService.editDishTaste(dishTaste);
        }
        return "forward:taste.html";
    }
    @RequestMapping("deleteTaste")
    public String deleteTaste(String id){
        dishService.delDishTaste(id);
        return "forward:taste.html";
    }
    @RequestMapping("dishTypeSaveUI")
    public String dishTypeSaveUi(){
        return "/dish/saveType.html";
    }
    @RequestMapping("saveType")
    public String saveType(DishType dishType){
        if (dishType.getId().isEmpty()){
            dishService.addDishType(dishType);
        }else {
            dishService.editDishType(dishType);
        }
        return "forward:type.html";
    }
    @RequestMapping("deleteType")
    public String deleteType(String id){
        dishService.delDishType(id);
        return "forward:type.html";
    }




}
