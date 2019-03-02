package com.yy.base.config.redis;

import com.yy.base.config.base.ObtainAppliationPropertis;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis的相关的配置类
 */

public class RedisConfig extends ObtainAppliationPropertis{


    /**
     * 配置Redis的相关的配置类
     * @param config
     * @return
     */
    @Bean
    public JedisPool getjedisPool(JedisPoolConfig config) {

        String host=getStringOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REIDS_HOST,"127.0.0.1");
        Integer port=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_PORT,6379);

        Integer timeout=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_TIMEOUT,3600);

        String password=getStringOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_PASSWORD,"123456");

        Integer database=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_TIMEOUT,0);

        return new JedisPool(config,host,port,timeout, password, database,null);
    }




    @Bean
    public Jedis getJRedis(JedisPool jedisPool){
        return jedisPool.getResource();
    }



    @Bean
    public JedisPoolConfig getJedisPoolConfig () {
        JedisPoolConfig config = new JedisPoolConfig();


        //获取Redis连接池相关的配置信息
        Integer maxIdle=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_MAXIDLE,12);
        Integer minIdel = getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_MINIDEL, 5);
        Integer maxTotal=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_MAXTOTAL,100);
        Integer maxWaitMillis=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_MAXWAITMILLIS,3600);

        Integer minEvictableIdleTimeMillis=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_MINEVICABLEIDELTIMEMILLIS,3600);
        Integer numTestsPerEvictionRun=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_NUMTESTSPEREVICTIONNUN,3600);
        Integer timeBetweenEvictionRunsMillis=getIntOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_TIMEBETWEENEVICTIONRUNMILLIS,3600);
        Boolean testOnBorrow=getBooleanOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_TESTONBORROW,true);
        Boolean testOnReturn=getBooleanOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_TESTONRETURN,true);
        Boolean testWhileIdle=getBooleanOrDefault(RedisPropertisKeyConstant.BOOTBASE_KEY_REDIS_TESTWHILEIDEL,true);


        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);

        config.setEvictorShutdownTimeoutMillis(minEvictableIdleTimeMillis);
        config.setMinIdle(minIdel);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setTestWhileIdle(testWhileIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        config.setNumTestsPerEvictionRun(numTestsPerEvictionRun);

        return config;
    }




}
