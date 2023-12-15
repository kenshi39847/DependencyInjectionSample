package com.example.demo.chapter03.aop;

import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

	@Before("execution(* com.example.demo.chapter03.used.*Greet.*(..))")
	public void beforeAdvice(JoinPoint joinpoint) {
		//分かりやすいように表示
		System.out.println("=====Before Advice=====");
		//日付表示
		System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
		//メソッド名を表示
		System.out.println(String.format("メソッド:%s", joinpoint.getSignature().getName()));
	}

	@After("execution(* com.example.demo.chapter03.used.*Greet.*(..))")
	public void afterAdvice(JoinPoint joinpoint) {
		//分かりやすいように表示
		System.out.println("=====After Advice=====");
		//日付表示
		System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
		//メソッド名を表示
		System.out.println(String.format("メソッド:%s", joinpoint.getSignature().getName()));
	}
}
