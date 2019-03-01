package com.yy.base.config.redis;


/**
 * Redis的相关常量类
 */
public class RedisPropertisKeyConstant {

    /**
     * 定义Redis的连接主机地址
     */
    public static final String BOOTBASE_KEY_REIDS_HOST="baseboot.redis.host";


    /**
     * 定义Redis相关的数据库角标号
     */
    public static final String BOOTBASE_KEY_REDIS_DATABASE="baseboot.redis.database";


    /**
     * 定义redis的端口号
     */
    public static final String BOOTBASE_KEY_REDIS_PORT="baseboot.redis.port";


    /**
     * 定义Redis登录的密码
     */
    public static final String BOOTBASE_KEY_REDIS_PASSWORD="baseboot.redis.password";


    /**
     * 定义连接Redis的超时时间
     */
    public static final String BOOTBASE_KEY_REDIS_TIMEOUT="baseboot.redis.timeout";

    /**
     * 定义用户池
     */
    public static final String BOOTBASE_KEY_REDIS_USERPOOL="bootbase.redis.userPool";


    /**
     * 定义用户池相关的参数操作
     */
    public static final String BOOTBASE_KEY_REDIS_MAXIDLE="bootbase.redis.maxIdel";


    public static final String BOOTBASE_KEY_REDIS_MINIDEL="bootbase.redis.minIdel";
    public static final String BOOTBASE_KEY_REDIS_MAXTOTAL="bootbase.redis.maxTotal";
    public static final String BOOTBASE_KEY_REDIS_MAXWAITMILLIS="bootbase.redis.maxWaitMillis";


    public static final String BOOTBASE_KEY_REDIS_MINEVICABLEIDELTIMEMILLIS="bootbase.redis.minEvictableIdleTimeMillis";
    public static final String BOOTBASE_KEY_REDIS_NUMTESTSPEREVICTIONNUN="bootbase.redis.numTestsPerEvictionRun";

    public static final String BOOTBASE_KEY_REDIS_TIMEBETWEENEVICTIONRUNMILLIS="bootbase.redis.timeBetweenEvictionRunsMillis";
    public static final String BOOTBASE_KEY_REDIS_TESTONBORROW="bootbase.redis.testOnBorrow";
    public static final String BOOTBASE_KEY_REDIS_TESTONRETURN="bootbase.redis.testOnReturn";
    public static final String BOOTBASE_KEY_REDIS_TESTWHILEIDEL="bootbase.redis.testWhileIdle";

}
