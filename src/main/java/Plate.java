package ru.geekbrains.homeWork07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            System.out.println("В миске не хватило еды. Осталось: " + food);
            return false;
        }
    }

    public void increaseFood(int n) {
        food += n;
        System.out.println("Миска пополнена. Теперь в ней " + food + " единиц корма.");
    }

    public void info() {
        System.out.println("В миске " + food + " единиц корма");
    }
}
