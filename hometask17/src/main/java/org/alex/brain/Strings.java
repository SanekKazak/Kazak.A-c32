package org.alex.brain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Strings {
    public static void main(String[] args) {
        List<String> list = List.of("gdf","hsdf","asda","gsdga","dgsdc","GSD","SDXHxc","ASD","sdcfg");
        //1) получить коллекцию чисел, каждой число которого - длинна строки исходной коллекции
        System.out.println(list.stream()
                .map(String::length)
                .collect(Collectors.toList())
        );
        //2) получить коллекцию строк где все элементы приведены к верхнему регистру
        System.out.println(list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
        );
        //3) получить коллекцию строк, в которой нет элементов с буквой "a"
        System.out.println(list.stream()
                //у меня здесь не хватило понимания чтобы использовать flatMap
                //не знал как отфильтровать потом основной список после того как он будет
                // приведен к .flatMap(u -> Arrays.stream(u.split(",")))
                .filter(u->Arrays.stream(u.split(","))
                        .map(String::toLowerCase)
                        .anyMatch(s->!s.contains("a")))
                .collect(Collectors.toList())
        );
    }
}
