package org.alex.brain;

import java.util.ArrayList;
import java.util.List;

public class CopyArrays {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 5, 2, 6, 7, 5, 2, 3, 4, 8, 10);
        List<Integer> changed = new ArrayList<>(list);
        for (Integer i : list){
            if(i%2 == 1){
                changed.remove(i);
            }
        }
        System.out.println(list + "" + changed);
    }
}
