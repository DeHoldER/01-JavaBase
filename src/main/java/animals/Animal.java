package ru.geekbrains.animals;

public class Animal {
    protected String name;
    protected int age;
    protected int maxDistanceToRun;
    protected int maxDistanceToSwim;
    protected String className = this.getClass().getSimpleName();
    private static int animalCounter = 0;

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        animalCounter++;
    }

    public String getRussianClassName() {
        if (className.equals("Cat")) return "Коты";
        if (className.equals("Dog")) return "Собаки";
        return className;
    }

    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Недопустимое значение");
            return;
        }
        if (distance > maxDistanceToRun) {
            System.out.println(getRussianClassName() + " не могут бегать так далеко. (макс. дистанция - " + maxDistanceToRun + " м)");
        } else System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("Недопустимое значение");
            return;
        }
        if (maxDistanceToSwim == 0) {
            System.out.println(getRussianClassName() + " не умеют плавать :(");
            return;
        }
        if (distance > maxDistanceToSwim) {
            System.out.println(getRussianClassName() + " не могут плавать так далеко. (макс. дистанция - " + maxDistanceToSwim + " м)");
        } else System.out.println(name + " проплыл " + distance + " м.");
    }

}
