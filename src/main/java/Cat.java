package ru.geekbrains.homeWork07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }

    public void getSatiety() {
        if (satiety) System.out.println(name + " сыт и доволен");
        else System.out.println(name + " голоден и уныл...");
    }
}
