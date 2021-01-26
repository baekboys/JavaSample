package com.baek.java8to11;

import com.baek.objectSample.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamSample {
    public static void main(String[] args) {

        /**************************************************************************
         *
         *  스트림 생성
         *
         **************************************************************************/

        // --------------------------------------------------------
        // 배열 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 배열 스트림 생성");
            System.out.println("// --------------------------------------------------------");
            String[] arr = new String[]{"a", "b", "c"};
            Stream<String> stream = Arrays.stream(arr);
            Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // 1~2 요소 [b, c]

            stream.forEach(System.out::println);
            streamOfArrayPart.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // 컬렉션 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 컬렉션 스트림 생성");
            System.out.println("// --------------------------------------------------------");
            List<String> list = Arrays.asList("a", "b", "c");
            Stream<String> stream = list.stream();
            stream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // 컬렉션(병렬) 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 컬렉션(병렬) 스트림 생성");
            System.out.println("// --------------------------------------------------------");
            List<Person> stream = Person.getInstance(10);
            Stream<Person> parallelStream = stream.parallelStream(); // 병렬 처리 스트림
            parallelStream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // 빌더를 이용한 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 빌더를 이용한 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            Stream<Person> personbuilderStream = Stream.<Person>builder()
                    .add(Person.getInstanceById(1))
                    .add(Person.getInstanceById(2))
                    .add(Person.getInstanceById(3))
                    .build();
            personbuilderStream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // generate를 이용한 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// generate를 이용한 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            // 랜덤한 3개의 Person 객체 생성
            Stream<Person> generatedStream = Stream.generate(() -> Person.getRandomInstanceById()).limit(3); // 무한하기때문에 제한을 줘야 함
            generatedStream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // iterate를 이용한 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// iterate를 이용한 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            // id가 5부터 시작해서 2까지 4개의 Person 객체 생성 (즉 요소가 다음 요소의 인풋으로 들어감)
            Stream<Person> iteratedStream = Stream.iterate(Person.getInstanceById(5), p -> Person.getInstanceById(p.getId() -1 )).limit(4); // 5, 4, 3, 2 id값을 가진 Person객체 생성
            iteratedStream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // 기본 타입형 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 기본 타입형 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]  => 마지막 미포함
            LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5] => 마지막 포함

            // 박싱이 필요할때
            Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
            boxedIntStream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // 난수를 이용한 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 난수를 이용한 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            // 난수발생하여 스트림으로 생성
            IntStream randomIntStream = new Random().ints(5, 1, 10); // 1~10 사이의 난수 5개 생성
            randomIntStream.forEach(System.out::println);
        }

        // --------------------------------------------------------
        // 문자열 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 문자열 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            IntStream charsStream = "Stream".chars(); // [83, 116, 114, 101, 97, 109]
            charsStream.forEach(System.out::println);
            System.out.println( Arrays.toString("baek".chars().toArray()));
        }

        // --------------------------------------------------------
        // 문자열 스트림 생성
        // --------------------------------------------------------
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 문자열 스트림 생성");
            System.out.println("// --------------------------------------------------------");

            IntStream charsStream = "Stream".chars(); // [83, 116, 114, 101, 97, 109]
            charsStream.forEach(System.out::println);
            System.out.println( Arrays.toString("baek".chars().toArray()));
        }

        /**************************************************************************
         *
         *  스트림 연결
         *
         **************************************************************************/
        {
            System.out.println("// --------------------------------------------------------");
            System.out.println("// 스트림 연결");
            System.out.println("// --------------------------------------------------------");

            Stream<Person> iteratedStream1to5 = Stream.iterate(Person.getInstanceById(1), p -> Person.getInstanceById(p.getId()+1 )).limit(5); // 1~5 id값을 가진 Person객체 생성
            Stream<Person> iteratedStream6to10 = Stream.iterate(Person.getInstanceById(6), p -> Person.getInstanceById(p.getId()+1 )).limit(5); // 6~10 id값을 가진 Person객체 생성

            // 2개의 스트림을 연결
            Stream<Person> iteratedStream1to10 = Stream.concat(iteratedStream1to5, iteratedStream6to10);
            iteratedStream1to10.forEach(System.out::println);
        }
    }
}
