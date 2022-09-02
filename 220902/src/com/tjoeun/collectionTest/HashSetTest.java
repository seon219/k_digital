package com.tjoeun.collectionTest;

import java.util.HashSet;
import java.util.Random;

public class HashSetTest {

	public static void main(String[] args) {
		
		// HashSet은 중복되는 데이터 입력을 허용하지 않는다.
		// 데이터를 입력하는 순서와 입력된 데이터가 실제로 저장되는 순서가 달라 get(), set() 메소드가 제공되지 않는다.
		
		HashSet<Integer> hset = new HashSet<>();
		
		// add(value) 메소드는 HashSet의 value를 저장
		hset.add(500);
		// size() 메소드는 HashSet에 저장된 데이터 개수를 얻어옴
		System.out.println(hset.size() + ":" + hset);
		hset.add(100);
		System.out.println(hset.size() + ":" + hset);
		hset.add(999);
		System.out.println(hset.size() + ":" + hset);
		hset.add(50);
		System.out.println(hset.size() + ":" + hset);
		hset.add(500); // 중복되는 데이터는 저장되지 않는다.
		System.out.println(hset.size() + ":" + hset);
		
		
		// remove(value): 메소드는 HashSet에 저장된 value를 제거
		hset.remove(500);
		System.out.println(hset.size() + ":" + hset);
		
		// clear() 메소드는 HashSet에 저장된 모든 데이터를 제거
		hset.clear();
		System.out.println(hset.size() + ":" + hset);
		System.out.println("========================");
		
		
//		===================================================
		
		
		// 로또 1등 번호
		// 반복문돌리면서 랜덤 발생으로 저장되는 곳(hashset)에 저장
		// 저장 size가 6이 되면 while break;
		Random random = new Random();
		
		while(true) {
			
			int lotto = random.nextInt(45) + 1;
			hset.add(lotto);
			
			
			if (hset.size() == 6) {
				break;
			}
			
		}
		System.out.println(hset);
		
		// 보너스 번호
		int bonus;
		while (true) {
			bonus = random.nextInt(45) + 1;
			
//			hset.add(bonus);
//			if (hset.size() == 7) {
//				break;
//			}
			// contains() 메소드는 HashSet 객체에 인수로 지정된 데이터가 포함되어 있으면 true,
			// 그렇지 않으면 false 리턴			
			if (!hset.contains(bonus)) {
				break;
			}
		}
		hset.remove(bonus);
		System.out.println("보너스: " + bonus);
		
		System.out.println("1등 번호: " + hset + ", 보너스: " + bonus);
	}
}
