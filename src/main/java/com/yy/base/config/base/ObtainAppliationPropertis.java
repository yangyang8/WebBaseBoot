package com.yy.base.config.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 主要是获取SpringBoot的Application.propertis的相关配置类
 * 实现这个类下的相关的get或Set方法类
 */
public class ObtainAppliationPropertis implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    private Environment environment;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        this.environment=applicationContext.getEnvironment();
    }


    /**
     * 获取配置中的一个字符串值。如果给定的键不存在，会抛出 IllegalStateException 的异常
     *
     * @param key 配置键值
     * @return 相应的配置值
     */
    protected String getRequiredString(String key) {
        return environment.getRequiredProperty(key, String.class);
    }

    /**
     * 获取配置中的一个字符串值。如果给定的键不存在，则返回 defValue 参数指定的值
     *
     * @param key      配置键值
     * @param defValue 如果键对应的配置值不存在返回的默认值
     * @return 如果给定键对应的配置值存在，则返回配置值；否则返回 defValue 值
     */
    protected String getStringOrDefault(String key, String defValue) {
        return environment.getProperty(key, defValue);
    }

    /**
     * 获取配置文件当中用逗号间隔的多个属性
     *
     * @param key 配置键
     * @return 如果配置键对应的值不存在，则返回一个大小为 0 的空数组；如果配置值中值不存在逗号，则返回一个大小为 1 的字符串数组；其他情况下返回配置的数组
     */
    protected String[] getStringArrayOrEmpty(String key) {
        String value = environment.getProperty(key);
        if (value == null) {
            return new String[0];
        } else {
            if (!value.contains(",")) {
                return new String[]{value};
            } else {
                return value.split("\\,");
            }
        }
    }

    /**
     * 获取配置中的一个字符串值。如果给定的键不存在，会抛出 IllegalStateException 的异常
     *
     * @param key 配置键值
     * @return 相应的配置值
     */
    protected int getRequiredInt(String key) {
        return environment.getRequiredProperty(key, Integer.class);
    }

    /**
     * 获取配置中的一个字符串值。如果给定的键不存在，则返回 defValue 参数指定的值
     *
     * @param key      配置键值
     * @param defValue 如果键对应的配置值不存在返回的默认值
     * @return 如果给定键对应的配置值存在，则返回配置值；否则返回 defValue 值
     */
    protected int getIntOrDefault(String key, int defValue) {
        return environment.getProperty(key, Integer.class, defValue);
    }

    /**
     * 获取配置中的一个字符串值。如果给定的键不存在，会抛出 IllegalStateException 的异常
     *
     * @param key 配置键值
     * @return 相应的配置值
     */
    protected boolean getRequiredBoolean(String key) {
        return environment.getRequiredProperty(key, Boolean.class);
    }

    /**
     * 获取配置中的一个字符串值。如果给定的键不存在，则返回 defValue 参数指定的值
     *
     * @param key      配置键值
     * @param defValue 如果键对应的配置值不存在返回的默认值
     * @return 如果给定键对应的配置值存在，则返回配置值；否则返回 defValue 值
     */
    protected boolean getBooleanOrDefault(String key, boolean defValue) {
        return environment.getProperty(key, Boolean.class, defValue);
    }








}
