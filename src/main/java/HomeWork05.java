package ru.geekbrains;

public class HomeWork05 {

    public static void main(String[] args) {

        Person[] persArray = new Person[5];

        persArray[0] = new Person("Крузерштерн Иван Фёдорович", "человек-пароход",
                "ifCruzer@mail.ru", "+7(921)555-77-77", 50000, 52);

        persArray[1] = new Person("Пупкин Василий Петрович", "сторож",
                "отсутствует", "+7(904)123-15-20", 7000, 63);

        persArray[2] = new Person("Торопыгин Александр Владимирович", "курьер",
                "toropygin@mail.ru", "+7(905)113-14-32", 15000, 23);

        persArray[3] = new Person("Писакин Дмитрий Валентинович", "junior-программист",
                "pisakin@yandex.ru", "+7(911)918-34-15", 30000, 19);

        persArray[4] = new Person("Аникеев Максим Лаврентьевич", "senior-программист",
                "anykeyMax@google.com", "+7(921)777-77-77", 200000, 41);


        for (Person person : persArray) {
            if (person.getAge() > 40) {
                person.printAllInfo();
                System.out.println();
            }
        }
    }
}
