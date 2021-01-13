package com.baek.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// 저장된 순서가 필요하며 중복허용하지 않는 셋 컬렉션
public class LinkedHashSetSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>(5);
		
		
		list.add("B");
		list.add("A");
		list.add("D");
		list.add("F");
		list.add("C");
		
		System.out.println(list);
		
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("B");
		set.add("B");
		set.add("B");
		set.add("B");
		set.add("A");
		set.add("D");
		set.add("F");
		set.add("C");
		
		System.out.println(set);
		
		for (String string : set) {
			System.out.println(string);
		}
		
	}

}
