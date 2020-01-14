package com.sheepfold.cg.config;

import com.sheepfold.cg.component.Phrase;
import com.sheepfold.cg.handler.PhraseHandler;

import java.util.List;

/**
 * Created by HarrySheep on 2020/1/14.
 */
public class HandlerConfig {

    // 初始化CommandHandler


    // 初始化PhraseHandler
    public static PhraseHandler initPhraseHandler(){
        List<Phrase> phraseList = ComponentConfig.initPhraseComponent();
        PhraseHandler phraseHandler = new PhraseHandler(phraseList)
        return null;
    }

    // 初始化SentenceHandler

    // 初始化WordHandler
}
