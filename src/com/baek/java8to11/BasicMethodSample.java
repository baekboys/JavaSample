package com.baek.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class BasicMethodSample {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("baek");
        names.add("kwon");
        names.add("spring");
        names.add("java");

        // --------------------------------------------------------
        // forEach
        // : Consumer<T>를 사용
        // --------------------------------------------------------
        System.out.println("--------------------------------------");
        names.forEach(System.out::println);
        System.out.println("--------------------------------------");

        // --------------------------------------------------------
        // Spliterator
        // 반절로 나누어서 사용
        // : tryAdvance() Consumer<T>를 사용
        // --------------------------------------------------------
        Spliterator<String> stringSpliterator = names.spliterator();
        Spliterator<String> stringSpliterator1 = stringSpliterator.trySplit();
        while (stringSpliterator.tryAdvance(System.out::println));
        System.out.println("===================");
        while (stringSpliterator1.tryAdvance(System.out::println));


        /// --------------------------------------------------------
        // removeIf
        // : Predicate<T>를 사용
        // --------------------------------------------------------
        System.out.println("--------------------------------------");
        names.removeIf(s -> s.startsWith("j")); // j로 시작하는 문자열은 삭제
        System.out.println(names);
    }
}
