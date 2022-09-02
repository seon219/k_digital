package com.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest2 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hmap = new HashMap<>();
		
		
		hmap.put("apple", 1000);
		System.out.println(hmap.size() + ":" + hmap);
		hmap.put("banana", 3500);
		System.out.println(hmap.size() + ":" + hmap);
		hmap.put("orange", 2000);
		System.out.println(hmap.size() + ":" + hmap);
		hmap.put("melon", 20000);
		System.out.println(hmap.size() + ":" + hmap);
		hmap.put("water melon", 15000);
		System.out.println(hmap.size() + ":" + hmap);
		
		
		// keySet() 메소드는 HashMap에 저장된 데이터의 key만 얻어옴
		System.out.println(hmap.keySet());
		// values() 메소드는 HashMap에 저장된 데이터의 value만 얻어옴
		System.out.println(hmap.values());
		
		
		// HashMap에 저장된 데이터의 key만 얻어와서 ArrayList에 저장하기
		ArrayList<String> keylist = new ArrayList<>();
		for (String key : hmap.keySet()) {
			keylist.add(key);
		}
		System.out.println(keylist);

		
		// HashMap에 저장된 데이터의 value만 얻어와서 ArrayList에 저장하기
		ArrayList<Integer> valuelist = new ArrayList<>();
		for (Integer value : hmap.values()) {
			valuelist.add(value);
		}
		System.out.println(valuelist);
		
		
		// HashMap에 저장된 데이터의 key를 이용해서  value를 얻어와서 ArrayList에 저장하기
		ArrayList<Integer> valuelist2 = new ArrayList<>();
		for (String key : hmap.keySet()) {
			valuelist2.add(hmap.get(key));
		}
		System.out.println(valuelist2);
	}

}
