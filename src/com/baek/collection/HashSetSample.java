package com.baek.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetSample {

    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("kiwi");
        System.out.println("fruits: " + fruits);

        // fruits: [banana, apple, kiwi]

        fruits.remove("apple");
        System.out.println("fruits: " + fruits);
        // fruits: [banana, kiwi]

        // removeIf (ba가 포함되어 있다면 제거)
        fruits.removeIf((s) -> s.contains("ba"));
        System.out.println("fruits: " + fruits);

        // HashSet을 Array로 변환
        fruits.add("grape");
        fruits.add("apple");
        fruits.add("dragon fruits");
        String[] array = new String[fruits.size()];
        fruits.toArray(array);

        System.out.println(Arrays.toString(array));

        // Array를 HashSet으로 변환
        String[] arrayWords = {"test","good", "baek"};
        Set<String> setWords = new HashSet<>();
        setWords.addAll(Arrays.asList(arrayWords));
        System.out.println("setWords: " + setWords);
    }
}
