package com.sheepfold.cg.handler;

import com.sheepfold.cg.component.AbstractComponent;

import java.util.List;

public class WordHandler extends AbstractHandler {

    // [食物]占位符
    // todo 多个食物处理
    private String foodNamePlaceHolder = "{FOOD_NAME}";

    // 食物名列表 需要初始化
    private List<String> foodNameList;

    // [餐厅]占位符
    private String restaurantNamePlaceHolder = "{RESTAURANT_NAME}";

    // 餐厅名 需要初始化
    private String restaurantName;

    public WordHandler(List<AbstractComponent> list, List<String> foodNameList, String restaurantName){
        super();

    }

    public WordHandler(List<AbstractComponent> list) {
        super(list);
    }

    // todo 解析全部食物名称
    private String resolveFoodNames(String content){
        return null;
    }

    private String resolveRestaurantName(String content){
        while(content.contains(restaurantNamePlaceHolder)){
            content = content.replace(restaurantNamePlaceHolder, restaurantName);
        }
        return content;
    }
}
