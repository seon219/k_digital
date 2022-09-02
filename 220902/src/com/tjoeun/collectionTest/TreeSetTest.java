package com.tjoeun.collectionTest;

import java.util.TreeSet;
import java.util.Random;

public class TreeSetTest {

	public static void main(String[] args) {
		
		// TreeSet은 중복되는 데이터 입력을 허용하지 않는다.
		// 데이터를 입력하는 순서와 입력된 데이터가 실제로 저장되는 순서가 달라 get(), set() 메소드가 제공되지 않는다.
		// TreeSet은 HashSet과 다르게 입력되는 순서와 관계없이 오름차순으로 정렬되어 저장
		
		TreeSet<Integer> tset = new TreeSet<>();
		
		// add(value) 메소드는 TreeSet의 value를 저장
		tset.add(500);
		// size() 메소드는 TreeSet에 저장된 데이터 개수를 얻어옴
		System.out.println(tset.size() + ":" + tset);
		tset.add(100);
		System.out.println(tset.size() + ":" + tset);
		tset.add(999);
		System.out.println(tset.size() + ":" + tset);
		tset.add(50);
		System.out.println(tset.size() + ":" + tset);
		tset.add(500); // 중복되는 데이터는 저장되지 않는다.
		System.out.println(tset.size() + ":" + tset);
		
		
		// remove(value): 메소드는 TreeSet에 저장된 value를 제거
		tset.remove(500);
		System.out.println(tset.size() + ":" + tset);
		
		// clear() 메소드는 TreeSet에 저장된 모든 데이터를 제거
		tset.clear();
		System.out.println(tset.size() + ":" + tset);
		System.out.println("========================");
		
		
//		===================================================
		
		
		// 로또 1등 번호
		// 반복문돌리면서 랜덤 발생으로 저장되는 곳(Treeset)에 저장
		// 저장 size가 6이 되면 while break;
		Random random = new Random();
		
		while(true) {
			
			int lotto = random.nextInt(45) + 1;
			tset.add(lotto);
			
			
			if (tset.size() == 6) {
				break;
			}
			
		}
		System.out.println(tset);
		
		// 보너스 번호
		int bonus;
		while (true) {
			bonus = random.nextInt(45) + 1;
			
//			tset.add(bonus);
//			if (tset.size() == 7) {
//				break;
//			}
			// contains() 메소드는 TreeSet 객체에 인수로 지정된 데이터가 포함되어 있으면 true,
			// 그렇지 않으면 false 리턴			
			if (!tset.contains(bonus)) {
				break;
			}
		}
		tset.remove(bonus);
		System.out.println("보너스: " + bonus);
		
		System.out.println("1등 번호: " + tset + ", 보너스: " + bonus);
	}
}
