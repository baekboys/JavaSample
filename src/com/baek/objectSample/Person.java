package com.baek.objectSample;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Person {
    @NonNull private Integer id;
    private String name;
    private int age;
    private String address;
    private String company;

    // 5~15개의 대문자 알파벳으로 난수문자 생성
    private static String getRandomName() {
        int nameSize = new Random().nextInt(10) + 5;
        String name = new Random().ints(nameSize, 65, 90).mapToObj(i -> Character.toString(i)).collect(Collectors.joining("."));
        return name;
    }

    public static Person getInstanceById(int id) {
        return Person.builder()
                .id(id)
                .name(getRandomName())
                .age(new Random().nextInt(100))
                .address("city_" + id)
                .company("company_" + id)
                .build();
    }

    public static Person getRandomInstanceById() {
        int number = new Random().nextInt(1000);
        return Person.builder()
                .id(number)
                .name(getRandomName())
                .age(new Random().nextInt(100))
                .address("city_" + number)
                .company("company_" + number)
                .build();
    }

    public static List<Person> getInstance(int size) {
        List<Person> personList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Person p = Person.builder()
                    .id(i)
                    .name(getRandomName())
                    .age(new Random().nextInt(100))
                    .address("city_" + i)
                    .company("company_" + i)
                    .build();
            personList.add(p);
        }
        return personList;
    }

    public static void main(String[] args) {

        List<Person> personList = Person.getInstance(10);
        personList.forEach(System.out::println);
    }
}
