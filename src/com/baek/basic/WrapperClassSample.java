package com.baek.basic;

import java.util.ArrayList;

public class WrapperClassSample {
    public static void main(String[] args) {
        // 오토박싱이 이루어 짐
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        int first = numbers.get(0);

        numbers.add(42);
        numbers.add(32);

        // 값의 비교는 equal을 사용해야 함, == , != 연산자는 참조를 비교하기 때문
        if (numbers.get(0).equals(numbers.get(1))) {
            System.out.println("equals 같음!!!");
        }

        // 값의 비교는 equal을 사용해야 함, == , != 연산자는 참조를 비교하기 때문
        if (numbers.get(0) == numbers.get(1)) {
            System.out.println("== 같음!!!");
        } else {
            System.out.println("== 다름!!!");
        }
    }
}
