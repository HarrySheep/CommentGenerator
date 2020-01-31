package com.sheepfold.cg;

import com.sheepfold.cg.api.CommentGenerator;
import com.sheepfold.cg.component.Word;
import com.sheepfold.cg.config.ApplicationConfig;
import com.sheepfold.cg.entity.Input;
import com.sheepfold.cg.util.FileUtil;
import com.sheepfold.cg.util.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Input input = ApplicationConfig.init();
        System.out.println(new CommentGenerator().generate(input.getRestaurantName(), input.getFoodNameList(), input.getTemplate()));
    }
}
