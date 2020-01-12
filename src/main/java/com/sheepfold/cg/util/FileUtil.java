package com.sheepfold.cg.util;

import org.springframework.util.Assert;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileUtil {

    /**
     * 读取File转换为String
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static String readFileToString(File file) throws IOException {
        Assert.notNull(file, "file不能为空!");
        InputStream in = null;
        StringBuffer sb = new StringBuffer();

        if (file.isFile() && file.exists()) { //判断文件是否存在
            // 一次读多个字节
            byte[] tempBytes = new byte[1024];
            int byteRead = 0;
            in = new FileInputStream(file);
            // 读入多个字节到字节数组中，byteRead为一次读入的字节数
            while ((byteRead = in.read(tempBytes)) != -1) {
                String str = new String(tempBytes, 0, byteRead);
                sb.append(str);
            }
        } else {
            System.out.println("找不到指定的文件"+file.getAbsolutePath()+"，请确认文件路径是否正确");
        }

        return sb.toString();
    }

    /**
     * 读取File转换为String
     * @param fileName 绝对路径或相对路径
     * @return
     */
    public static String readFileToString(String fileName) throws IOException {
        return readFileToString(new File(fileName));
    }

    /**
     * 获取path下所有文件和目录
     * @param path
     * @return
     */
    public static List<File> readPath(String path){
        File file = new File(path);		//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        return Arrays.asList(fs);
    }

}
