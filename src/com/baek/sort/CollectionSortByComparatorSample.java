package com.baek.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CollectionSortByComparatorSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Student2> list = new ArrayList<Student2>();
        
        list.add(new Student2("a", 5));
        list.add(new Student2("b", 10));
        list.add(new Student2("c", 1));
        list.add(new Student2("d", 52));
        list.add(new Student2("e", 23));
        
        Collections.sort(list, new Comparator<Student2>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                if (s1.getScore() < s2.getScore()) {
                    return -1;
                } else if (s1.getScore() > s2.getScore()) {
                    return 1;
                }
                return 0;
            }
        });
 
        /*
         * ���
         * 1
         * 5
         * 10
         * 23
         * 52
         */
        
        for (Student2 s : list) {
            System.out.println(s.getScore());
        }
	}
}

class Student2 {
    String name;
    int score;
    
    public Student2() {
        super();
    }
    
    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }
}
