package com.baek.java8to11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceSample {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MethodReferenceSample(String name) {
        this.name = name;
    }

    public MethodReferenceSample() {

    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi~~" + name;
    }

    public static void main(String[] args) {

        // --------------------------------------------------------
        // static 메소드 레퍼런스
        // --------------------------------------------------------
        UnaryOperator<String> hi = MethodReferenceSample::hi;
        System.out.println(hi.apply("test"));

        // --------------------------------------------------------
        // 특정객체 메소드 레퍼런스
        // --------------------------------------------------------
        MethodReferenceSample methodReferenceSample = new MethodReferenceSample();
        UnaryOperator<String > hello = methodReferenceSample::hello;
        System.out.println(hello.apply("test"));

        // --------------------------------------------------------
        // 생성자 메소드 레퍼런스
        // --------------------------------------------------------
        Supplier<MethodReferenceSample> methodReferenceSampleSupplier = MethodReferenceSample::new;
        MethodReferenceSample newMethodReferenceSample1 = methodReferenceSampleSupplier.get();
        newMethodReferenceSample1.setName("newMethodReferenceSample1");
        System.out.println(newMethodReferenceSample1.getName());

        // --------------------------------------------------------
        // 생성자(파라미터) 메소드 레퍼런스
        // --------------------------------------------------------
        Function<String, MethodReferenceSample> methodReferenceSampleFunction = MethodReferenceSample::new;
        MethodReferenceSample newMethodReferenceSample2 = methodReferenceSampleFunction.apply("newMethodReferenceSample2");
        System.out.println(newMethodReferenceSample2.getName());

        // --------------------------------------------------------
        // 임의객체 메소드 레퍼런스
        // --------------------------------------------------------
        String[] names = {"cde", "abc", "123"};
        Arrays.sort(names, String::compareTo);
        System.out.println(Arrays.toString(names));
    }

}
