package com.tjoeun.genericTest;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
		ThreeDPrinterPowder powderPrinter = new ThreeDPrinterPowder();
		Powder powder = new Powder();
		powderPrinter.setMaterial(powder);
		System.out.println(powderPrinter.getMaterial());
		powder = powderPrinter.getMaterial();
		System.out.println("===========================");
		
		ThreeDPrinterPlastic plasticPrinter = new ThreeDPrinterPlastic();
		Plastic plastic = new Plastic();
		plasticPrinter.setMaterial(plastic);
		System.out.println(plasticPrinter.getMaterial());
		plastic = plasticPrinter.getMaterial();
		System.out.println("===========================");

		
		ThreeDPrinter threeDPrinter = new ThreeDPrinter();
		threeDPrinter.setMaterial(powder);
		System.out.println(threeDPrinter.getMaterial());
		// 자식 객체를 부모 객체에 넣을 때(upcasting)는 별다른 문제가 발생되지 않지만,
		// 부모 객체에 저장된 자식 객체를 자식 객체에 넣을 때(downcasting)는 반드시 형변환시켜서 넣어야 함
		powder = (Powder) threeDPrinter.getMaterial();
		
		threeDPrinter.setMaterial(plastic);
		System.out.println(threeDPrinter.getMaterial());
		plastic = (Plastic) threeDPrinter.getMaterial();
		System.out.println("===========================");
		
		
		// generic(일반화 프로그램)
		GenericPrinter<Powder> genericPrinter = new GenericPrinter<>();
		genericPrinter.setMaterial(powder);
		System.out.println(genericPrinter.getMaterial());
		powder = genericPrinter.getMaterial(); // 데이터 타입을 받기 때문에 형변화가 필요 없음
		
		GenericPrinter<Plastic> genericPrinter2 = new GenericPrinter<>();
		genericPrinter2.setMaterial(plastic);
		System.out.println(genericPrinter2.getMaterial());
		plastic = genericPrinter2.getMaterial();
		System.out.println("===========================");
		
		
		
		
	}
}
