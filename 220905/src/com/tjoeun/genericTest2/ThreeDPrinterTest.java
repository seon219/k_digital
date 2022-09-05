package com.tjoeun.genericTest2;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
		
		// generic(일반화 프로그램)
		GenericPrinter<Powder> genericPrinter = new GenericPrinter<>();
		genericPrinter.setMaterial(new Powder());
		System.out.println(genericPrinter.getMaterial());
		Powder powder = genericPrinter.getMaterial(); // 데이터 타입을 받기 때문에 형변화가 필요 없음
		
		GenericPrinter<Plastic> genericPrinter2 = new GenericPrinter<>();
		genericPrinter2.setMaterial(new Plastic());
		System.out.println(genericPrinter2.getMaterial());
		Plastic plastic = genericPrinter2.getMaterial();
		System.out.println("===========================");
		
		// Mater 클래스는 Material 클래스를 상속받지 않았으므로 GenericPrinter 클래스의 제너릭으로 넘길 수 없다.
		// GenericPrinter<Water> waterPrinter = new GenericPrinter<>(); // 에러발생
		
		
		
	}
}
