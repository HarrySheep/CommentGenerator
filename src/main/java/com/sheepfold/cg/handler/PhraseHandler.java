package com.sheepfold.cg.handler;

import com.sheepfold.cg.component.AbstractComponent;
import com.sheepfold.cg.component.Phrase;
import com.sheepfold.cg.config.ApplicationConfig;

import java.util.List;

public class PhraseHandler extends AbstractHandler {

    public PhraseHandler(List<? extends AbstractComponent> componentList) {
        super(componentList);
    }

    @Override
    String execute(String content) {
        // 暂时不处理<n>的phrase
        // content = resolveNFoodPlaceHolder(content, ApplicationConfig.foodNum);
        return super.resolve(content);
    }

}
