package com.sheepfold.cg;

import com.sheepfold.cg.component.Word;
import com.sheepfold.cg.util.FileUtil;
import com.sheepfold.cg.util.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<File> files = FileUtil.readPath("src/main/resources/config/word");
        for (File file : files) {
            //System.out.println(file.toString());
            String s = FileUtil.readFileToString(file);
            System.out.println(s);
            Word exampleWord = JsonUtil.getBean(s, Word.class);
            System.out.println(exampleWord.getRandomOne());
        }

        //String s = FileUtil.readFileToString("src/main/resources/ExampleWord.json");
        //System.out.println(s);
//        Word exampleWord = JsonUtil.getBean(s, Word.class);
//        System.out.println(exampleWord.getRandomOne());
    }
}
