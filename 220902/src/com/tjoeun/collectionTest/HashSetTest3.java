package com.tjoeun.collectionTest;

import java.util.HashSet;

public class HashSetTest3 {
	
	public static void main(String[] args) {
		
		HashSet<Person> hset = new HashSet<>();
		
/*		Person person = new Person();
		System.out.println(person);
		Person person2 = new Person("홍길동", 20);
		System.out.println(person2);
		
		
		hset.add(person2);
		System.out.println(hset.size() + ":" + hset);
		// (hashcode가)같은 객체를 2번 이상 넣으면 중복되는 객체로 인식해서 저장하지 않는다.
*/		
		
		
		// new를 사용해서 객체를 생성하면 기존에 생성했던 객체와 내용이 같더라도 다른 hashcode가 부여
		// HashSet과 TreeSet은 중복되는 데이터 판단을 hashcode로 하기 때문에 내용이 같더라도 다른 hashcode를 가지면,
		// 내용이 같더라도 다른 객체로 취급해서 내용이 같은 객체가 저장
		// 저장된 내용이 같은 객체를 같은 객체로 인식하게 하려면 hashcode() 메소드를 Override해서,
		// 내용이 같은 객체는 같은 hashcode를 가지게 하면 된다.
		
		hset.add(new Person("홍길동", 20));
		System.out.println(hset.size() + ":" + hset);
		hset.add(new Person("홍길동", 20));
		System.out.println(hset.size() + ":" + hset);
		hset.add(new Person("홍길동", 35));
		System.out.println(hset.size() + ":" + hset);
		hset.add(new Person("홍길동", 27));
		System.out.println(hset.size() + ":" + hset);
		hset.add(new Person("임꺽정", 20));
		System.out.println(hset.size() + ":" + hset);
		hset.add(new Person("장길산", 54));
		System.out.println(hset.size() + ":" + hset);
		hset.add(new Person("일지매", 12));
		System.out.println(hset.size() + ":" + hset);
		
		
		
		
	}
}
