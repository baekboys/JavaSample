package com.baek.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CollectionSortByComparableSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// �⺻ inter ����
		{
			List<Integer> list = new ArrayList<Integer>();
			 
			list.add(5);
			list.add(10);
			list.add(1);
			list.add(52);
			list.add(23);
			 
			Collections.sort(list);
			
			for (Integer i : list) {
				System.out.println(i);
			}
			
			Collections.sort(list);
		}
		
		{
			List<Student> list = new ArrayList<Student>();
	        
			list.add(new Student("a", 5));
	        list.add(new Student("b", 10));
	        list.add(new Student("c", 1));
	        list.add(new Student("d", 52));
	        list.add(new Student("e", 23));
	        
	        Collections.sort(list);
	        
	        for (Student s : list) {
	            System.out.println(s.getScore());
	        }
		}
	}
}

class Student implements Comparable<Student> {
    String name;
    int score;
    
    public Student() {
        super();
    }
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }
    
    @Override
    public int compareTo(Student s) {
        if (this.score < s.getScore()) {
            return -1;
        } else if (this.score > s.getScore()) {
            return 1;
        }
        return 0;
    }
}
