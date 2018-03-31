package cn.ecomb.java8.streamDemo;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * flatMap
 *
 * @author zhouzhigang
 * @date 2017/12/25.
 */
public class Demo2 {

    public static void main(String[] args) {

        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());

        System.out.println(together);


        List<List<Integer>> t1 = Stream.of(asList(1,2), asList(3, 4)).collect(toList());

        List<String> t2 = t1.stream().flatMap(var1 -> var1.stream().map(var2 -> var2+"")).collect(toList());

        System.out.println(t2);

    }
}
