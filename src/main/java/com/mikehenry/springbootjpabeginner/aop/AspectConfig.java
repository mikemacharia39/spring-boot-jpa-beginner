package com.mikehenry.springbootjpabeginner.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {

    Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    /**
     * Intercepting all methods before beginning of execution
     * @param joinPoint object of JoinPoint
     */
    @Before(value = "execution(* com.mikehenry.springbootjpabeginner.controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Inside beforeAdvice");
    }

    /**
     * Intercepting methods with one argument to support more than one argument write args(object1, object2) then
     * on your method add Object object1, Object object2
     * @param joinPoint object of JoinPoint
     */
//    @Before(value = "execution(* com.mikehenry.springbootjpabeginner.controller.*.*(..)) and args(object)")
//    public void beforeAdviceOneMethod(JoinPoint joinPoint, Object object) {
//        logger.info("Inside beforeAdvice. Request = " + object);
//    }

    /**
     * Intercepting all calls before returning result
     * @param joinPoint object of JoinPoint
     */
    @After(value = "execution(* com.mikehenry.springbootjpabeginner.controller.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("Inside beforeAdvice");
    }

    /**
     * Intercepting all calls after return of result by a controller
     * @param joinPoint object of JoinPoint
     */
    @AfterReturning(value = "execution(* com.mikehenry.springbootjpabeginner.controller.*.*(..))"
            , returning = "returningObject")
    public void afterReturningAdvice(JoinPoint joinPoint, Object returningObject) {
        logger.info("Inside AfterReturning. Response = " + returningObject);
    }

    /**
     * To intercept requests Before start of execution by a controller and After returning
     * @param proceedingJoinPoint Object of proceedingJoinPoint
     * @param object request object
     */
//    @Around(value = "execution(* com.mikehenry.springbootjpabeginner.controller.*.*(..)) and args(object)")
//    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Object object) {
//        logger.info("Before execution. Request = " + object);
//
//        Object returnedAdvice = null;
//
//        try {
//            returnedAdvice = proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        logger.info("After execution. Response = " + returnedAdvice);
//    }
}
