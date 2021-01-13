package com.baek.java8to11;

import java.util.function.*;

public class FunctionalInterfaceSample {
    public static void main(String[] args) {
        // ---------------------------------------------------------------
        // Function<T,R>
        // ---------------------------------------------------------------
        // Function : 1개의 타입을 받아서 1개를 리턴함
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i  * 2;

        // apply : 적용메소드
        System.out.println("plus10.apply(10) : " + plus10.apply(10)); // 결과 : 10 + 10 = 20

        // compose : apply전에 compose를 수행하도록 조합
        Function<Integer, Integer> multiply2AndPluse10 = plus10.compose(multiply2);
        System.out.println("plus10.compose(multiply2).apply(10) : " + plus10.compose(multiply2).apply(10)); // 결과 : (10 * 2) + 10 = 30
        System.out.println("multiply2AndPluse10.apply(10) : " + multiply2AndPluse10.apply(10)); // 결과 : 30

        // andThen : apply 후 andThen을 수행하도록 조합
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println("plus10.andThen(multiply2).apply(10) : " + plus10.andThen(multiply2).apply(10)); // 결과 : (10 + 10) * 2 = 40
        System.out.println("plus10AndMultiply2.apply(10) : " + plus10AndMultiply2.apply(10)); // 결과 : 40

        // ---------------------------------------------------------------
        // BiFunction<T,U,R>
        // ---------------------------------------------------------------
        // BiFunction : 2개의 타입을 받아서 1개를 리턴함, 그외에는 Function과 동일
        BiFunction<Integer, Integer, Integer> plus = (x,y) -> x + y;
        System.out.println("plus.apply(1,1) : " + plus.apply(1,1)); // 결과 : 1 + 1 = 2

        // ---------------------------------------------------------------
        // Consumer<T>
        // ---------------------------------------------------------------
        // Consumer : 1개의 타입을 받아서 리턴하지 않음.
        Consumer<Integer> plus10PrintT = (i) -> System.out.println("plus10PrintT : " + (i+10));
        plus10PrintT.accept(10); // 결과 : 10을 더하여 출력 => 20

        // ---------------------------------------------------------------
        // Supplier<T>
        // ---------------------------------------------------------------
        // Supplier : 타입을 받지 않고, 즉 입력값이 없고 값을 리턴
        Supplier<Integer> get10multiply10 = () -> 10 * 10;
        System.out.println("get10multiply10.get() : " + get10multiply10.get()); // 결과 : 내부에 구현된 10 * 10을 하여 100을 리턴

        // ---------------------------------------------------------------
        // Predicate<T>
        // ---------------------------------------------------------------
        // Predicate : 타입을 받아서 true or false를 리턴
        Predicate<String> startWithBaek = (s) -> s.startsWith("baek");
        Predicate<String> endWithSun = (s) -> s.endsWith("sun");
        System.out.println("startWithBaek.test(\"back\") : " + startWithBaek.test("back")); // 결과 : back는 baek로 시작하지 않으므로 false 리턴

        // negate : Predicate의 반대값을 리턴
        System.out.println("startWithBaek.negate().test(\"back\") : " + startWithBaek.negate().test("back") ); // 결과 : back는 baek로 시작하지 않지만 nagate이므로 true 리턴

        // and : and 조건
        System.out.println("startWithBaek.and(endWithSun).test(\"baekmyungsun\") : " + startWithBaek.and(endWithSun).test("baekmyungsun")); // 결과 : baekmyungsun은 baek로 시작하고 sun으로 끝나므로 true를 리턴
        System.out.println("startWithBaek.and(endWithSun).test(\"backmyungsun\") : " + startWithBaek.and(endWithSun).test("backmyungsun")); // 결과 : backmyungsun은 back로 시작하고 sun으로 끝나므로 false를 리턴

        // or : or 조건
        System.out.println("startWithBaek.or(endWithSun).test(\"baekmyungsoon\") : " + startWithBaek.or(endWithSun).test("baekmyungsoon")); // 결과 : baekmyungsoon은 baek로 시작하므로 true를 리턴
        System.out.println("startWithBaek.or(endWithSun).test(\"backmyungsun\") : " + startWithBaek.or(endWithSun).test("backmyungsun")); // 결과 : backmyungsundms은 sun으로 끝나므로 true를 리턴
        System.out.println("startWithBaek.or(endWithSun).test(\"backmyungsoon\") : " + startWithBaek.or(endWithSun).test("backmyungsoon")); // 결과 : backmyungsoon은  모두 일치하지 않으므로 false를 리턴

        // ---------------------------------------------------------------
        // UnaryOperator<T>
        // ---------------------------------------------------------------
        // UnaryOperator : 1개의 타입을 받아서 동일한 타입 1개를 리턴함, Function<T,T>와 동일
        UnaryOperator<Integer> plus10UnaryOperator = (x) -> x + 10;
        System.out.println("plus10UnaryOperator.apply(10) : " + plus10UnaryOperator.apply(10)); // 결과 : 10 + 10 = 20
    }
}
