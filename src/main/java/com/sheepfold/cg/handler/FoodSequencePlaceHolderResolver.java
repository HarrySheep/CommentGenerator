package com.sheepfold.cg.handler;

import java.util.List;

// 对于多个食物的处理能力
public interface FoodSequencePlaceHolderResolver {

     final String nFoodPlaceHolderPrefix = "{FOOD_N}";

     final String nFoodPlaceHolderSuffix = "{/FOOD_N}";

     // todo 和WordHandler的占位符定义重复 可以优化
     final String foodNamePlaceHolder = "{FOOD_NAME}";

     // 换行符
     final String enter = "\n";

    /**
     * 将content中的形如{FOOD_N}{component}{/FOOD_N}的字符串，
     * 解析成{FOOD_0}{component}{/FOOD_0}\n{FOOD_1}{component}{/FOOD_1} ..
     * 复制数量等于n （即传入食物的数量）
     * @param content
     * @param n
     * @return
     */
     default String resolveNFoodPlaceHolder(final String content,final int n){
         StringBuilder sb = new StringBuilder(content);
         while (sb.indexOf(nFoodPlaceHolderPrefix) != -1){ //按顺序处理N序列
             // 有前缀必定有后缀，否则抛出异常
             int indexOfPrefix = sb.indexOf(nFoodPlaceHolderPrefix);
             int indexOfSuffix = sb.indexOf(nFoodPlaceHolderSuffix);
             if(indexOfSuffix < 0 || indexOfSuffix <indexOfPrefix){
                 throw new IllegalArgumentException("食物N序列前缀后缀输入不规范！请检查！");
             }

             // 截取需要复制的(形如{FOOD_N}{component}{/FOOD_N}的字符串)字符串段
             int indexOfSuffixEnd = indexOfSuffix + nFoodPlaceHolderSuffix.length();
             final String prototype = sb.substring(indexOfPrefix, indexOfSuffixEnd);  //复制原型

             // 再次检查原型中是否还有夹杂不规范的序列占位符(无法解析）
             if(prototype.contains(nFoodPlaceHolderPrefix) || prototype.contains(nFoodPlaceHolderSuffix)){
                 // 暂时不支持嵌套输入 要递归啊
                 throw new IllegalArgumentException("食物N序列前缀后缀不可嵌套输入！会导致无法解析！请检查！");
             }

             // 删除复制原型
             sb.delete(indexOfPrefix, indexOfSuffixEnd);

             // 循环添加{FOOD_0}{component}{/FOOD_0} {FOOD_1}{component}{/FOOD_1} ..
             int indexOfConcat = indexOfPrefix; //接入字符串的index
             for(int i=0; i<n ; ++i){ //添加食物序列循环开始
                 String sequence = i + "";

                 // 替换前缀后缀占位符中的"N"为sequence
                 String sequencePrefix = nFoodPlaceHolderPrefix.replace("N", sequence);
                 String sequenceSuffix = nFoodPlaceHolderSuffix.replace("N", sequence);
                 String newStr = prototype.replace(nFoodPlaceHolderPrefix, sequencePrefix);
                 newStr = newStr.replace(nFoodPlaceHolderSuffix, sequenceSuffix);
                 newStr = newStr.concat(enter); // 每一个sentence结束增加换行符

                 // 拼接字符串
                 sb.insert(indexOfConcat, newStr);

                 // 刷新拼接的index
                 indexOfConcat += newStr.length();
             } //添加食物序列循环
         } //按顺序处理N序列 循环

         return sb.toString();
     }

    /**
     * 将content中的{FOOD_0}{component}{/FOOD_0} {FOOD_1}{component}{/FOOD_1} ..
     * 根据传入的foodNameList的食物排序，将{component}中的{FOOD_NAME}转换成具体的食物名称
     * 注意：方法只对{FOOD_?}占位符包裹的{component}做处理，对孤儿{FOOD_NAME}不做任何更改
     * @param content
     * @param foodNameList
     * @return
     */
     default String resolveFoodSequencePlaceHolder(final String content,final List<String> foodNameList) {
         StringBuilder sb = new StringBuilder(content);

         for (int i = 0; i < foodNameList.size(); i++) {
             String foodName = foodNameList.get(i);
             String sequence = i + "";

             // 替换前缀后缀占位符中的"N"为sequence
             String sequencePrefix = nFoodPlaceHolderPrefix.replace("N", sequence);
             String sequenceSuffix = nFoodPlaceHolderSuffix.replace("N", sequence);

             while (sb.indexOf(sequencePrefix) != -1) { //按顺序处理序列
                 // 有前缀必定有后缀，否则抛出异常
                 int indexOfPrefix = sb.indexOf(sequencePrefix);
                 int indexOfSuffix = sb.indexOf(sequenceSuffix);
                 int indexOfPrefixEnd = indexOfPrefix + sequencePrefix.length();
                 int indexOfSuffixEnd = indexOfSuffix + sequenceSuffix.length();
                 if (indexOfSuffix < 0 || indexOfSuffix < indexOfPrefix) {
                     throw new IllegalArgumentException("食物" + i + "序列前缀后缀输入不规范！请检查！");
                 }

                 // 如果有嵌套序列占位符，抛出异常（无法解析）
                 if (sb.indexOf(sequencePrefix, indexOfPrefix + 1) < indexOfSuffix) {
                     // 暂时不支持嵌套输入 要递归啊
                     throw new IllegalArgumentException("食物" + i + "序列前缀后缀不可嵌套输入！会导致无法解析！请检查！");
                 }

                 // 截取要修改的目标字符串
                 String targetStr = sb.substring(indexOfPrefixEnd, indexOfSuffix);

                 // 删除原串
                 sb.delete(indexOfPrefix, indexOfSuffixEnd);

                 // 解析targetStr中的{FOOD_NAME}占位符，替换成具体食物名称
                 while (targetStr.contains(foodNamePlaceHolder)) {
                     targetStr = targetStr.replace(foodNamePlaceHolder, foodName);
                 }

                 // 拼接字符串
                 sb.insert(indexOfPrefix, targetStr);
             }
         }

         // todo 需要在此处理孤儿{FOOD_NAME}?

         return sb.toString();
     }
}
