/**
 * Created by Ilya on 12.10.2022 - 26.10.2022
 * Vkontakte: @ilyazyev
 * Telegram: @Zuev2000
 */

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("Пятнашки");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(512,540); // 480 + 25 = 505
        setLocation(400,200);
        add(new GameField());
        setVisible(true);
    }
    public static void main(String[] args){
        MainWindow mw = new MainWindow();
    }
}
