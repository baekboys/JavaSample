package com.baek.basic;

import java.math.BigInteger;
import java.util.Arrays;

public class ArraySample {

    public static void main(String[] args) {
        // write your code here
        
        // 아래는 같은 초기화 방식
        int[] primes1 = {2, 3, 5, 7, 11, 13};
        int[] primes2 = new int[]{23, 17, 19, 31, 29};

        // 객체는 기본적으로 null로 초기화
        String[] names = new String[20];
        BigInteger[] numbers = new BigInteger[10];

        // Array 정렬
        Arrays.sort(primes2);
        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(primes2));
        System.out.println("-------------------------------");

        // 기본적인 Array 복사
        System.out.println("-------------------------------");
        int[] copiedPrimes = Arrays.copyOf(primes1, primes1.length);
        System.out.println(Arrays.toString(copiedPrimes));

        // Array 채우기
        System.out.println("-------------------------------");
        int[] numbers2 = new int[5];
        Arrays.fill(numbers2, 0, 3, 5);
        System.out.println(Arrays.toString(numbers2));

        // 다차원 Array
        System.out.println("-------------------------------");
        int n = 3;
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        for (int[] row: triangle
             ) {
            for (int element: row
                 ) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }

        // 다차원배열 디버깅용 toString
        System.out.println(Arrays.deepToString(triangle));


    }
}
