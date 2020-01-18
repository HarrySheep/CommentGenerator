package com.sheepfold.cg.handler;

import com.sheepfold.cg.component.AbstractComponent;

import java.util.List;

public abstract class AbstractHandler implements FoodSequencePlaceHolderResolver {

    // 组件列表
    private List<AbstractComponent> componentList;

    public AbstractHandler(List<AbstractComponent> list){
        componentList = list;
    }

    public String resolve(String content){
        for (AbstractComponent component : componentList) {
            content = component.resolvePlaceHolder(content);
        }
        return content;
    }
}
