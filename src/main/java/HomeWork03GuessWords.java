import java.util.Random;
import java.util.Scanner;

/* Создать массив из слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
        словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы,
        которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно можно пользоваться:
        String str = "apple";
        char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово.
        Используем только маленькие буквы.
 */
public class HomeWork03GuessWords {
    public static final Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordNumber = random.nextInt(words.length - 1);
        String hiddenWord = words[wordNumber];
        System.out.println("Угадайте слово:");
        String userAnswer = scanner.nextLine();

        for (int tryNum = 1; tryNum < hiddenWord.length(); tryNum++) {
            if (!hiddenWord.equalsIgnoreCase(userAnswer)) {
                System.out.println("Нет, это не " + userAnswer + "... Подсказка:");
                printArray(wordToArray(hiddenWord), tryNum, 15 - tryNum);
                System.out.println();
                userAnswer = scanner.nextLine();
                if (tryNum == hiddenWord.length() - 1) {
                    while (!hiddenWord.equalsIgnoreCase(userAnswer)) {
                        System.out.println("Нет, это не " + userAnswer + "...Ну же, вы почти у цели :)");
                        printArray(wordToArray(hiddenWord), tryNum, 15 - tryNum);
                        System.out.println();
                        userAnswer = scanner.nextLine();
                    }
                }
            } else break;
        }
        System.out.println("Поздравляю! Вы угадали!");
    }

//    Вспомогательные методы

    //    Перевод строки в массив (подозреваю, что должен быть какой-то метод "из коробки", но мы же тут практикуемся) :)
    public static char[] wordToArray(String word) {
        char[] outputArr = new char[word.length()];
        for (int i = 0; i < outputArr.length; i++) {
            char a = word.charAt(i);
            outputArr[i] = a;
        }
        return outputArr;
    }

    //    Печать массива в консоль с добавлением символов '#'
    public static void printArray(char[] arr, int symbolsToPrint, int sharps) {
        for (int i = 0; i < symbolsToPrint; i++) {
            System.out.print(arr[i]);
        }
        for (int i = 0; i < sharps; i++) {
            System.out.print("#");
        }
    }
}