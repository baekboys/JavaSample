package com.baek.basic;

public class DynamicParamSample {

    // 가변 매개변수는 ㅁ반드시 메서드의 마지막 매개변수여야 한다. 가변 인수는 배열처럼 사용한다.
    public static double average(double first, double... values) {
        double sum = first;

        for (double v: values
             ) {
            sum += v;
        }

        return values.length == 0 ? first : sum / (1 + values.length);
    }

    public static void main(String[] args) {

        double result = DynamicParamSample.average(3, 4.5, -5, 0);
        System.out.println(result);
    }
}
