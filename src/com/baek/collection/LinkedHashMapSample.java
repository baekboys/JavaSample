package com.baek.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;

// 저장된 순서가 필요하며 키, 값 쌍으로 저장되며 키중복은 허용하지 않는 해시맵 컬렉션
public class LinkedHashMapSample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String,String> linkedHashMap  = new LinkedHashMap<String,String>();

		linkedHashMap.put("1", "a");
		linkedHashMap.put("3", "c");
		linkedHashMap.put("4", "d");
		linkedHashMap.put("5", "e");
		linkedHashMap.put("2", "b");
		linkedHashMap.put("5", "Z");
		
		System.out.println(linkedHashMap);
		
		for (Iterator<String> linkitr = linkedHashMap.values().iterator(); linkitr.hasNext();) {
			System.out.println(linkitr.next());
		}

		System.out.println("=================================");

		Iterator<String> keySetIterator = linkedHashMap.keySet().iterator();
		while (keySetIterator.hasNext()) {
		    String key = keySetIterator.next();
		    System.out.println("key: " + key + " value: " + linkedHashMap.get(key));
		}

		System.out.println("=================================");
		System.out.println("key 5 = " + linkedHashMap.get("5"));
	}
}
