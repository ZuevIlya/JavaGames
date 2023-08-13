import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainWindow extends JFrame implements ActionListener {
    private static final int width = 350;
    private static final int height = 600;
    private static final int player_width = 40;
    private static final int player_height = 40;

    public static int x = 150;
    public static int y = height - 100;
    public static double speed = 0;
    public static boolean left_flag = false;
    public static boolean right_flag = false;
    static ArrayList<MapObject> listObjects = new ArrayList<>();

    public static void main(String[] args) {
        new MainWindow();

    }
    private MainWindow() {
        initPanel();
        initFrame();
        initGame();
        createObjects();
        addKeyListener(new FieldKeyListener());
    }


    private void initPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.GRAY);
                for (MapObject object : getMapObjects()) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(object.getX(), object.getY(), object.getWidth(), object.getHeight());
                }
                g.setColor(Color.GREEN);
                g.fillRect(x,y,player_width,player_height);
                repaint();
            }
        };
        panel.setPreferredSize(new Dimension(width, height));
        add(panel);

        }
    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Platformer");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void initGame() {
        Timer timer1 = new Timer(10, this);
        timer1.start();
    }

    public static void createObjects() {
        MapObject mapObject1 = new MapObject(10,60,100,10);
        MapObject mapObject2 = new MapObject(100,200,150,10);
        MapObject mapObject3 = new MapObject(90,380,80,10);
        MapObject mapObject4 = new MapObject(0, height-10, width,10);
        listObjects.add(mapObject1);
        listObjects.add(mapObject2);
        listObjects.add(mapObject3);
        listObjects.add(mapObject4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       //jump();
        swapSide();
        if (speed < 10) {
            speed = speed + 0.2;
        }
        if (speed >= 0) {
            for (int i = 0; i < (int) (speed); i++) {
                if (!collision(x, y)) {
                    y = y + 1;
                }
            }
        } else {
            y = (int) (speed) + y;
        }
        if (speed >= 0) {
        }

        if ((collision(x, y)) && (speed>=0)) {
            System.out.println("hello");
            speed = -10.0;
        }


        if (left_flag) {
            x = x - 1;
        }
        if (right_flag) {
            x = x + 1;
        }
        objectsUpdate();
    }

    public static boolean collision(int x, int y) {

        for (MapObject object : getMapObjects()) {
            if ((x > object.getX() - player_width) && (x < object.getX() + object.getWidth())
                    && object.getY() - (y + player_height) == 1) {
                return true;
            }
        }
        return false;
    }
    static class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) { // Направление движения влево
                left_flag = true;
                right_flag = false;

            }
            if (key == KeyEvent.VK_RIGHT) { // Направление движения вправо
                right_flag = true;
                left_flag = false;
            }
        }
    }

    public static ArrayList<MapObject> getMapObjects() {
        return listObjects;
    }
    public static void objectsUpdate() {
        if ((y < height/2)) {
            y = height/2;
            for (MapObject object : getMapObjects()) {
                if (speed < 0) {
                    object.setY(object.getY() + (int) Math.abs(speed));
                }
            }
        }
        for (MapObject object : getMapObjects()) {
            if (object.getY() > height) {
                object.setY(0);
            }
        }
    }

    public static void swapSide() {
        if (x == -player_width/2) {
            x = width-player_width/2;
        } else {
            if (x == width - player_width / 2) {
                x = -player_width / 2;
            }
        }
    }
}
