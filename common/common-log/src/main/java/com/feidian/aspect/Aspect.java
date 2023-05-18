package com.feidian.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("execution(* com.feidian.service.*.*(..))")
    public void pt01(){

    }

    @Pointcut("execution(* com.feidian.service.*.*(..))")
    public void pt02(){

    }

    //    用Pointcut注解中的属性来指定对哪些方法进行增强
    @Pointcut("@annotation(com.feidian.aspect.TimeLog)")
    public void pt03(){

    }


    @Around(value = "pt03()")
    public Object around(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();//方法调用时传入的参数
        Object target = pjp.getTarget();//被代理对象
        MethodSignature signature = (MethodSignature) pjp.getSignature();//获取被被增强方法签名封装的对象
        Object ret = null;
        try {
            ret = pjp.proceed();//ret就是目标方法执行后的返回值
        } catch (Throwable throwable) {
            throwable.printStackTrace();//throwable就是出现异常时的异常对象
        }
        return ret;
    }


}
