package com.sheepfold.cg.handler;

import com.sheepfold.cg.component.AbstractComponent;

import java.util.List;

public abstract class AbstractHandler implements FoodSequencePlaceHolderResolver {

    // 组件列表
    List<? extends AbstractComponent> componentList;

    public AbstractHandler(List<? extends AbstractComponent> componentList) {
        this.componentList = componentList;
    }

    public String resolve(String content){
        for (AbstractComponent component : componentList) {
            content = component.resolvePlaceHolder(content);
            content = component.resolveMultiplePlaceHolder(content);
        }
        return content;
    }

    abstract String execute(String content);
}
