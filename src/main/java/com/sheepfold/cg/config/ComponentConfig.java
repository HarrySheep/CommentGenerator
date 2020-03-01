package com.sheepfold.cg.config;

import com.sheepfold.cg.component.Phrase;
import com.sheepfold.cg.component.Sentence;
import com.sheepfold.cg.component.Word;
import com.sheepfold.cg.util.FileUtil;
import com.sheepfold.cg.util.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HarrySheep on 2020/1/14.
 */
public class ComponentConfig {

    private final static String WORD_RESOURCES_PATH = ApplicationConfig.RESOURCES_PATH + "config/word";

    private final static String PHRASE_RESOURCES_PATH = ApplicationConfig.RESOURCES_PATH + "config/phrase";

    private final static String SENTENCE_RESOURCES_PATH = ApplicationConfig.RESOURCES_PATH + "config/sentence";


    // 初始化Word组件
    public static List<Word> initWordComponent(){
        // 遍历word组件配置 json转换
        List<File> files = FileUtil.readPath(WORD_RESOURCES_PATH);
        List<Word> wordList = new ArrayList<>();
        for (File file : files) {
            String s = null;
            try {
                s = FileUtil.readFileToString(file);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            //System.out.println(s);
            Word word = JsonUtil.getBean(s, Word.class);
            wordList.add(word);
        }
        return wordList;
    }

    // 初始化Phrase组件
    public static List<Phrase> initPhraseComponent(){
        // 遍历phrase组件配置 json转换
        List<File> files = FileUtil.readPath(PHRASE_RESOURCES_PATH);
        List<Phrase> phraseList = new ArrayList<>();
        for (File file : files) {
            String s = null;
            try {
                s = FileUtil.readFileToString(file);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            //System.out.println(s);
            Phrase phrase = JsonUtil.getBean(s, Phrase.class);
            phraseList.add(phrase);
        }
        return phraseList;
    }

    // 初始化Sentence组件
    public static List<Sentence> initSentenceComponent(){
        // 遍历sentence组件配置 json转换
        List<File> files = FileUtil.readPath(SENTENCE_RESOURCES_PATH);
        List<Sentence> sentenceList = new ArrayList<>();
        for (File file : files) {
            String s = null;
            try {
                s = FileUtil.readFileToString(file);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            //System.out.println(s);
            Sentence sentence = JsonUtil.getBean(s, Sentence.class);
            sentenceList.add(sentence);
        }
        return sentenceList;
    }
}
