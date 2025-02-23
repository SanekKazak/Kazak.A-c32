package org.alex.brain.by.second.task.service;

import org.alex.brain.by.second.task.animals.Cat;
import org.alex.brain.by.second.task.animals.Dog;

public class AnimalService {
    public void print(Dog dog){
        System.out.println(dog.getName());
    }
    public void print(Cat cat){
        System.out.println(cat.getName());
    }
}
