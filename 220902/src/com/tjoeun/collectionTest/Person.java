package com.tjoeun.collectionTest;

import java.util.Objects;

// Treeset에 저장할 클래스는 Comparable 인터페이스를 구현받고 compareTo() 메소드를 Override 한 후,
// 객체의 정렬 기준을 지정해야 한다.
// TreeSet 객체에 저장할 클래스에 구현한 Comparable 인터페이스의 제네릭에는 현재 클래스 이름을 넣는다.
public class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	public Person() { }// 기본생성자

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + "(" + age + ")";
	}

	
	// 객체를 HashSet, TreeSet 객체에 저장할 때 중복되는 내용을 가지는 객체가 저장되지 않게 하려면,
	// 객체끼리 비교를 해야 하므로 hashcode() 메소드와 equals()메소드를 Override 시켜야 함
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	
	@Override
	// compareTo 메소드는 자신(this)과 인수(Person o)로 넘어온 객체를 (add() 메소드의 인수로 지정한 객체)에 저장된 객체 비교한 결과 리턴
	public int compareTo(Person o) {
		
		// 비교할 데이터가 문자열일 경우, compareTo() 메소드는 자신이 크면1, 같으면0, 작으면 -1 리턴
		// 비교할 데이터가 숫자일 경우, "-" 연산을 실행해서 자신이 크면 양수, 같으면 0, 작으면 음수 리턴
//		return this.name.compareTo(o.name);// name 오름차순
//		return -this.name.compareTo(o.name);// name 내림차순
//		return this.age - o.age;// age 오름차순
//		return -(this.age - o.age);// age 내림차순
		
		
		//name을 기준으로 오름차순정렬(name이 같으면 age 내림차순 정렬)
		if (this.name.compareTo(o.name) == 0) {
			return -(this.age - o.age);
		} else {
		return this.name.compareTo(o.name);
		}
	}
	
	
	
	
}
