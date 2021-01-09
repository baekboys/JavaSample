package com.baek.basic;

import java.util.ArrayList;

public class ForLoopSample {
    public static void main(String[] args) {
        ArrayList<String> friends1 = new ArrayList<>();
        friends1.add("Peter");
        friends1.add("Paul");

        for (String name: friends1
             ) {
            System.out.println(name);
        }
    }
}
