package com.sheepfold.cg.api;

import com.sheepfold.cg.config.HandlerConfig;
import com.sheepfold.cg.handler.HandlerListExecutor;

import java.util.List;

public class CommentGenerator {

    public String generate(String restaurantName, List<String> foodNameList, String template){
        HandlerListExecutor handlerListExecutor = HandlerConfig.initCommandHandler(foodNameList, restaurantName);
        String content = handlerListExecutor.execute(template);
        return content;
    }
}
