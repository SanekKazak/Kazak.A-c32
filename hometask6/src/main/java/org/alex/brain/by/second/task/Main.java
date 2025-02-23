package org.alex.brain.by.second.task;

import org.alex.brain.by.second.task.animals.Cat;
import org.alex.brain.by.second.task.animals.Dog;
import org.alex.brain.by.second.task.service.AnimalService;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        AnimalService animalService = new AnimalService();

        dog.setName("Dogie");
        cat.setName("Cattie");
        animalService.print(dog);
        animalService.print(cat);

    }
}
