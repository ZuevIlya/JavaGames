/**
 * Created by Ilya on 12.10.2022 - 26.10.2022
 * Vkontakte: @ilyazyev
 * Telegram: @Zuev2000
 */

import java.io.IOException;
import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() throws IOException {
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(480, 476);
        this.setLocation(400, 200);
        this.add(new GameField());
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new MainWindow();
    }
}