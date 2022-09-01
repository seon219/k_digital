package com.tjoeun.abstractClass; // 추상메소드 - upcasting_부모클래스에 자식클래스 대입

class Base {
	// package 접근 권한은 같은 package에서는 public처럼 사용되고 다른 package에서는 private처럼 사용
	String name; // 접근 권한을 생략하면 package 권한을 의미
	
	void say() {
		System.out.println(name +"님 안녕하세요.");
	}

}



class Sub extends Base {
	int age;

	@Override
	void say() {
		// TODO Auto-generated method stub
		// super.say(); // Base를 상속받기 때문에 Sub에서 실행해도 "~님 안녕하세요"가 나옴
		System.out.println(name + "님은 " + age + "살 입니다.");
	}
	
}



public class UpDownCastingTest {
	
	public static void main(String[] args) {
		
		// 부모 클래스 타입으로 부모 클래스 타입의 객체를 만들어 사용하면 아무 문제없이 처리 됨
		Base base = new Base();
		base.name = "홍길동";
		base.say();
		
		// 자식 클래스 타입으로 자식 클래스 타입의 객체를 만들어 사용하면 아무 문제없이 처리 됨
		Sub sub = new Sub();
		sub.name = "임꺽정";
		sub.age = 20;
		sub.say();
		System.out.println("==================================");
		
		// 결론 => 부모가 자식 클래스를 제어할 수 있지만, 자식클래스가 부모클래스를 제어할 수 없음
//		// 부모 클래스 타입에 자식 클래스 타입의 객체가 주소를 대입하면 아무런 문제없이 처리
//		Base b = new Sub(); // 정상 실행
//		// 자식 클래스 타입에 부모 클래스 타입의 객체가 주소를 대입하면 에러 발생 
//		Sub s = new Base(); // 오류
		
		// 부모 클래스 타입의 객체에 자식 클래스 타입의 객체가 생성된 주소 대입 => upcasting
		// downcasting은 부모클래스 타입으로 upcasting된 자식 클래스를 다시 자식 클래스 타입으로 변환
		Base b = sub;
		// b는 부모클래스 타입의 객체지만 자식 클래스 타입의 객체가 생성된 주소를 대입했으므로,
		// say() 메소드를 실행하면 부모클래스의 say()메소드가 아닌 자식클래스의 say()메소드가 실행
		b.say();
		System.out.println("==================================");
		
		
		// 자식클래스 타입에 부모 클래스 타입의 객체가 생성된 주소를 대입하면 에러가 발생되는데,
		// casting(형변환)시켜서 대입하면 대입은 가능. 문법적인 에러는 발생하지 않지만 프로그램 실행단계에서 오류 발생
//		Sub s = base;
//		Sub s = (Sub) base; //casting 시키면 문법적인 에러는 발생하지 않는다
		
		
		// instanceof 연산자는 객체가 instanceof 뒤에 지정한 클래스 타입으로 안전하게 형변환이 가능한지 검사
		if (sub instanceof Base) {
			System.out.println("Sub 클래스 타입이 객체는 Base 클래스 타입으로 형변환 가능");
			Base base2 = (Base) sub;
			base2.say();
		} else {
			System.out.println("Sub 클래스 타입이 객체는 Base 클래스 타입으로 형변환 불가능");
		}
		
		if (base instanceof Sub) {
			System.out.println("Base 클래스 타입이 객체는 Sub 클래스 타입으로 형변환 가능");
			Sub sub2 = (Sub) base;
			sub2.say();
		} else {
			System.out.println("Base 클래스 타입이 객체는 Sub 클래스 타입으로 형변환 불가능");
		}
		
		
		try {
			Sub sub2 = (Sub) base;
			sub2.say();
		} catch (ClassCastException e) {
			System.out.println("Base 클래스 타입이 객체는 Sub 클래스 타입으로 형변환 불가능");
		}
		System.out.println("==================================");
		
		
	}
	
}

