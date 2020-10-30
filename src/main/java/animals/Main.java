package ru.geekbrains.animals;

public class Main {

    public static void main(String[] args) {

        Animal catMurzik = new Cat("Мурзик", 2);
        Dog dogWolfy = new Dog("Вульфи", 3);
        Cat catBars = new Cat("Барсик", 6);

        catBars.run(150);
        catBars.swim(20);

        System.out.println();

        catMurzik.run(200);
        catMurzik.swim(3);

        System.out.println();

        dogWolfy.run(550);
        dogWolfy.swim(10);

        System.out.println();
        System.out.println("Животных создано: " + Animal.getAnimalCounter());
        System.out.println("Из них котов: " + Cat.getCatCounter());
        System.out.println("Собак: " + Dog.dogCounter());
    }

}
