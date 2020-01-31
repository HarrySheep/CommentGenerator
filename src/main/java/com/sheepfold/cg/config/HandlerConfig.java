package com.sheepfold.cg.config;

import com.sheepfold.cg.component.Phrase;
import com.sheepfold.cg.component.Sentence;
import com.sheepfold.cg.component.Word;
import com.sheepfold.cg.handler.HandlerListExecutor;
import com.sheepfold.cg.handler.PhraseHandler;
import com.sheepfold.cg.handler.SentenceHandler;
import com.sheepfold.cg.handler.WordHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HarrySheep on 2020/1/14.
 */
public class HandlerConfig {

    // 初始化CommandHandler
    public static HandlerListExecutor initCommandHandler(List<String> foodNameList, String restaurantName){
        // 按顺序组装责任链，注意顺序！！！
        SentenceHandler sentenceHandler = initSentenceHandler();
        PhraseHandler phraseHandler = initPhraseHandler();
        WordHandler wordHandler = initWordHandler(foodNameList, restaurantName);

        List list = new ArrayList();
        list.add(sentenceHandler);
        list.add(phraseHandler);
        list.add(wordHandler);

        return new HandlerListExecutor(list);
    }

    // 初始化PhraseHandler
    public static PhraseHandler initPhraseHandler(){
        List<Phrase> phraseList = ComponentConfig.initPhraseComponent();
        PhraseHandler phraseHandler = new PhraseHandler(phraseList);
        return phraseHandler;
    }

    // 初始化SentenceHandler
    public static SentenceHandler initSentenceHandler(){
        List<Sentence> sentenceList = ComponentConfig.initSentenceComponent();
        SentenceHandler sentenceHandler = new SentenceHandler(sentenceList);
        return sentenceHandler;
    }

    // 初始化WordHandler
    public static WordHandler initWordHandler(List<String> foodNameList, String restaurantName){
        List<Word> wordList = ComponentConfig.initWordComponent();
        WordHandler wordHandler = new WordHandler(wordList, foodNameList, restaurantName);
        return wordHandler;
    }
}
