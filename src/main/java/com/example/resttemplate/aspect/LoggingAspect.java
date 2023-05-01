package com.example.resttemplate.aspect;

import com.example.resttemplate.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    /*
    * PointCut that matches all repositories, services andWeb REST endpoints
    * */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        //Method is empty as this is just a PointCut, the implementations are in the advices.
    }

    @After("springBeanPointcut()")
    public void afterEndpoints(JoinPoint joinPoint) {
        System.out.println("test log");
    }

    @Before("springBeanPointcut()")
    public void beforeEndpoints(JoinPoint joinPoint) {
        System.out.println("test log");
    }
}
