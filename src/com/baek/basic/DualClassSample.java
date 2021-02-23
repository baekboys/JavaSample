package com.baek.basic;

class ClassA {
    int m;

    public ClassA(int m) {
        this.m = m;
    }
}

class DualClassSample {

    public static void ChangeNumber(int a, ClassA classA) {
        a = 9;
        classA.m = 9;
    }

    public static void main(String[] args) {

        int a = 4;
        ClassA classA = new ClassA(5);


        DualClassSample.ChangeNumber(a, classA);

        System.out.println(a + ", " + classA.m);
    }
}
