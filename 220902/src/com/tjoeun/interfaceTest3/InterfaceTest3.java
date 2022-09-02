package com.tjoeun.interfaceTest3;

public class InterfaceTest3 {

	public static void main(String[] args) {
		
		Calc calc = new CompleteCalc();
		int num1 = 10;
		int num2 = 2;
		
		System.out.printf("%d + %d = %d\n", num1, num2, calc.add(num1, num2));
		System.out.printf("%d - %d = %d\n", num1, num2, calc.sub(num1, num2));
		System.out.printf("%d * %d = %d\n", num1, num2, calc.mul(num1, num2));
		System.out.printf("%d / %d = %d\n", num1, num2, calc.div(num1, num2));
	
		
		// Calc 인터페이스에서 정의한 default 메소드 실행
		calc.description(5);
		
		// Calc 인터페이스에서 정의한 static 메소드 실행
		int arr[] = {1, 2, 3, 4, 5};
		int sum = Calc.total(arr);
		System.out.println("sum: " + sum);
	}
}
