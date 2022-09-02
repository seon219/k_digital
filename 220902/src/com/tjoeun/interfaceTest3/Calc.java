package com.tjoeun.interfaceTest3;


// 인터페이스는 클래스나 프로그램이 제공하는 기능을 명시적으로 선언
// 일종의 클라이언트 코드와의 약속이며 클래스나 프로그램이 제공하는 명세역할
// 클라이언크 프로그램은 인터페이스에 선언된 메소드나 명세만 보고 이를 구현한 클래스를 사용할 수 있다.
// 인터페이스로 구현한 다양한 객체를 생성 => 다형성

public interface Calc {
	
	// 인터페이스는 필드 선언시 앞의 내용을 생략하면 public static final을 자동으로 붙여줌
	// 상수
	public static final double PI = 3.141592;
	int ERROR = -99999999;
	
	// 추상메소드
	public abstract int add(int num1, int num2); // 덧셈
	int sub(int num1, int num2); // 뺄셈
	int mul(int num1, int num2); // 곱셈
	int div(int num1, int num2); // 나눗셈
	
	// default 메소드 => JDK 8에서 추가
	// default 메소드는 구현부({} 블록)을 가지는 메소드로 default 예약어를 사용해서 선언
	// 인터페이스를 구현받는 클래스들에서 공통으로 사용할 수 있는 메소드로 상속 또는 구현 시 Override 가능
	default void description(int numner) {
		System.out.println("정수 계산기를 구현합니다.");
		myMethod(numner); // private 메소드
		}
	
	
	// static 메소드 => JDK 8에서 추가
	// static 메소드는 구현부({} 블록)을 가지는 메소드로 static 예약어를 사용해서 선언
	// 인터페이스 객체를 생성하지 않고, 인터페이스 이름에 "."을 찍어 실행할 수 있음.
	static int total(int[] arr) {
		int total = 0;
		for (int i : arr) {
			total += i;
		}
		myStaticMethod();
		return total;
	}
	
	
	// private 메소드 => JDK 9에서 추가
	// 인터페이스를 구현한 클래스에서 사용하거나 Override해서 사용할 수 없다.
	// 인터페이스의 내부의 default 메소드에서 사용하기 위해 구현하는 메소드
	private void myMethod(int number) {
		for (int i = 0; i < number; i++) {
			System.out.println("private method");
		}
	}
	
	
	
	// private static 메소드 => JDK 9에서 추가
	// 인터페이스를 구현한 클래스에서 사용하거나 Override해서 사용할 수 없다.
	// 인터페이스의 내부의 static 메소드에서 사용하기 위해 구현하는 메소드
	private static void myStaticMethod() {
		System.out.println("private static method");
	}
	
	
	
	
	
	
}
