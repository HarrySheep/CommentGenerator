package com.sheepfold.cg.handler;

import java.util.List;

public class HandlerListExecutor {
    
    private List<? extends AbstractHandler> handlerList;

    public HandlerListExecutor(List<? extends AbstractHandler> handlerList) {
        this.handlerList = handlerList;
    }

    public String execute(String content){
        for (AbstractHandler handler : handlerList) {
            content = handler.execute(content);
        }

        return content;
    }
}
