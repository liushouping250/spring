package org.example.aop.config;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 通知实现类
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/3 23:02
 */
@Aspect  //定义切面类
@Component
public class AspectAdvice {
    public static  final String EXE= "execution(public * org.example.aop.controller..*(..))";
    //前置操作
    @Before(value = EXE)
    public void beforeAspect(JoinPoint joinPoint){
        System.out.println("===前置操纵方法执行===");
        //处理请求参数
        Map<String, Object> param = new HashMap<>();
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramValues.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        System.out.println(param);
    }

    //后置操作
    @After(value = EXE)
    public void afterAspect(){
        System.out.println("===后置操纵方法执行===");
    }
    //后置最终执行方法
    @AfterReturning(value = EXE, returning = "result")
    public void afterReturnAspect(){
        System.out.println("===后置最终方法执行===");
    }



    //异常通知：目标方法抛出异常时执行的代码
    @AfterThrowing(value = EXE,throwing = "th")
    public void afterThrowing(JoinPoint joinPoint , Exception th){
        System.out.println("===========执行异常通知============");
    }







}
