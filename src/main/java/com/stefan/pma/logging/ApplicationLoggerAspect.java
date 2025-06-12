package com.stefan.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.stefan.pma.controllers..*)")
    public void definePackagePointcuts(){

    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp){

        log.debug("\n ");
        log.debug("***********Before Method Execution******** \n {}.{}() with arguments={}",
                jp.getSignature().getDeclaringType(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("________________________________________________________ \n  ");

        Object o = null;
        try {
            o = jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        log.debug("\n ");

        log.debug("***********After Method Execution******** \n {}.{}() with arguments={}",
                jp.getSignature().getDeclaringType(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("________________________________________________________ \n ");

        return o;
    }

//    @Before("definePackagePointcuts()")
//    public void logBefore(JoinPoint jp){
//
//        log.debug("\n ");
//        log.debug("***********Before Method Execution******** \n {{}.{}() with arguments={}",
//                jp.getSignature().getDeclaringType(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
//        log.debug("________________________________________________________ \n  ");
//    }
//
//    @After("definePackagePointcuts()")
//    public void logAfter(JoinPoint jp){
//
//        log.debug("\n \n \n");
//        log.debug("***********After Method Execution******** \n {}.{}() with arguments={}",
//                jp.getSignature().getDeclaringType(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
//        log.debug("________________________________________________________ \n ");
//    }




}
