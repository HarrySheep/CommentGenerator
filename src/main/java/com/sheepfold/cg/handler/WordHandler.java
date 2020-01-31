package com.sheepfold.cg.handler;

import com.sheepfold.cg.component.AbstractComponent;

import java.util.List;

public class WordHandler extends AbstractHandler {

    // [食物]占位符
    private String foodNamePlaceHolder = "{FOOD_NAME}";

    // 食物名列表 需要初始化
    private List<String> foodNameList;

    // [餐厅]占位符
    private String restaurantNamePlaceHolder = "{RESTAURANT_NAME}";

    // 餐厅名 需要初始化
    private String restaurantName;


    public WordHandler(List<? extends AbstractComponent> componentList, List<String> foodNameList, String restaurantName)
    {
        super(componentList);
        this.foodNameList = foodNameList;
        this.restaurantName = restaurantName;
    }

    private String resolveRestaurantName(String content){
        while(content.contains(restaurantNamePlaceHolder)){
            content = content.replace(restaurantNamePlaceHolder, restaurantName);
        }
        return content;
    }

    @Override
    String execute(String content) {
        // 暂时不处理<n>的word
        // content = resolveNFoodPlaceHolder(content, ApplicationConfig.foodNum);
        content = super.resolve(content);

        // 处理餐厅名字
        content = resolveRestaurantName(content);

        // 处理食物名字
        content = resolveFoodSequencePlaceHolder(content, foodNameList);

        return content;
    }
}
