package com.codegym.libraryapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAppAOP {
    private static int count = 0;

    @Pointcut("execution(* com.codegym.libraryapp.controller.BookAppController.*(..))")
    public void checkCount(){}

    @Before("checkCount()")
    public void countLog(JoinPoint joinPoint){

        System.out.println("Thao tác lần " + ++count + " vào lúc : " + LocalDateTime.now());

    }

    @Pointcut("execution(* com.codegym.libraryapp.controller.BookAppController.hireBook(..))")
    public void hireBook(){}

    @After("hireBook()")
    public void beforeController(JoinPoint joinPoint){
        System.out.println("Sách được mượn vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.libraryapp.controller.BookAppController.returnBook(..))")
    public void returnBook(){}

    @After("returnBook()")
    public void afterController(JoinPoint joinPoint){
        System.out.println("Sách được trả vào lúc : " + LocalDateTime.now());
    }

}
