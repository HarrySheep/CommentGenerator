package com.sheepfold.cg.component;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

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

    /*********************               多重占位符定义start             *******************/
    // 多重占位符定义 处理的时候会随机选取多个词语，并用[MULTIPLE_SEPARATOR]分隔
    private String multiplePlaceHolder;

    // 多重占位符分隔符
    private String MULTIPLE_SEPARATOR = ",";

    // 多重随机最小数量
    private Integer MULTIPLE_MINIMUM = 2;

    // 多重随机最大数量
    private Integer MULTIPLE_MAXIMUM = 4;

    /*********************               多重占位符定义end             *******************/

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

    /**
     * 解析content中的多重占位符，并用[MULTIPLE_SEPARATOR]分隔
     * @param content
     * @return
     */
    public String resolveMultiplePlaceHolder(String content){

        // 如果该组件没有配置多重占位符，直接结束
        if(StringUtils.isBlank(multiplePlaceHolder)){
            return content;
        }

        // 组装一个多重环境形容词短语(1~2个形容词为佳)
        while(content.contains(multiplePlaceHolder)) {
            int i = RandomUtils.nextInt(MULTIPLE_MINIMUM, MULTIPLE_MAXIMUM);
            StringBuilder sb = new StringBuilder("");
            while (i-- != 0) {
                String replaceStr = needDelete ? getRandomOneAndDelete() : getRandomOne();
                sb.append(replaceStr);
                if (i != 0) {
                    sb.append(MULTIPLE_SEPARATOR);
                }
            }
            content = content.replace(multiplePlaceHolder, sb.toString());
        }

        return content;
    }
}
