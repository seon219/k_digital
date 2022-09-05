package com.tjoeun.genericTest2;

// <M extends 클래스>
// M 자료 형의 범위를 제안할 수 있고, 부모 클래사에서 선언하거나 정의된 메소드를 사용 가능
// 상속을 받지 않는 경우 M은 Object로 변환되어 Object 클래스가 기본으로 제공되는 메소드만 사용 가능

// GenericPrinter 클래스에 Material 클래스를 상속받아 구현하면 M에 무작위로 클래스가 들어갈 수 없게 한다.
// Material 클래스를 상속받은 클래스만 제네릭으로 GenericPrinter 클래스에 자료형을 넘겨줄 수 있음
public class GenericPrinter<M extends Material> {
	
	 
	private M material;

	
	public M getMaterial() {
		return material;
	}

	public void setMaterial(M material) {
		this.material = material;
	}
	
	

}
