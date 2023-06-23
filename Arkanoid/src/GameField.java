/**
 * Created by Ilya on 12.10.2022 - 26.10.2022
 * Vkontakte: @ilyazyev
 * Telegram: @Zuev2000
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URISyntaxException;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int dot_size = 16; // size=480; all_dots=900; - Размер одного квадратика
    public static Image ball; // Шарик
    public static Image platform; // Платформа
    private Image point11; // Верхний красный ряд
    private Image point12; // Нижний красный ряд
    private Image point21; // Верхний оранжевый ряд
    private Image point22; // Нижний оранжевый ряд
    private Image point31; // Верхний жёлтый ряд
    private Image point32; // Нижий жёлтый ряд
    private Image bonus1; // Иконка бонуса1
    private Image bonus1Ball; // Иконка шарика с бонусом1
    private static final int lengthPlatform = 6; // Длина платформы
    public static final int[] platformX = new int[lengthPlatform]; // Координаты квадратов платформы по оси OX
    private int platformY; // Координаты квадратов платформы по оси OY
    public static int ballX; // Коориданата шарика по оси OX
    public static int ballY; // Координата шарика по оси OY
    private static final int lengthPoint = 30; // Длина рядов квадратиков
    private final int[] pointX11 = new int[lengthPoint]; // Кооринаты первого ряда квадратиков по оси OX
    private final int[] pointX12 = new int[lengthPoint]; // Кооринаты второго ряда квадратиков по оси OX
    private final int[] pointX21 = new int[lengthPoint]; // Кооринаты третьего ряда квадратиков по оси OX
    private final int[] pointX22 = new int[lengthPoint]; // Кооринаты четвёртого ряда квадратиков по оси OX
    private final int[] pointX31 = new int[lengthPoint]; // Кооринаты пятого ряда квадратиков по оси OX
    private final int[] pointX32 = new int[lengthPoint]; // Кооринаты шестого ряда квадратиков по оси OX
    public static final boolean[][] delete = new boolean[lengthPoint][6]; // Состояния активности всех квадратиков
    private int pointY11; // Координаты первого ряда квадратиков по оси OY
    private int pointY12; // Координаты второго ряда квадратиков по оси OY
    private int pointY21; // Координаты третьего ряда квадратиков по оси OY
    private int pointY22; // Координаты четвёртого ряда квадратиков по оси OY
    private int pointY31; // Координаты пятого ряда квадратиков по оси OY
    private int pointY32; // Координаты шестого ряда квадратиков по оси OY
    public static int bonus1_counter = 0; //Бонус1, уничтожающий квадратики плюсом (крестиком)
    public static boolean bonus1_enter = false; // Бонус1 появился (или существует) на экране
    public static int bonus1X; // Координаты бонуса1 по оси OX
    public static int bonus1Y; // Координаты бонуса1 по оси OY
    private int drawResult; // Вывод результата на экран
    public static boolean left = true; // Направление шарика влево
    public static boolean right = false; // Напрвление шарика вправо
    public static boolean up = true; // Напрвление шарика вверх
    public static boolean down = false; // Напрвление шарика вниз
    public static boolean platformLeft = false; // Направление платформы влево
    public static boolean platformRight = false; // Направление платформы вправо
    private boolean inGame = true; // Состояние игры (активно/не активно)
    private boolean win = false; // Состояние победы
    public static boolean platformBorderLeft; // Встреча самого левого квадратика платформы, если шарик летит вправо
    public static boolean platformBorderRight; // Встреча самого правого квадратика платформы, если шарик летит вправо
    private boolean gameStart = false; // Точка входа в игру (меню игры)
    public static boolean menu1 = true; // Меню игры
    public static boolean menu2 = false; // Меню выбора цвета платформы
    public static boolean menu3 = false; // Меню выбора цвета шарика
    public static boolean menu4 = false; // Меню информации об авторе
    public static int menu1_counter = 1; // Выбор в меню 1
    public static int menu2_counter = 1; // Выбор цвета платформы в меню 2
    public static int menu3_counter = 1; // Выбор цвета платформы в меню 3
    public int menu2_enter = 1; // Закрашивание меню 2
    public int menu3_enter = 2; // Закрашивание меню 3
    public static Audio gameOverSound; // Звук проигрыша
    public static Audio gameWinSound; // Звук победы
    public static Audio menuCounterSound; // Звук переключения меню  (up/down)
    public static Audio menuEnterSound; // Звук подтверждения меню (Enter)

    ImageIcon image1 = new ImageIcon(this.getClass().getResource("Images/BlueSQR.png"));
    ImageIcon image2 = new ImageIcon(this.getClass().getResource("Images/GreenSQR.png"));
    ImageIcon image3 = new ImageIcon(this.getClass().getResource("Images/RedSQR.png"));
    ImageIcon image4 = new ImageIcon(this.getClass().getResource("Images/OrangeSQR.png"));
    ImageIcon image5 = new ImageIcon(this.getClass().getResource("Images/YellowSQR.png"));
    ImageIcon image6 = new ImageIcon(this.getClass().getResource("Images/Star.png"));
    ImageIcon image7 = new ImageIcon(this.getClass().getResource("Images/Bonus1SQR.png"));

    public static Audio bonus1Sound; // Звук подбирания бонуса1 шариком
    public static Audio pointSound;
    public static Audio platformSound;
    public static Audio pointBoomSound;


    public GameField() {
        setBackground(Color.BLACK);
        addKeyListener(new FieldKeyListener()); // Обработчик событий клавиатуры
        setFocusable(true); // Чтобы кнопки работали на игровом поле
        initGame();
        loadImages();
    }

    public void initGame() {
        for (int i = 0; i < lengthPlatform; i++) {
            platformX[i] = (i + (lengthPoint - lengthPlatform) / 2) * dot_size; // Левый квадратик - нулевой элемент
        }
        platformY = (lengthPoint - 3) * dot_size;
        for (int i = 0; i < lengthPoint; i++) {
            pointX11[i] = i * dot_size;
            pointX12[i] = i * dot_size;
            pointX21[i] = i * dot_size;
            pointX22[i] = i * dot_size;
            pointX31[i] = i * dot_size;
            pointX32[i] = i * dot_size;
        }
        pointY11 = 2 * dot_size;
        pointY12 = 3 * dot_size;
        pointY21 = 4 * dot_size;
        pointY22 = 5 * dot_size;
        pointY31 = 6 * dot_size;
        pointY32 = 7 * dot_size;
        for (int i = 0; i < lengthPoint; i++) {
            for (int j = 0; j < 6; j++) {
                delete[i][j] = true;
            }
        }
        createBall();
        gameOverSound = new Audio(this.getClass().getResource("Sounds/GameOverSound.wav"), 0.7);
        menuCounterSound = new Audio(this.getClass().getResource("Sounds/MenuCounterSound.wav"), 1);
        menuEnterSound = new Audio(this.getClass().getResource("Sounds/MenuEnterSound.wav"), 1);
        gameWinSound = new Audio(this.getClass().getResource("Sounds/GameWinSound.wav"), 0.8);

        bonus1Sound = new Audio(this.getClass().getResource("Sounds/bonus1Sound.wav"), 0.8);

        pointSound = new Audio(this.getClass().getResource("Sounds/pointSound.wav"), 0.8);
        platformSound = new Audio(this.getClass().getResource("Sounds/platformSound.wav"), 0.8);
        pointBoomSound = new Audio(this.getClass().getResource("Sounds/pointBoomSound.wav"), 0.8);
        Timer timer1 = new Timer(75, this);
        timer1.start();
    }

    public void createBall() {
        ballX = new Random().nextInt(lengthPoint) * dot_size;
        ballY = 19 * dot_size;
    }

    public void createBonus1() {
        bonus1_enter = true;
        bonus1X = (new Random().nextInt(lengthPoint - 10) + 5) * dot_size;
        bonus1Y = (new Random().nextInt(lengthPoint - 20) + 10) * dot_size;
    }

    public void loadImages() {
        point11 = image3.getImage();
        point12 = image3.getImage();
        point21 = image4.getImage();
        point22 = image4.getImage();
        point31 = image5.getImage();
        point32 = image5.getImage();
        bonus1 = image6.getImage();
        bonus1Ball = image7.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameStart) {
            if (menu1) {
                Menu.MenuFunction1(g, menu1_counter, dot_size);
            }
            if (menu2) {
                Menu.MenuFunction2(g, menu2_counter, menu2_enter, dot_size);
            }
            if (menu3) {
                Menu.MenuFunction3(g, menu3_counter, menu3_enter, dot_size);
            }
            if (menu4) {
                Menu.MenuFunction4(g, dot_size);
            }
        }
        if (gameStart) {
            if (inGame) {
                if ((!bonus1_enter) && (bonus1_counter == 0)) {
                    createBonus1();
                }
                if (bonus1_enter) {
                    g.drawImage(bonus1, bonus1X, bonus1Y, this);
                }
                if ((!bonus1_enter) && (bonus1_counter > 0)) {
                    g.drawImage(bonus1Ball, ballX, ballY, this);
                } else {
                    if (ball == null) {
                        g.drawImage(image2.getImage(), ballX, ballY, this);
                    } else {
                        g.drawImage(ball, ballX, ballY, this);
                    }
                }
                if (platform == null) {
                    for (int i = 0; i < lengthPlatform; i++) {
                        g.drawImage(image1.getImage(), platformX[i], platformY, this);
                    }
                } else {
                    for (int i = 0; i < lengthPlatform; i++) {
                        g.drawImage(platform, platformX[i], platformY, this);
                    }
                }
                for (int i = 0; i < lengthPoint; i++) {
                    if (delete[i][0]) {
                        g.drawImage(point11, pointX11[i], (pointY11), this);
                    }
                    if (delete[i][1]) {
                        g.drawImage(point12, pointX12[i], (pointY12), this);
                    }
                    if (delete[i][2]) {
                        g.drawImage(point21, pointX21[i], (pointY21), this);
                    }
                    if (delete[i][3]) {
                        g.drawImage(point22, pointX22[i], (pointY22), this);
                    }
                    if (delete[i][4]) {
                        g.drawImage(point31, pointX31[i], (pointY31), this);
                    }
                    if (delete[i][5]) {
                        g.drawImage(point32, pointX32[i], (pointY32), this);
                    }
                }
                String result = "Ваш результат:" + drawResult;
                String bonus1Str = "Количество бонусных ударов: " + bonus1_counter;

                g.setColor(Color.YELLOW);
                g.drawString(result, 2 * dot_size, (lengthPoint - 1) * dot_size);
                if (bonus1_counter > 0) {
                    g.drawString(bonus1Str, 10 * dot_size, (lengthPoint - 1) * dot_size);
                }

            } else {
                if (win) {
                    Menu.menuGameWin(g);
                } else {
                    Menu.menuGameOver(g);
                }
            }
        }
        repaint();
    }

    public void WinGame() throws URISyntaxException {
        int winSum = 0;
        for (int i = 0; i < lengthPoint; i++) {
            for (int j = 0; j < 6; j++) {
                if (!delete[i][j]) {
                    winSum = winSum + 1;
                }
            }
        }
        drawResult = winSum;
        if (winSum == lengthPoint * 6) {
            win = true;
            GameSound(gameWinSound);
            inGame = false;
        }
    }

    public void GameSound(Audio sound) throws URISyntaxException{
        try {
            sound.sound();
            sound.setVolume();
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void TryGameSound(Audio sound) {
        try {
            GameSound(sound);
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void CheckGameOver() throws URISyntaxException {
        if (ballY == lengthPoint * dot_size) {
            GameSound(gameOverSound);
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStart) {
            if (inGame) {
                CheckBox.CheckPlatform(ballX, ballY, platformX, platformY, lengthPlatform, dot_size); // Проверяем удар шарика об платформу
                CheckBox.CheckPoint(ballX, ballY, lengthPoint, dot_size, pointX32, pointY32, 5, delete);
                CheckBox.CheckPoint(ballX, ballY, lengthPoint, dot_size, pointX31, pointY31, 4, delete);
                CheckBox.CheckPoint(ballX, ballY, lengthPoint, dot_size, pointX22, pointY22, 3, delete);
                CheckBox.CheckPoint(ballX, ballY, lengthPoint, dot_size, pointX21, pointY21, 2, delete);
                CheckBox.CheckPoint(ballX, ballY, lengthPoint, dot_size, pointX12, pointY12, 1, delete);
                CheckBox.CheckPoint(ballX, ballY, lengthPoint, dot_size, pointX11, pointY11, 0, delete);
                Move.MovePlatform(platformLeft, platformRight, lengthPoint, lengthPlatform, dot_size); // Двигает платформу
                Move.BonusBall(ballX, ballY, bonus1X, bonus1Y, dot_size); // Проверяет, наступил ли шарик на бонус1
                Move.Border(ballX, ballY, lengthPoint, dot_size); // Проверяет, не попал ли шарик на границы экрана
                Move.MoveBall(left, right, up, down, lengthPoint, dot_size); // Проверяет движение шарика в зависимости от его направления
                try {
                    WinGame();
                    CheckGameOver();
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && gameStart) {
                platformLeft = true;
                platformRight = false;
            }
            if ((key == KeyEvent.VK_RIGHT) && gameStart) {
                platformLeft = false;
                platformRight = true;
            }
            if ((key == KeyEvent.VK_ENTER) && !inGame) {
                gameStart = false;
                inGame = true;
                menu1 = true;
                left = true;
                right = false;
                up = true;
                down = false;
                win = false;
                platformLeft = false;
                platformRight = false;
                bonus1_enter = false;
                bonus1_counter = 0;
                new GameField();
                key = 0;
            }
            if (menu1) {
                if ((key == KeyEvent.VK_DOWN) && (menu1_counter < 4)) {
                    TryGameSound(menuCounterSound);
                    menu1_counter = menu1_counter + 1;
                }
                    if ((key == KeyEvent.VK_UP) && (menu1_counter > 1)) {
                        TryGameSound(menuCounterSound); // ОЦЛЙТВТЙДЦВЙДЦТВЙЦДВ
                        menu1_counter = menu1_counter - 1;
                    }
                    if (key == KeyEvent.VK_ENTER) {
                        TryGameSound(menuEnterSound);
                        switch (menu1_counter) {
                            case 1:
                                gameStart = true;
                                menu1 = false;
                                break;
                            case 2:
                                menu1 = false;
                                menu2 = true;
                                key = 0;
                                break;

                            case 3:
                                menu1 = false;
                                menu3 = true;
                                key = 0;
                                break;
                            case 4:
                                menu1 = false;
                                menu4 = true;
                                key = 0;
                                break;

                        }
                    }
                }
                if (menu2) {
                    if ((key == KeyEvent.VK_DOWN) && (menu2_counter < 6)) {
                        TryGameSound(menuCounterSound);
                        menu2_counter = menu2_counter + 1;
                    }
                    if ((key == KeyEvent.VK_UP) && (menu2_counter > 1)) {
                        TryGameSound(menuCounterSound);
                        menu2_counter = menu2_counter - 1;
                    }
                    if (key == KeyEvent.VK_ENTER) {
                        TryGameSound(menuEnterSound);
                        switch (menu2_counter) {
                            case 1:
                                platform = image1.getImage();
                                menu2_enter = 1;
                                break;
                            case 2:
                                platform = image2.getImage();
                                menu2_enter = 2;
                                break;

                            case 3:
                                platform = image3.getImage();
                                menu2_enter = 3;
                                break;
                            case 4:
                                platform = image4.getImage();
                                menu2_enter = 4;
                                break;

                            case 5:
                                platform = image5.getImage();
                                menu2_enter = 5;
                                break;
                            case 6:
                                menu1 = true;
                                menu2 = false;
                                menu2_counter = 1;
                                key = 0;
                                break;
                        }
                    }
                }
                if (menu3) {
                    if ((key == KeyEvent.VK_DOWN) && (menu3_counter < 6)) {
                        TryGameSound(menuCounterSound);
                        menu3_counter = menu3_counter + 1;
                    }
                    if ((key == KeyEvent.VK_UP) && (menu3_counter > 1)) {
                        TryGameSound(menuCounterSound);
                        menu3_counter = menu3_counter - 1;
                    }
                    if (key == KeyEvent.VK_ENTER) {
                        TryGameSound(menuEnterSound);
                        switch (menu3_counter) {
                            case 1:
                                ball = image1.getImage();
                                menu3_enter = 1;
                                break;
                            case 2:
                                ball = image2.getImage();
                                menu3_enter = 2;
                                break;

                            case 3:
                                ball = image3.getImage();
                                menu3_enter = 3;
                                break;
                            case 4:
                                ball = image4.getImage();
                                menu3_enter = 4;
                                break;
                            case 5:
                                ball = image5.getImage();
                                menu3_enter = 5;
                                break;
                            case 6:
                                menu1 = true;
                                menu3 = false;
                                menu3_counter = 1;
                                key = 0;
                                break;
                        }
                    }
                }

                if (menu4) {
                    if (key == KeyEvent.VK_ENTER) {
                        TryGameSound(menuEnterSound);
                        menu1 = true;
                        menu4 = false;
                        key = 0;
                    }

                }
            }
        }
    }



