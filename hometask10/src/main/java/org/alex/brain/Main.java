package org.alex.brain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "test_String";
        System.out.println(str.length());
        System.out.println(str.split("_").length);
        System.out.println(str.substring(2));
        StringBuilder builder = new StringBuilder();
        builder.append("test_String");
        System.out.println(builder.reverse());
        Pattern pattern = Pattern.compile("^[А-ЯЁA-Z][а-яёa-z]+\\s[А-ЯЁA-Z][а-яёa-z]+$");
        Matcher matcher = pattern.matcher("Alex Kazak");
        System.out.println(matcher.matches());
        matcher = pattern.matcher("Alex kazak");
        System.out.println(matcher.matches());
        matcher = pattern.matcher("AlexKazak");
        System.out.println(matcher.matches());
    }
}
