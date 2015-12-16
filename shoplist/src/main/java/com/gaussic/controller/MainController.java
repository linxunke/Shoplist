package com.gaussic.controller;

import com.gaussic.model.FoodEntity;
import com.gaussic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.lang.reflect.Method;
import java.util.List;
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    //homepage
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value="/shoplists",method=RequestMethod.GET)
    public String foods(ModelMap modelMap) {
        //find recordes
        List<FoodEntity> foodList = userRepository.findAll();
        //return to jsp
        modelMap.addAttribute("foodList", foodList);
        //return to shoplist.jsp
        return "shoplist";
    }
        // 添加用户 页面
        @RequestMapping(value = "/addFood", method = RequestMethod.GET)
        public String addFood() {
            return "addFood";
        }

// 添加用户 处理
        @RequestMapping(value = "/addFoodPost", method = RequestMethod.POST)
        public String addFoodPost(@ModelAttribute("food") FoodEntity foodEntity) {

            // 数据库中添加一个用户
            //userRepository.save(foodEntity);

            // 数据库中添加一个用户，并立即刷新
            userRepository.saveAndFlush(foodEntity);

            // 返回重定向 到 /foods 请求
            return "redirect:/shoplists";
        }

    // 查看用户详情
    @RequestMapping(value = "/showFood/{foodId}", method = RequestMethod.GET)
    public String showFood(@PathVariable("foodId") Integer foodId, ModelMap modelMap) {

        // 找到foodId所表示的用户
        FoodEntity foodEntity = userRepository.findOne(foodId);

        // 传递给请求页面
        modelMap.addAttribute("food", foodEntity);
        return "foodDetail";
    }

    @RequestMapping(value = "/updateFood/{foodId}", method = RequestMethod.GET)
    public String updateFood(@PathVariable("foodId") Integer foodId, ModelMap modelMap) {

        // 找到userId所表示的用户
        FoodEntity foodEntity = userRepository.findOne(foodId);

        // 传递给请求页面
        modelMap.addAttribute("food", foodEntity);
        return "updateFood";
    }
    // 处理用户修改请求
    @RequestMapping(value = "/updateFoodPost", method = RequestMethod.POST)
    public String updateFoodPost(@ModelAttribute("food") FoodEntity foodEntity){
        userRepository.updateFood(
                foodEntity.getFoodName(),
                foodEntity.getFoodNo(),
                foodEntity.getFoodId()
        );
        return "redirect:/shoplists";
    }
    // 删除用户
    @RequestMapping(value = "/deleteFood/{foodId}", method = RequestMethod.GET)
    public String deleteFood(@PathVariable("foodId") Integer foodId){
        // 删除id为foodId的用户
        userRepository.delete(foodId);
        // 立即刷新数据库
        userRepository.flush();
        return "redirect:/shoplists";
    }
}
