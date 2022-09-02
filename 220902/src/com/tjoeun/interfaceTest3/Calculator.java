package com.tjoeun.interfaceTest3;

public abstract class Calculator implements Calc { // 오버라이드 안하면 추상메소드로 존재

	@Override
	public int add(int num1, int num2) {
		return  num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	
//	@Override
//	public void description(int numner) {
//		System.out.println("Calc 인터페이스의 dafault 메소드를 Calculator 클래스에서 Override 한 메소드");
//	}

	
	
}
