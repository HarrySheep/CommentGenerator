package com.sheepfold.cg.entity;

import lombok.Data;

import java.util.List;

@Data
public class Input {

    private String restaurantName;

    private List<String> foodNameList;

    private String template;
}
