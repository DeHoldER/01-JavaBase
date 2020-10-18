public class HomeWork02 {

    public static void main(String[] args) {

//        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] = 0;
            } else arr1[i] = 1;
        }

//        2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] arr2 = new int[8];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }

//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
        }

//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//        цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] arr4 = new int[5][5];

        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][(arr4.length - 1) - i] = 1;
        }

//        Проверка по методичке
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j]);
            }
            System.out.println();
        }

//        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

//        Для создания массива воспользуемся генератором:
        int[] arr5 = arrGenerator(15, 50);
        int arr5Min = arr5[0];
        int arr5Max = arr5[0];
        for (int i : arr5) {
            if (i < arr5Min) arr5Min = i;
            if (i > arr5Max) arr5Max = i;
        }
//        Выводим мин и макс в консоль
        System.out.println("Минимальный элемент в массиве: " + arr5Min);
        System.out.println("Максимальный элемент в массиве: " + arr5Max);


//        Проверка задания №6 (опять-таки генерируем массив)
        checkBalance(arrGenerator(10, 2));

//        Проверка задания №7
        arrMover(arrGenerator(7, 5), 2);
    }

//        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
//        true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница
//        показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] arr) {
        boolean out = false;
        for (int i = 1; i < arr.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += arr[j];
            }
            for (int k = 0; k < arr.length - i; k++) {
                sumRight += arr[k + i];
            }
            if (sumLeft == sumRight) {
                out = true;
                System.out.println(sumLeft + " || " + sumRight + " разделитель после " + i + " элемента");
            }
        }
        return (out);
    }

//        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
//        отрицательным), при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя
//        пользоваться вспомогательными массивами.

    public static void arrMover(int[] arr, int n) {

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int buffer = arr[arr.length - 1];
                for (int j = arr.length; j > 0; j--) {
                    if (j > 1) arr[j - 1] = arr[j - 2];
                    if (j == 1) arr[0] = buffer;
                }
            }
            System.out.println("После сдвига вправо на " + n + " элемента(ов):");
            printArray(arr);
        }
        if (n < 0) {
            n = -n;
            for (int i = 0; i < n; i++) {
                int buffer = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    if (j <= arr.length - 2) arr[j] = arr[j + 1];
                    if (j == arr.length - 1) arr[j] = buffer;
                }
            }
            System.out.println("После сдвига влево на " + n + " элемента(ов):");
            printArray(arr);
        }
    }

//    Вспомогательные методы генератор и принтер для проверки (написаны лично)

    public static int[] arrGenerator(int arrLength, int max) {
        int[] arrOut = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            double rnd = Math.random() * max + 1;
            arrOut[i] = (int) rnd;
        }
        System.out.println();
        printArray(arrOut);
        System.out.println();
        return arrOut;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
    }
}
