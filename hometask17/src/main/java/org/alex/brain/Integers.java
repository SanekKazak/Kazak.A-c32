package org.alex.brain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Integers {
    public static void main(String[] args) {
        //1) вывести только четные
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 79, 79, 7, 0, 546, 7345, 234, 5, 2, 3423, 4234, 234);
        System.out.println(list.stream()
                .filter(a -> a%2==0)
                .collect(Collectors.toList())
        );
        //2) получить коллекцию без дубликатов (используя distinct)
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.toList())
        );
        //3) получить сумму всех чисел
        System.out.println(list
                .stream()
                .reduce(0, Integer::sum)
        );
        //4) получить максимальный элемент в коллекции
        Optional<Integer> max = list.stream()
                .max((u, u1) -> u-u1);
        if(max.isPresent()){
            //не понимаю почему здесь подчеркивает не ошибка, а предупреждение, пишет мол
            // According to hard-coded contract, method 'isPresent' returns 'true' when value of max != null
            System.out.println(
                    max.get()
            );
        }
        //5) найти первый элемент, который больше 10
        Optional<Integer> first = list.stream()
                .filter(u->u>10)
                .findFirst();
        if(first.isPresent()){
            System.out.println(
                    first.get()
            );
        }
        //6) определить все ли числа делятся на 10 без остатка
        Optional<Integer> ten= list.stream()
                .filter(u->u%10!=0  )
                .findFirst();
        System.out.println(
                ten.isEmpty()
        );
        //6) определить все ли числа делятся на 10 без остатка
        System.out.println(list.stream()
                .allMatch(u->u%10==0)
        );

    }
}
