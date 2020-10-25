import java.util.Random;
import java.util.Scanner;

public class HomeWork04 {
    public static Random random = new Random();
    public static final char EMPTY = '.';
    public static final char ZERO = '0';
    public static final char CROSS = 'X';
    public static final char THREAT = '!';  // маркер угрозы для ИИ

    public static int mapSize = 3;      // при размере 3х3 играть вполне себе интересно :)
    public static int tokensToWin = 3;
    public static int accuracy = 1;  // <-- чем выше параметр, тем раньше ИИ начнёт блокировать ходы (может иметь
    // смысл на больших картах, при этом если количество фишек для победы != карте, ИИ может вести себя наоборот
    // слишком тупо (например, ставить нули там, где в этом уже нет смысла), так что лучше вообще не трогать :)))

    public static char[][] map = new char[mapSize][mapSize];
    public static char[][] threatsMap = new char[mapSize][mapSize];   //массив с угрозами
    public static int shootX;
    public static int shootY;
    public static boolean playerTurn = true;
    public static int threats = 0;  // счётчик угроз на проверяемой линии

    public static void main(String[] args) {

        initMap();
        printMap();
        gameCycle();

    }

    public static void gameCycle() {
        while (true) {
            playerTurn();
            if (checkIsWin(CROSS)) {
                System.out.println("Победил человечишко!");
                break;
            }
            if (noEmptyCell()) {
                System.out.println("Ничья!");
                break;
            }
            checkIsWin(ZERO); // при этой проверке комп смотрит, есть ли у него потенциально выигрышные комбинации и отмечает их в карте угроз
            aiTurn();
            if (checkIsWin(ZERO)) {
                System.out.println("Победил компьютерный мозг!");
                break;
            }
            if (noEmptyCell()) {
                System.out.println("Ничья!");
                break;
            }
        }
        askNewGame();
    }

    public static void askNewGame() {
        System.out.println("Сыграем ещё раз? 1 - ДА | 2 - НЕТ");
        if (checkIsInt("Введите 1 или 2") == 1) {
            initMap();
            System.out.println("НОВАЯ ИГРА");
            if (playerTurn) printMap();
            gameCycle();
        }

    }

