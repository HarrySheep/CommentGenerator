package com.sheepfold.cg.config;

import com.sheepfold.cg.component.Phrase;
import com.sheepfold.cg.component.Sentence;
import com.sheepfold.cg.component.Word;
import com.sheepfold.cg.handler.CommandHandler;
import com.sheepfold.cg.handler.PhraseHandler;
import com.sheepfold.cg.handler.SentenceHandler;
import com.sheepfold.cg.handler.WordHandler;

import java.util.List;

/**
 * Created by HarrySheep on 2020/1/14.
 */
public class HandlerConfig {

    // 初始化CommandHandler
    public static CommandHandler initCommandHandler(){
        return null;
        // 返回责任链队头??
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
    public static WordHandler initSentenceHandler(List<String> foodNameList, String restaurantName){
        List<Word> wordList = ComponentConfig.initWordComponent();
        WordHandler wordHandler = new WordHandler(wordList, foodNameList, restaurantName);
        return wordHandler;
    }
}
