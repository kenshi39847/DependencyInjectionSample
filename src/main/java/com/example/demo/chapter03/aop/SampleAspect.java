package com.example.demo.chapter03.aop;

import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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

	@Around("execution(* com.example.demo.chapter03.used.*Greet.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		//分かりやすいように表示
		System.out.println("=====Around Advice=====");
		System.out.println("▼▼処理前▼▼");
		//指定したクラスの指定したメソッドを実行
		Object result = joinpoint.proceed();
		System.out.println("▲▲処理後▲▲");
		//戻り値を返す必要がある場合はObject型の戻り値で値を返す
		return result;
	}
}
