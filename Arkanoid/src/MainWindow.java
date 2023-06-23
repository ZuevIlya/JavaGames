import javax.swing.*;
import java.io.IOException;

public class MainWindow extends JFrame {

    public MainWindow() throws IOException {
        setTitle("Strike Ball");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(480,505);
        setLocation(400,200);
        add(new GameField());
        setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        MainWindow mw = new MainWindow();
    }
}
