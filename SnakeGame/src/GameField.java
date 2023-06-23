/**
 * Created by Ilya on 12.10.2022 - 26.10.2022
 * Vkontakte: @ilyazyev
 * Telegram: @Zuev2000
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel implements ActionListener {
    public static int dot_size = 16; // Размер одной клетки
    public static int display_size = 840; // 28*30 Количество ячеек по оси X
    public static boolean left; // Направление влево
    public static boolean right; // Направление вправо
    public static boolean up; // Наравление вверх
    public static boolean down; // Напрпаление вниз
    public static int[] snake_dotX = new int[display_size]; // Координата ячейки змейки по оси X
    public static int[] snake_dotY = new int[display_size]; // Координата ячейки змейки по оси Y
    public static int snake_size; // Размер змейки
    public static int appleX; // Координата яблока по оси X
    public static int appleY; // Координата яблока по оси Y
    public static boolean gameOver; // Флаг конца игры
    private Image snake_body; // Тело змейки
    private Image snake_head; // Голова змейки (Нулевой элемент snake_dotX и snake_dotY)
    private Image apple_dot; // Яблоко
    ImageIcon image1 = new ImageIcon(this.getClass().getResource("SnakeHead.png")); // Голова змейки
    ImageIcon image2 = new ImageIcon(this.getClass().getResource("SnakeBody.png")); // Тело змейки
    ImageIcon image3 = new ImageIcon(this.getClass().getResource("AppleIcon.png")); // Яблоко

    public GameField() {
        setBackground(Color.GRAY);
        addKeyListener(new FieldKeyListener()); // Обработчик событий клавиатуры
        setFocusable(true); // Чтобы кнопки работали на игровом поле
        initGame(); // Стартовые настройки игры
        loadImages(); // Загрузка картинок
    }

    public void initGame() {
        initSetup(); // Начальная конфигурация
        Timer timer1 = new Timer(100, this);
        timer1.start();
    }

    public void initSetup() {
        snake_size = 3; // Начальный размер змейки
        for (int i = 0;i<snake_size;i++) { // Начальное расположение змейки
            snake_dotX[i] = i * dot_size + dot_size*15;
            snake_dotY[i] = dot_size*10;
        }
        appleCreate(); // Создание нового яблока
        left = true;
        right = false;
        up = false;
        down = false;
        gameOver = false;
    }

    public void appleCreate() {
        appleX = (int) ((Math.random()*(20))+2)*dot_size; // Случайная ячейка
        appleY = (int) ((Math.random()*(20))+2)*dot_size; // Случайная ячейка
        for (int i=0;i<snake_size;i++) {
            if ((snake_dotX[i] == appleX) && (snake_dotY[i] == appleY)) { // Проверка, не появилось ли яблоко внутри змейки
                appleCreate(); // Попытка создать другое яблоко
            }
        }
    }

    public void loadImages() {
        snake_head = image1.getImage();
        snake_body = image2.getImage();
        apple_dot = image3.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameOver) {
            g.drawImage(snake_head, snake_dotX[0], snake_dotY[0], this); // Отрисовка головы змейки
            for (int i = 1; i < snake_size; i++) {
                g.drawImage(snake_body, snake_dotX[i], snake_dotY[i], this); // Отрисовка тела змейки
            }
            g.drawImage(apple_dot, appleX, appleY, this); // Отрисовка яблока
        }
        else {
            g.setColor(Color.CYAN);
            g.drawString("Your long: " + snake_size, 180, 180);
            g.drawString("You lose! Press ENTER to start new game!", 100, 200); // Отрисовка надписи конца игры
        }
        repaint(); // Перерисовка
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((snake_dotX[0] == appleX) && (snake_dotY[0] == appleY)) { // Столкновение головы змейки с яблоком
            snake_size = snake_size + 1; // Увеличение тела змейки на 1
            appleCreate(); // Создание нового яблока
        }
        for(int i=(snake_size-1);i>0;i--) { // Движение тела змейки
            snake_dotX[i] = snake_dotX[i - 1];
            snake_dotY[i] = snake_dotY[i - 1];
        }
        if (left) {
            snake_dotX[0] = snake_dotX[0] - dot_size; // Движение влево
        }
        if (right) {
            snake_dotX[0] = snake_dotX[0] + dot_size; // Движение вправо
        }
        if (up) {
            snake_dotY[0] = snake_dotY[0] - dot_size; // Движение вверх
        }
        if (down) {
            snake_dotY[0] = snake_dotY[0] + dot_size; // Движение вниз
        }
        if ((snake_dotX[0] <= -16) && (left)) {
            snake_dotX[0] = 464; // Левая граница
        }
        if ((snake_dotX[0] >= 480) && (right)) {
            snake_dotX[0] = 0; // Правая граница
        }
        if ((snake_dotY[0] <= -16) && (up)) {
            snake_dotY[0] = 432; // Верхняя граница
        }
        if ((snake_dotY[0] >= 448) && (down)) {
            snake_dotY[0] = 0; // Нижняя граница
        }
        for (int i=1;i<snake_size;i++) { // Проверка столковения головы и тела змейки
            if ((snake_dotX[0] == snake_dotX[i]) && (snake_dotY[0] == snake_dotY[i])) {
                gameOver = true; // Конец игры
            }
        }
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && (!right)) { // Направление движения влево
                left = true;
                up = false;
                down = false;
            }
            if ((key == KeyEvent.VK_RIGHT) && (!left)) { // Направление движения вправо
                right = true;
                up = false;
                down = false;
            }
            if ((key == KeyEvent.VK_UP) && (!down)) { // Направление движения вверх
                left = false;
                right = false;
                up = true;
            }
            if ((key == KeyEvent.VK_DOWN) && (!up)) { // Направление движения вниз
                left = false;
                right = false;
                down = true;
            }
            if ((key == KeyEvent.VK_ENTER) && (gameOver)) {
                initSetup(); // Если игра проиграна, запуск начальной конфигурации игры
            }
        }
    }
}