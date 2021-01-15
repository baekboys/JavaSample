package com.baek.java8to11;

 interface InterfaceMethod {

    void printName();

    String getName();

     /**
      * @implSpec : name 값이 있도록 구현해야함
      * 구현된 객체들에게 동일한 기능 제공하는 default 메소드
      */
    default void printNameUppercase() {
        System.out.println(getName().toUpperCase());
    }

    // static 메소드 : 헬퍼역할로 주로 사용
    static void printAnything() {
        System.out.println("printAnything ~~!!");
    }
}

public class InterfaceMethodSample implements InterfaceMethod {

    private String name;

    public InterfaceMethodSample() {

    }

    public InterfaceMethodSample(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("printName : " + name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        InterfaceMethod interfaceMethod1 = new InterfaceMethodSample("baek");
        interfaceMethod1.printName();
        interfaceMethod1.printNameUppercase();

        // 주의사항 : 아래의 default 메소드인 printNameUppercase에는 name이 null이므로 예외 발생
        InterfaceMethod interfaceMethod2 = new InterfaceMethodSample();
        // interfaceMethod2.printNameUppercase();

        // static 메소드 사용
        InterfaceMethod.printAnything();
    }
}
