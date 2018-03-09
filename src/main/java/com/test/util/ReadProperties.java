package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @ClassName: ReadProperties
 * @Description: 获取配置文件信息
 * @date: 2018年3月
 * @version: 1.0.0
 */
public class ReadProperties {

    /**
     * 根据key读取value
     *
     * @param filePath
     * @param keyWord
     * @return String
     */
    public static String getProperties(String filePath, String keyWord){
        Properties prop = new Properties();
        String value = null;
        try {
            InputStream inputStream = ReadProperties.class.getResourceAsStream(filePath);
            prop.load(inputStream);
            value = prop.getProperty(keyWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 读取配置文件
     *
     * @param filePath
     * @return String
     */
    public static Properties getProperties(String filePath){
        Properties prop = new Properties();
        try {
            InputStream inputStream = ReadProperties.class.getResourceAsStream(filePath);
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static void main(String[] args) {
        // 注意路径问题
//        String properties = getProperties("/datahub.properties", "accessId");
//        System.out.println("accessId = " + properties);

        Properties properties = getProperties("/datahub.properties");
        System.out.println("accessId = " + properties);
    }

}