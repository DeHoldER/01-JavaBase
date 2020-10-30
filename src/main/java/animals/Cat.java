package ru.geekbrains.animals;

public class Cat extends Animal {
    private static int catCounter = 0;

    public Cat(String name, int age) {
        super(name, age);
        super.maxDistanceToRun = 200;
        super.maxDistanceToSwim = 0;
        catCounter++;
    }

    public static int getCatCounter() {
        return catCounter;
    }

}
