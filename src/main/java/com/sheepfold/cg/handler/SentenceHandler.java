package com.sheepfold.cg.handler;

import com.sheepfold.cg.component.AbstractComponent;
import com.sheepfold.cg.config.ApplicationConfig;

import java.util.List;

public class SentenceHandler extends AbstractHandler {
    public SentenceHandler(List<? extends AbstractComponent> componentList) {
        super(componentList);
    }

    @Override
    String execute(String content) {
        content = resolveNFoodPlaceHolder(content, ApplicationConfig.foodNum);
        return super.resolve(content);
    }
}
