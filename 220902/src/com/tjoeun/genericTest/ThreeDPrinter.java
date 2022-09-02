package com.tjoeun.genericTest;

// 재료로 powder와 plastic을 모두 사용하는 3D프린터, 겸용 프린터 => Object 사용
public class ThreeDPrinter {
	
	
	// 겸용 3D 프린터는 powder와 plastic을 모두 재료로 받을 수 있어야 하기 때문에,
	//  powder와 plastic의 부모 클래스는 Object이므로 
	private Object material;

	
	public Object getMaterial() {
		return material;
	}

	public void setMaterial(Object material) {
		this.material = material;
	}
	
	

}
