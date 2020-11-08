import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    protected boolean isAlive = true;

    public App(final int SIZE) {

        int sizeMultiplier = 60;
        setTitle("Сапёр");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds((dimension.width / 2) - (SIZE * (sizeMultiplier / 2)), (dimension.height / 2) - (SIZE * (sizeMultiplier / 2)), SIZE * sizeMultiplier, SIZE * sizeMultiplier);

        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
            }
        }

        JButton[][] buttons = new JButton[SIZE][SIZE];

        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setText("");
                int ii = i;
                int jj = j;
                button.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (bombs[ii][jj]) {
                        isAlive = false;
                        GameOverWindow gameOver = new GameOverWindow(SIZE, sizeMultiplier, this);
                        for (int o = 0; o < SIZE; o++) {
                            for (int p = 0; p < SIZE; p++) {
                                if (bombs[o][p]) {
                                    buttons[o][p].setFont(button.getFont().deriveFont(sizeMultiplier / 3F));
                                    buttons[o][p].setText("\uD83D\uDCA3");
                                    buttons[o][p].setForeground(Color.WHITE);
                                    buttons[o][p].setBackground(new Color(170, 0, 0));
                                    button.setBackground(new Color(255, 0, 0));
                                }
                            }
                        }

                    } else {
                        int nearBombsNum = 0;

                        // Счётчики ближайших бомб:
                        // Верх
                        if (ii == 0 && jj > 0 && jj < SIZE - 1) {
                            for (int k = 0; k < 2; k++) {
                                for (int l = -1; l < 2; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // НИЗ
                        if (ii == SIZE - 1 && jj > 0 && jj < SIZE - 1) {
                            for (int k = -1; k < 1; k++) {
                                for (int l = -1; l < 2; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // Лево
                        if (ii > 0 && ii < SIZE - 1 && jj == 0) {
                            for (int k = -1; k < 2; k++) {
                                for (int l = 0; l < 2; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // Право
                        if (ii > 0 && ii < SIZE - 1 && jj == SIZE - 1) {
                            for (int k = -1; k < 2; k++) {
                                for (int l = -1; l < 1; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // Верхний левый угол
                        if (ii == 0 && jj == 0) {
                            for (int k = 0; k < 2; k++) {
                                for (int l = 0; l < 2; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        //Верхний правый угол
                        if (ii == 0 && jj == SIZE - 1) {
                            for (int k = 0; k < 2; k++) {
                                for (int l = -1; l < 1; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // Нижний левый угол
                        if (ii == SIZE - 1 && jj == 0) {
                            for (int k = -1; k < 1; k++) {
                                for (int l = 0; l < 2; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // Нижний правый угол
                        if (ii == SIZE - 1 && jj == SIZE - 1) {
                            for (int k = -1; k < 1; k++) {
                                for (int l = -1; l < 1; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }
                        // остальное
                        if (ii > 0 && ii < SIZE - 1 && jj > 0 && jj < SIZE - 1) {
                            for (int k = -1; k < 2; k++) {
                                for (int l = -1; l < 2; l++) {
                                    if (bombs[ii + k][jj + l]) nearBombsNum++;
                                }
                            }
                        }

                        if (nearBombsNum > 0) {
                            button.setFont(button.getFont().deriveFont(15.F));
                            button.setText(String.valueOf(nearBombsNum));
                            button.setBackground(Color.WHITE);
                            if (nearBombsNum > 1 && nearBombsNum < 7) {
                                button.setForeground(new Color(nearBombsNum * 42, 0, 255 / nearBombsNum));
                            } else button.setForeground(new Color(0, 0, 255));
                        } else {
                            button.setBackground(Color.WHITE);
                            button.setText("");
                        }
                    }
                });
                add(button);
            }
        }
        setVisible(true);
    }
}
