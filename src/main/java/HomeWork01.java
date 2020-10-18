public class HomeWork01 {

//1. Создать пустой проект в IntelliJ IDEA и прописать метод main().

    public static void main(String[] args) {

//2. Создать переменные всех пройденных типов данных и инициализировать их значения.

        byte y = 127;
        short s = 32000;
        int i = 2100000000;
        long l = -9200000000000000000L;
        float f = 23.575f;
        double dd = 755.888558;
        char ch = 'c';
        boolean boo = true;
        String str = "Hello!";

        mathFloat(1.5F, 2.5F, 3.4F, 2.3F);

        leapYear(2020);

    }

//3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//где a, b, c, d – аргументы этого метода, имеющие тип float.

    public static float mathFloat (float a,float b,float c,float d) {
        return a * (b + (c / d));
    }

//4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма
//лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

    public static boolean checkSum (int a, int b) {
        if ((a+b) >= 10 && (a+b) <= 20) {
            return true;
        } else return false;

        // Упрощённый вариант:      return (a + b) >= 10 && (a + b) <= 20;

    }

//5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
// положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

    public static void checkPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

//6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
// отрицательное, и вернуть false если положительное.

    public static boolean checkIfNegative(int a) {
        if (a < 0) {
            return true;
        } else return false;
        // опять-таки короткий вариант:     return a < 0;
    }

//7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль
// сообщение «Привет, указанное_имя!».

    public static void greetings (String userName) {
        System.out.println("Привет, " + userName);
    }

//8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год
// является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static void leapYear (int a) {
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            System.out.println("Это високосный год");
        } else System.out.println("Это НЕ високосный год");
    }



}
