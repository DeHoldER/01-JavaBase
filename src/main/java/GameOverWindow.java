import javax.swing.*;
import java.awt.*;

public class GameOverWindow extends JFrame {

    private App app;

    public GameOverWindow(int SIZE, int sizeMultiplier, App app) {
        this.app = app;
        setResizable(false);
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds((dimension.width / 2) + (SIZE * (sizeMultiplier / 2)), (dimension.height / 2) - (SIZE * (sizeMultiplier / 2)), 250, 140);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 5, 250, 35);
        add(panel1);
        JLabel msg = new JLabel("<html><center>Вы проиграли!<br>Сыграем ещё раз?</center></html>");
        panel1.add(msg, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 45, 250, 50);
        add(panel2);

        JButton button1 = new JButton("Да");
        button1.setPreferredSize(new Dimension(80, 35));
        panel2.add(button1, BorderLayout.CENTER);
        JButton button2 = new JButton("Нет");
        button2.setPreferredSize(new Dimension(80, 35));
        panel2.add(button2, BorderLayout.CENTER);

        button1.addActionListener(actionEvent -> {
            App newGame = new App(5);
            app.dispose();
            dispose();
        });
        button2.addActionListener(actionEvent -> {
            System.exit(1);
        });

        JPanel panel3 = new JPanel();
        add(panel3);

        setVisible(true);
    }
}
