package com.example.demoapollo.util;

import com.ctrip.framework.apollo.ConfigService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Apollo 配置的封装类，提供从配置中心获取相关数据的统一入口
 */
public final class ConfigUtils {

    private static final String EMPTY = "";
    private static final String APPLICATION = "application";

    /**
     * @param namespace 命名空间
     * @param key       获取的key
     * @return key 对应配置中心的值，如果没有配置，则返回空字符串
     */
    public static String getProperty(String namespace, String key) {
        return getProperty(namespace, key, EMPTY);
    }

    /**
     * @param namespace    命名空间
     * @param key          获取的key
     * @param defaultValue 如果配置中心未配置key时的默认值
     * @return key 对应配置中心的值，如果没有配置，则返回 @{code defaultValue}的值
     */
    public static String getProperty(String namespace, String key, String defaultValue) {
        String value = ConfigService.getConfig(namespace).getProperty(key, defaultValue);
        return value;
    }


    public static Map<String, Object> getALLPropertys(String namespace) {
        Set<String> propertyNames = ConfigService.getConfig(namespace).getPropertyNames();
        Map<String, Object> map = new HashMap<>();
        propertyNames.forEach((s) -> {
            map.put(s, getProperty(namespace, s));
        });
        return map;
    }


    /**
     * 获取 namespace 为 common-template 下的指定key
     *
     * @param key          获取的key
     * @param defaultValue 如果配置中心未配置key时的默认值
     * @return key 对应配置中心的值，如果没有配置，则返回 @{code defaultValue}的值
     */
    public static String getCommonProperty(String key, String defaultValue) {
        return getProperty("develop.spring-boot-http", key, defaultValue);
    }

    /**
     * 获取 namespace 为 exe.api.server 下的指定key
     *
     * @param key 获取的key
     * @return key 对应配置中心的值，如果没有配置，则返回空字符串
     */
    public static String getCommonProperty(String key) {
        return getCommonProperty(key, EMPTY);
    }

    /**
     * 获取 namespace 为 application 下的指定key
     *
     * @param key          获取的key
     * @param defaultValue 如果配置中心未配置key时的默认值
     * @return key 对应配置中心的值，如果没有配置，则返回 @{code defaultValue}的值
     */
    public static String getApplicationProperty(String key, String defaultValue) {
        return getProperty(APPLICATION, key, defaultValue);
    }

    /**
     * 获取 namespace 为 application 下的指定key
     *
     * @param key 获取的key
     * @return key 对应配置中心的值，如果没有配置，则返回空字符串
     */
    public static String getApplicationProperty(String key) {
        return getApplicationProperty(key, EMPTY);
    }


}