    // метод обнуляет карту
    public static void initMap() {
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                map[x][y] = EMPTY;
                threatsMap[x][y] = EMPTY;
            }
        }
    }

    // проверяет на наличие пустых клеток
    public static boolean noEmptyCell() {
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                if (map[x][y] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // печатает карту
    public static void printMap() {
        for (int i = 0; i < mapSize; i++) {
            System.out.print(" ");
            System.out.print(i + 1);
        }
        System.out.println();
        for (int y = 0; y < mapSize; y++) {
            System.out.print(y + 1);
            for (int x = 0; x < mapSize; x++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Метод запрашивает координату, проверяет, чтобы это был int и чтобы он был в пределах поля.
    public static int getCoordinates(char coordinateName) {
        System.out.println("Введите координату " + coordinateName + ":");
        int out;
        while (true) {
            out = checkIsInt("Нужно ввести цифру от 1 до " + mapSize);
            if (out > 0 && out <= mapSize) {
                return out - 1;
            } else {
                System.out.println("Координаты за пределами поля!");
            }
        }
    }

    // запрашивает и отдаёт int
    public static int checkIsInt(String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int out;
            if (scanner.hasNextInt()) {
                out = scanner.nextInt();
                return out;
            } else {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }

    // ход человека
    public static void playerTurn() {
        if (playerTurn) {
            while (true) {
                shootX = getCoordinates('X');
                shootY = getCoordinates('Y');
                if (map[shootX][shootY] == EMPTY) {
                    map[shootX][shootY] = CROSS;
                    playerTurn = false;
                    printMap();
                    break;
                } else {
                    System.out.println("Клетка занята - в ней " + map[shootX][shootY]);
                }
            }
        }
    }

    // ход ИИ
    public static void aiTurn() {
        if (!playerTurn) {
            while (true) {
                if (!hasAnyThreats()) {
                    shootX = random.nextInt(mapSize);
                    shootY = random.nextInt(mapSize);
                }
                if (map[shootX][shootY] == EMPTY) {
                    map[shootX][shootY] = ZERO;
                    playerTurn = true;
                    System.out.println("Комп ходит на " + (shootX + 1) + "-" + (shootY + 1) + "\n");
                    printMap();
                    break;
                }
            }
        }
    }

    // проверка условий победы
    public static boolean checkIsWin(char player) {
        return (checkIsWinH(player) || checkIsWinV(player) || checkIsWinL(player) || checkIsWinR(player));
    }

    // проверяет, есть ли угрозы
    public static boolean hasAnyThreats() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (threatsMap[x][y] == THREAT && map[x][y] == EMPTY) {
                    shootX = x;
                    shootY = y;
                    threatsMap[x][y] = EMPTY;
                    return true;
                }
            }
        }
        return false;
    }

    // далее следуют методы проверок, включающие в себя сканер угроз с последующей их записью в карту с угрозами
    // p.s. наверное, это всё можно было написать как-то проще и я все выходные думал, как это сделать, но ничего другого не придумал))

    // проверка по горизонтали
    public static boolean checkIsWinH(char player) {
        int tokens = 0;
        for (int y = 0; y < mapSize; y++) {
            if (tokens >= tokensToWin) return true;
            tokens = 0;
            threats = 0;
            for (int x = 0; x < mapSize; x++) {
                if (map[x][y] == player) {
                    tokens++;
                    threats++;
                    if (threats >= tokensToWin - accuracy) {
                        for (int check = 0; check < mapSize; check++) {
                            if (map[check][y] == EMPTY) {
                                threatsMap[check][y] = THREAT;
                            }
                        }
                    }
                } else if (tokens < tokensToWin) tokens = 0;
            }
        }
        return tokens >= tokensToWin;
    }

    // проверка по вертикали
    public static boolean checkIsWinV(char player) {
        int tokens = 0;
        for (int x = 0; x < mapSize; x++) {
            if (tokens >= tokensToWin) return true;
            tokens = 0;
            threats = 0;
            for (int y = 0; y < mapSize; y++) {
                if (map[x][y] == player) {
                    tokens++;
                    threats++;
                    if (threats >= tokensToWin - accuracy) {
                        for (int check = 0; check < mapSize; check++) {
                            if (map[x][check] == EMPTY) {
                                threatsMap[x][check] = THREAT;
                            }
                        }
                    }
                } else if (tokens < tokensToWin) tokens = 0;
            }
        }
        return tokens >= tokensToWin;
    }

    // дальше идут 2 диагональные проверки - это совсем жесть)) я и сам уже не понимаю, что я тут понаписал))
    // проверка по диагонали слева направо
    public static boolean checkIsWinL(char player) {
        int tokens = 0;
        int startX = 0;
        int startY = mapSize - tokensToWin;
        int x = 0;
        while (startX <= mapSize - tokensToWin) {
            if (tokens >= tokensToWin) return true;
            tokens = 0;
            threats = 0;
            for (int y = startY; y < mapSize - startX; y++) {
                if (map[startX + x][y] == player) {
                    tokens++;
                    threats++;
                    if (threats >= tokensToWin - accuracy) {
                        int checkX = 0;
                        for (int checkY = startY; checkY < mapSize - startX; checkY++) {
                            if (map[checkX + startX][checkY] == EMPTY) {
                                threatsMap[checkX + startX][checkY] = THREAT;
                            }
                            checkX++;
                        }
                    }
                } else if (tokens < tokensToWin) tokens = 0;
                x++;
            }
            x = 0;
            if (startY == 0) startX++;
            if (startY != 0) startY--;
        }
        return tokens >= tokensToWin;
    }

    // Проверка по диагонали 'R'
    public static boolean checkIsWinR(char player) {
        int tokens = 0;
        int startX = mapSize - 1;
        int startY = mapSize - tokensToWin;
        int x = 0;
        while (startX >= mapSize - tokensToWin) {
            if (tokens >= tokensToWin) return true;
            tokens = 0;
            threats = 0;
            for (int y = startY; y <= startX; y++) {
                if (map[startX + x][y] == player) {
                    tokens++;
                    threats++;
                    if (threats >= tokensToWin - accuracy) {
                        int checkX = 0;
                        for (int checkY = startY; checkY <= startX; checkY++) {
                            if (map[checkX + startX][checkY] == EMPTY) {
                                threatsMap[checkX + startX][checkY] = THREAT;
                            }
                            checkX--;
                        }
                    }
                } else if (tokens < tokensToWin) tokens = 0;
                x--;
            }
            x = 0;
            if (startY == 0) startX--;
            if (startY != 0) startY--;
        }
        return tokens >= tokensToWin;
    }

    // вот такая "уличная магия", спасибо за внимание и приятной игры ))

}
