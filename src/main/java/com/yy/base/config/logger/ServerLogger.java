package com.yy.base.config.logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServerLogger {


    private Logger log= LoggerFactory.getLogger(ServerLogger.class);

    private ThreadLocal<TimeEntity> threadLocal=new ThreadLocal<TimeEntity>();

    @Pointcut("@within(org.springframework.stereotype.Service)")
    //@Pointcut("execution(public * *(..))")
    public void init() {
    }

//    @Pointcut("execution(*.*(..))")
//    public void methodPointcut() {
//    }

    @Around("@within(org.springframework.stereotype.Service))")
    public Object executor(ProceedingJoinPoint pjp) throws Throwable {

        String name = pjp.getSignature().getName();
        log.info("执行service业务 start target = {}, args = {}", pjp.getArgs(), pjp.getTarget());
        try {
            return pjp.proceed();
        } finally {

        }
    }


    @Before("@within(org.springframework.stereotype.Service)")
    public void before(JoinPoint jp) throws Throwable {
        Long startTime=System.currentTimeMillis();
        TimeEntity entity=new TimeEntity();
        entity.setStartTime(startTime);
        threadLocal.set(entity);

        log.info("===========================>"+jp.getSignature().getName()+"执行的开始时间:"+threadLocal.get().getStartTime());
    }

    @After("@within(org.springframework.stereotype.Service)")
    public void after(JoinPoint joinPoint) {
        long endTime=System.currentTimeMillis();

        TimeEntity entity=threadLocal.get();
        entity.setEndTime(endTime);

        log.info("===========================>"+joinPoint.getSignature().getName()+"执行的结束时间:"+entity.getEndTime());
    }


    @AfterReturning("@within(org.springframework.stereotype.Service)")
    public void executorEnd(JoinPoint joinPoint) {
        //long endTime=System.currentTimeMillis();
        TimeEntity entity=threadLocal.get();
        log.info("===========================>"+joinPoint.getSignature().getName()+"执行的总时长为:"+(entity.getEndTime()-entity.getStartTime()));
    }

}
