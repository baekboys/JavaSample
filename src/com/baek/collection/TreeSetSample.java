package com.baek.collection;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetSample {

    public static void main(String[] args) {

        // 아래의 int배열을 중복제거하여 오름차순으로 정렬한 set
        int[] array = {1, 2, 4, 6, 7, 3, 7, 9, 4, 2, 4, 6};

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.addAll(Arrays.stream(array).boxed().collect(Collectors.toSet()));

        System.out.println("integerTreeSet : " + integerTreeSet);

        // 아래의 int배열을 중복제거하여 오름차순으로 정렬한 set
        String[] stringArray = {"abc", "bce", "abc", "ekrkd", "asdfkjas"};
        TreeSet<String> stringTreeSet = new TreeSet<>(Arrays.asList(stringArray));
        System.out.println("stringTreeSet : " + stringTreeSet);

    }
}
