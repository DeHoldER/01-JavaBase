package ru.geekbrains.animals;

public class Dog extends Animal {
    private static int dogCounter = 0;

    public Dog(String name, int age) {
        super(name, age);
        super.maxDistanceToRun = 500;
        super.maxDistanceToSwim = 10;
        dogCounter++;
    }

    public static int dogCounter() {
        return dogCounter;
    }
}
