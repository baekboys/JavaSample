package com.baek.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListSample {

    public static void main(String[] args) {
        // write your code here

        // 기본추가
        ArrayList<String> friends1 = new ArrayList<>();
        friends1.add("Peter");
        friends1.add("Paul");
        System.out.println(friends1);

        // 초기값 설정은 아래의 방식 외에는 없음
        ArrayList<String> friends2 = new ArrayList<>(List.of("Peter", "Paul"));

        // 요소 추가 및 제거
        friends2.remove(1); // 1번 인덱스 삭제
        friends2.add(0, "Paul"); // 0번 인덱스 앞에 추가

        // 요소 접근
        //String man = friends2.get(0);

        // 요소 변경
        friends2.set(0, "mary");

        // 요소의 개수
        //int size = friends2.size();

        // ArrayList 복사
        System.out.println("-------------------------------");
        ArrayList<String> copiedFriends2 = new ArrayList<>(friends2);
        System.out.println(copiedFriends2);

        // 배열로부터 ArrayList 복사
        System.out.println("-------------------------------");
        String[] names = {"baek", "test", "kwon"};
        ArrayList<String> copiedArrayName = new ArrayList<>(List.of(names));
        System.out.println(copiedArrayName);

        // ArrayList에서 배열로 복사
        System.out.println("-------------------------------");
        String[] nameList = copiedArrayName.toArray(new String[0]);
        System.out.println(Arrays.toString(nameList));

        // ArrayList 채우기
        System.out.println("-------------------------------");
        ArrayList<String> fillArrayList = new ArrayList<>(5);
        fillArrayList.add("fill1");
        fillArrayList.add("fill2");
        fillArrayList.add("fill3");
        Collections.fill(fillArrayList, "all fill");
        System.out.println(fillArrayList);

        // ArrayList 기본 정렬
        System.out.println("-------------------------------");
        ArrayList<String> friends3 = new ArrayList<>();
        friends3.add("Z");
        friends3.add("D");
        friends3.add("g");
        friends3.add("a");
        friends3.add("z");
        friends3.add("J");
        friends3.add("1");
        friends3.add("5");
        Collections.sort(friends3); // 정렬
        System.out.println(friends3);
        Collections.reverse(friends3); // 뒤집기
        System.out.println(friends3);
        Collections.shuffle(friends3); // 섞기
        System.out.println(friends3);
    }
}
