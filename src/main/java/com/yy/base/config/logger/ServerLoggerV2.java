package com.yy.base.config.logger;//package com.hailong.logger;
//
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.apache.commons.lang3.time.StopWatch;
//
//@Component
//@Aspect
//public class ServerLoggerV2 {
//
//
//    private Logger log= LoggerFactory.getLogger(ServerLoggerV2.class);
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    public void requestMapping() {
//    }
//
////    @Pointcut("execution(*.*(..))")
////    public void methodPointcut() {
////    }
//
//    @Around("requestMapping()")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//        StopWatch sw = new StopWatch();
//        String name = pjp.getSignature().getName();
//        log.info("around start target = {}, args = {}", pjp.getArgs(), pjp.getTarget());
//        try {
//            sw.start();
//            return pjp.proceed();
//        } finally {
//            sw.stop();
//            log.info("around end: " + sw.getStartTime() + " - " + name);
//        }
//    }
//
//    @Before("requestMapping()")
//    public void before(JoinPoint jp) throws Throwable {
//        log.info("before method {}", jp.getSignature().getName());
//    }
//    @AfterReturning("requestMapping()")
//    public void afterReturning(JoinPoint jp) throws Throwable {
//        log.info("afterReturning method {}", jp.getSignature().getName());
//    }
//    @AfterThrowing("requestMapping()")
//    public void afterThrowing(JoinPoint joinPoint) throws Throwable {
//        log.info("afterThrowing method is {}",joinPoint.getSignature().getName());
//    }
//    @After("requestMapping()")
//    public void after(JoinPoint joinPoint) {
//        log.info("after method {}", joinPoint.getSignature().getName());
//    }
//
//
//}
