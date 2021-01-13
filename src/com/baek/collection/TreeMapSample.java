package com.baek.collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// 키값으로 정렬하며, 중복은 허용하지 않는 트리맵 컬렉션
public class TreeMapSample {
	public static void main(String[] ar){
		TreeMap<String, String> map = new TreeMap<>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("1", "one");
		map.put("2", "two");
		map.put("백", "빽");
		map.put("선", "썬");
		map.put("A", "a");
		map.put("B", "b");


		System.out.println("map = " + map);
		//	        map = {1=one, 2=two, A=a, B=b, a=A, b=B, 백=빽, 선=썬}

		Set<Map.Entry<String, String>> entries = map.entrySet();
		System.out.println("entries = " + entries);
		//	        map = {1=one, 2=two, A=a, B=b, a=A, b=B, 백=빽, 선=썬}

		for (Map.Entry<String, String> tempEntry : entries) {
			System.out.println(tempEntry.getKey() + " = " + tempEntry.getValue());
		}


		System.out.println("map.firstKey() = " + map.firstKey());
		//	        map.firstKey() = 1

		System.out.println("map.lastKey() = " + map.lastKey());
		//	        map.lastKey() = 선

		System.out.println("map.higherKey(\"A\") = " + map.higherKey("A"));
		//	        map.higherKey("A") = B

		System.out.println("map.lowerKey(\"A\") = " + map.lowerKey("A"));
		//	        map.lowerKey("A") = 2

		map.put("0", "zero");
		map.put("1", "new one");
		System.out.println(map);
	}

}