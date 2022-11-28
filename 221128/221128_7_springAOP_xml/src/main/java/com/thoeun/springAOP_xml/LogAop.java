package com.thoeun.springAOP_xml;

// 공통 기능 메소드를 모아놓은 클래스
public class LogAop {
	
	// before
	public void before() {
		System.out.println("LogAop 클래스의 before() 메소드가 실행됨");
	}
	
	// after-returning
	public void afterReturning() {
		System.out.println("LogAop 클래스의 afterReturning() 메소드가 실행됨");
	}
	
	// after-throwing
	public void afterThrowing() {
		System.out.println("LogAop 클래스의 afterThrowing() 메소드가 실행됨");
	}
	
	// after
	// around

}
