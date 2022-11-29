package com.thoeun.springAOP_java;

import java.text.SimpleDateFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// 공통 기능 메소드를 모아놓은 클래스
// java 파일을 이용해서 AOP 설정을 하려면 AOP를 설정할 클래스에 @Aspect 어노테이션을 붙여준다.
@Aspect
public class LogAop {
	
	// pointcut을 지정하는 1번째 방법 => 빈 메소드를 이용해서 pointcut을 만든다.
	// 적당한 이름으로 빈 메소드를 만든 후 @Pointcut 어노테이션을 붙여서 인수에 pointcut을 지정한다.
	/*
		@Pointcut("within() 또는 execution()을 이용한 pointcut")
		public void 적당한이름() {
			메소드가 실행할 내용이 없는 빈 메소드
		}
	*/
	// pointcut 1개를 만들어서 여러 메소드에 적용시킬 수 있다.
	@Pointcut("within(com.thoeun.springAOP_java.Student)")
	public void pointcutMethod() {}
	
	
	// pointcut을 AOP 메소드에 적용하려면 AOP 어노테이션(@Before, @AFterReturning, @AfterThrowing, @After, @Around)의 
	// 인수로 pointcut을 설정한 메소드 이름을 넣어주면 된다.
	
	@Before("pointcutMethod()")
	public void before() {
		System.out.println("LogAop 클래스의 before() 메소드가 실행됨");
	}
	
	@AfterReturning("pointcutMethod()")
	public void afterReturning() {
		System.out.println("LogAop 클래스의 afterReturning() 메소드가 실행됨");
	}
	
	@AfterThrowing("pointcutMethod()")
	public void afterThrowing() {
		System.out.println("LogAop 클래스의 afterThrowing() 메소드가 실행됨");
	}
	
	@After("pointcutMethod()")
	public void after() {
		System.out.println("LogAop 클래스의 after() 메소드가 실행됨");
	}
	
		
	// pointcut을 지정하는 2번째 방법 => AOP 어노테이션의 인수로 바로 pointcut 지정 가능
	// AOP 메소드에 pointcut을 개별적으로 지정한다.
	@Around("execution(* com.thoeun.springAOP_java.W*.*())")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 핵심 기능이 실행되기 전 실행할 내용을 코딩한다.
		System.out.println("LogAop 클래스의 around() 메소드가 실행됨 - 핵심 기능 실행 전");
		// 핵심 기능이 실행되기 전 시간을 저장한다. => 시작시간
		long start = System.currentTimeMillis(); // 13자리 정수 => long
		
		try {
			
			// 핵심 기능을 실행한다.
			System.out.println("LogAop 클래스의 around() 메소드가 실행됨 - 핵심 기능 실행 중");
			// ProceedingJoinPoint 인터페이스 객체로 넘어온 핵심 기능을 실행하고 결과를 Object 클래스 객체에 저장해서 리턴
			Thread.sleep(2000);
			Object object = joinPoint.proceed(); // 핵심 기능을 실행한다.
			return object; // 핵심 기능 실행 결과를 리턴시킨다.
			
		} finally {
			
			// 핵심 기능이 실행되고 난 후 실행할 내용을 코딩한다.
			System.out.println("LogAop 클래스의 around() 메소드가 실행됨 - 핵심 기능 실행 후");
			// 핵심 기능이 실행되고 난 후 시간을 저장한다. => 종료시간
			long end = System.currentTimeMillis(); // 13자리 정수 => long
			System.out.println("핵심기능이 실행되는데 경과된 시간: " + (end - start)/1000. + "초");
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
			System.out.println("핵심기능이 실행되는데 경과된 시간: " + sdf.format(end - start - 32400000));
		}
		
	}
	
	
}
