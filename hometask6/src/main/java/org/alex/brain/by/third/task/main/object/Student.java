package org.alex.brain.by.third.task.main.object;

public class Student {
    private String name;
    private int age;
    private String group;

    public Student(String name, String group, int age) {
        this.age = age;
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

}
