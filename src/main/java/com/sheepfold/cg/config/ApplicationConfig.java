package com.sheepfold.cg.config;

import com.sheepfold.cg.entity.Input;
import com.sheepfold.cg.util.FileUtil;
import com.sheepfold.cg.util.JsonUtil;

import java.io.IOException;

public class ApplicationConfig {

    public final static String RESOURCES_PATH = "src/main/resources/";

    public final static String INPUT_PATH = "src/main/resources/input.json";

    public final static String TEMPLATE_PATH = "src/main/resources/template.txt";

    // todo 这里没写好 耦合了 迟点再优化
    public static int foodNum;

    // 读取输入、模版
    public final static Input init(){

        String inputString = null;
        try {
            inputString = FileUtil.readFileToString(INPUT_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        Input input = JsonUtil.getBean(inputString, Input.class);

        String templateString = null;
        try {
            templateString = FileUtil.readFileToString(TEMPLATE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        input.setTemplate(templateString);

        foodNum = input.getFoodNameList().size();

        return input;
    }
}
