import java.util.Random;
import java.util.Scanner;

/*        Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это
        число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное,
        или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
public class HomeWork03GuessNumbers {
    public static final Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        newGame(1, random.nextInt(9));
    }

    //    Т.к. try/catch мы ещё не проходили, то я решил написать данный метод для исключения ошибки:

    public static int makeInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if ("0".equals(input) || "1".equals(input) || "2".equals(input) || "3".equals(input) || "4".equals(input) || "5".equals(input) || "6".equals(input) || "7".equals(input) || "8".equals(input) || "9".equals(input)) {
                int output;
                output = Integer.parseInt(input);
                return output;
            } else {
                System.out.println("Введите число от 0 до 9");
            }
        }
    }

    public static void newGame(int selector, int rndNum) {
        if (selector == 1) {
            System.out.println("Угадайте число от 0 до 9. \nУ вас есть 3 попытки.");
            for (int answersTryCount = 2; answersTryCount >= 0; answersTryCount--) {
                int userAnswer = makeInt(scanner);
                if (userAnswer == rndNum) {
                    System.out.println("Правильно! Вы выиграли!");
                    break;
                } else {
                    if (userAnswer > rndNum) System.out.println("Не угадали... \nЭто число больше, чем загаданное");
                    else System.out.println("Не угадали... \nЭто число меньше, чем загаданное");
                    System.out.println("Попыток осталось: " + answersTryCount);
                }
            }
            System.out.println("Game Over.\n\nПовторить игру еще раз? 1 – да / 0 – нет");
            if (makeInt(scanner) == 1) newGame(1, random.nextInt(9));
        }
    }
}