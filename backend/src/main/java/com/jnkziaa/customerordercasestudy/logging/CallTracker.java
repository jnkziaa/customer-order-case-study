package com.jnkziaa.customerordercasestudy.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class CallTracker {

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();
    @Pointcut("within(com..service.*) || within(com..repository.*)")
    public void logMethodPointCut(){

    }

    @Pointcut("within(com..controller.addProduct)")
    public void logAddProduct(){}

    @Around("logAddProduct()")
    public Object LoggingAddProduct(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Adding to product list");
        Object proceedType = proceedingJoinPoint.proceed();
        return proceedType;
    }

    @Around("logMethodPointCut()")
    public Object LoggingMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        //before
        LOGGER.info("Method Start : " + proceedingJoinPoint.getSignature().getName());
        Object proceedType = proceedingJoinPoint.proceed();

        //after
        LOGGER.info("Method Completed : " + proceedingJoinPoint.getSignature().getName() + " \n");

        return proceedType;
    }

}


