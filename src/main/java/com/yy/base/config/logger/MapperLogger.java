package com.yy.base.config.logger;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MapperLogger {

    private Logger log= LoggerFactory.getLogger(MapperLogger.class);

    @Pointcut("@within(org.apache.ibatis.annotations.Mapper)")
    public void init(){}

    /**
     * 拦截这个方法执行之前的相关的操作
     */

    @Before("init()")
    public void executorBefore(){
        log.info("Mapper接口的方法开始执行...");
    }

    /**
     * 拦截这个方法之后
     */
    @After("init()")
    public void executorAfter(){
        log.info("Mapper接口的方法执行结束...");
    }


    /**
     * 拦截这个方法之后
     */
    @After("init()")
    public void executorReturn(){
        log.info("Mapper接口的方法返回...");
    }

}
