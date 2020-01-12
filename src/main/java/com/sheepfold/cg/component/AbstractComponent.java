package com.sheepfold.cg.component;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

@Getter
@Setter
public abstract class AbstractComponent {

    // 组件内容列表
    private List<String> list;

    // 组件名称
    private String name;

    // 占位符定义
    private String placeHolder;

    // 获取任一内容后，是否需要删除，默认不删除（可重复）
    Boolean needDelete = false;

    /**
     * 返回组件内容中的任意一项
     * @return
     */
    public String getRandomOne(){
        int size = list.size();
        int i = RandomUtils.nextInt(0, size);
        return list.get(i);
    }

    /**
     * 返回组件内容中的任意一项，并删除该项，防止之后重复获取
     * @return
     */
    public String getRandomOneAndDelete(){
        int size = list.size();
        int i = RandomUtils.nextInt(0, size);
        String result =  list.get(i);
        list.remove(i);
        return result;
    }

    /**
     * 解析content中的占位符，转换为list中的任一内容
     * @param content
     * @return
     */
    public String resolvePlaceHolder(String content){
        while(content.contains(placeHolder)){
            String replaceStr = needDelete? getRandomOneAndDelete() : getRandomOne();
            content = content.replace(placeHolder, replaceStr);
        }
        return content;
    }
}
