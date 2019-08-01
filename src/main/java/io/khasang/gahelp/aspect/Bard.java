package io.khasang.gahelp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {
    @Pointcut("execution(* io.khasang.gahelp.service.imol.KnightServiceImpl.getAchievement(..))")
    public void serviceBefore(){

    }

    @Pointcut("execution(* io.khasang.gahelp.service.imol.KnightServiceImpl.getAchievement(..))")
    public void serviceReturning(){

    }



    @Before(value = "serviceBefore()")
    public void getSong(JoinPoint joinPoint){
        System.out.println("Abra Kadabra Uh!!!");
    }

    @Around("execution(* io.khasang.gahelp.service.imol.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
    public Object action(ProceedingJoinPoint joinPoint, String val) throws Throwable{
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeAfter = System.currentTimeMillis();

        System.err.println("lalalalalalalalalalal");
        System.err.println("Knight defeat an enemy " + val + " with " + (timeAfter - timeBefore) + " ms");
        return obj;
    }

    @After(value = "serviceBefore()")
    public void getRepairSword(){
        System.out.println("My sword is repaired!");
    }

    @AfterReturning(value = "serviceReturning()")
    public void getAfterReturn(){
        System.out.println("After Knight");
    }
}
