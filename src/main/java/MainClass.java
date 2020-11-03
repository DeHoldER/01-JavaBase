package ru.geekbrains.homeWork07;

import java.util.Random;

public class MainClass {
    public static Random rnd = new Random();

    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик", 10);
        Plate plate = new Plate(100);

        plate.info();
        System.out.println();

        catBarsik.eat(plate);
        catBarsik.getSatiety();

        Cat[] cats = new Cat[5];

        for (int i = 0; i < cats.length - 1; i++) {
            cats[i] = new Cat(nameGen(), rnd.nextInt(15));
        }
        cats[cats.length - 1] = new Cat("Жирчик", 80);

        for (Cat c : cats) {
            c.eat(plate);
            c.getSatiety();
        }

        System.out.println();

        plate.increaseFood(50);
    }

    // Сначала вписал в массив имена вручную, но потом решил, что нужен генератор. Конечно, он такой себе, но иногда
    // удивляет именами типа: Батя, Мазик, Нарик, Гашик, Физик, Кубик, Дошик, Педик и тд))

    public static String nameGen() {
        String[] slog = new String[]{"ба", "ва", "га", "да", "та", "ра", "ма", "ла", "зе", "ле", "ме", "ше", "ве", "бе", "ле", "ку", "зя", "пе", "ся", "то", "ли", "зю", "на", "ти", "ля", "фи", "ка", "фри", "бон", "до", "жир"};
        String[] suf = new String[]{"зик", "лик", "тик", "рик", "чик", "дик", "вик", "бик", "тя", "ня", "шик", "ник", "мик"};
        StringBuilder sb = new StringBuilder();
        sb.append(slog[rnd.nextInt(slog.length - 1)]);
        sb.append(suf[rnd.nextInt(suf.length - 1)]);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}