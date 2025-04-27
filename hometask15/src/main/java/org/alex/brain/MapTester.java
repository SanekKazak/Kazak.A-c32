package org.alex.brain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTester {
    public static void main(String[] args) {
        List<User> list = List.of(new User(1),
                new User(2),
                new User(3),
                new User(4));
        Map<Integer, User> users = new HashMap<>();
        for(User user : list){
            users.put(user.id, user);
        }

        String[] words = {"er123h","gersdffdfd","fe","awe"};
        Map<String, Integer> wordsId = new HashMap<>();
        for(String word : words){
            wordsId.put(word, word.length());
        }
    }
}
