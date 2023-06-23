/**
 * Created by Ilya on 12.10.2022 - 26.10.2022
 * Vkontakte: @ilyazyev
 * Telegram: @Zuev2000
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameField extends JPanel implements ActionListener {
    public static final int dot_size = 128; // Размер одного квадрата 128x128
    public static final int lengthPicture = 16; // Количество квадратов
    public static int mouseX; // Координата мыши по оси x
    public static int mouseY; // Координата мыши по оси Y
    ImageIcon[] wolfImageIcon = new ImageIcon[lengthPicture]; // Массив с файлами картинками из папки Icons
    public static Image[] wolfImage = new Image[lengthPicture]; // Массив с картинками
    public static int[] numbersImage = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; // Порядковые номера загрузки картинок
    public static Image wolfBuffer; // Буффер картинки для смены двух картинок местами (swap)
    public static int numberBuffer; // Буффер номера картинки для смены двух порядковых номеров картинок местами (swap)
    public static int clickerCounter = 0; // Количество смен картинок местами
    public static boolean gameFinishFlag = false; // Флаг завершения игры (false - игра активна)

    public GameField() {
        setBackground(Color.BLACK);
        addMouseListener(new FieldMouseListener()); //обработчик событий мыши
        setFocusable(true); // Чтобы кнопки работали на игровом поле
        InitGame();
        LoadImages();
    }

    public void InitGame() { // Начальный алгоритм работы программы (срабатывает 1 раз)
        RandomImage();
        Timer timer1 = new Timer(150, this);
        timer1.start();
    }

    public void RandomImage() { // Перемешивает картинки местами
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < lengthPicture; i++) {
            int change = i + random.nextInt(lengthPicture - i);
            int temp = numbersImage[i];
            numbersImage[i] = numbersImage[change];
            numbersImage[change] = temp;
        }
        CheckRandom();
    }

    public void CheckRandom() { // Проверяет, можно ли собрать данную комбинацию
        int pairCounter = 0; // Количество пар чисел, где первое число больше второго
        int nullNumber = 0; // Номер ряда с пустой клеткой
        for (int i = 0;i < (lengthPicture - 1);i++) {
            if (numbersImage[i] == 15) {
                nullNumber = (i / 4) + 1; // Ищем ряд с пустой клеткой
            }
            for (int j = (i + 1); j < lengthPicture; j++) {
                if ((numbersImage[i] > numbersImage[j]) && (numbersImage[i] != 15) && (numbersImage[j] != 15)) {
                    pairCounter = pairCounter + 1; // Считаем пары
                }
                if (numbersImage[j] == 15) {
                    nullNumber = (j / 4) + 1; // Ищем ряд с пустой клеткой
                }
            }
        }
        if ((pairCounter + nullNumber) % 2 != 0) { // Проверка на чётность
            RandomImage(); // Если чётное - снова перемешиваем
        }
    }

    public void LoadImages() {
        for (int i = 0; i < lengthPicture; i++) {
            if (numbersImage[i] != 15) {
                String filename = "Wolf/wolf" + numbersImage[i] + ".jpg";
                wolfImageIcon[i] = new ImageIcon(getClass().getResource(filename));
                wolfImage[i] = wolfImageIcon[i].getImage();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameFinishFlag) { // Игра активна
            for (int i = 0; i < lengthPicture;i++){
                g.drawImage(wolfImage[i], (i % 4) * dot_size, (i / 4) * dot_size, this);
                g.setColor(Color.ORANGE);
                String str1 = "" + clickerCounter;
                g.drawString(str1,480,490);
            }
        }
        if (gameFinishFlag) { // Игра завершена
            g.setColor(Color.WHITE);
            g.drawString("Конец игры",220,256);
            g.drawString("Ваш счёт: " + clickerCounter, 220, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameFinishFlag) { // Проверяем, собрали ли мы все квадраты в правильном порядке
            GameFinish();
        }
        repaint();
    }

    public void GameFinish() {
        int counter = 0;
        for (int i = 0;i<lengthPicture;i++) {
            if (numbersImage[i] == i) {
                counter = counter + 1; // Если квадрат стоит на своём месте - считаем его
            }
        }
        if (counter == lengthPicture) { // Если все номера стоят в правильном порядке - завершаеи игру
            gameFinishFlag = true;
        }
    }

    class FieldMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            int mouse = e.getButton();
            mouseX = e.getX();
            mouseY = e.getY();
            if ((mouse == MouseEvent.BUTTON1) && (!gameFinishFlag)) { // Проверяем нажатие мыши
                for (int i = 0;i < 4;i++) {
                    for (int j = 0; j < 4;j++) {
                        if ((mouseY >= dot_size*i) && (mouseY < dot_size*(i+1))) {
                            if ((mouseX >= dot_size*j) && (mouseX < dot_size*(j+1))) {
                                if (j > 0) {
                                    if (wolfImage[i * 4 + j - 1] == null) {
                                        swap(i * 4 + j, i * 4 + j - 1); // Квадрат слева
                                    }
                                }
                                if (j < 3) {
                                    if (wolfImage[i * 4 + j + 1] == null) {
                                        swap(i * 4 + j, i * 4 + j + 1); // Квадрат справа
                                    }
                                }
                                if (i > 0) {
                                    if (wolfImage[(i - 1) * 4 + j] == null) {
                                        swap(i * 4 + j, (i - 1) * 4 + j); // Квадрат сверху
                                    }
                                }
                                if (i < 3) {
                                    if (wolfImage[(i + 1) * 4 + j] == null) {
                                        swap(i * 4 + j, (i + 1) * 4 + j); // Квадрат снизу
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void swap(int i_first, int i_second) { // Меняем местами квадраты и их порядковые номера
        wolfBuffer = wolfImage[i_first];
        wolfImage[i_first] = wolfImage[i_second]; // Меняем местами картинки
        wolfImage[i_second] = wolfBuffer;
        numberBuffer = numbersImage[i_first];
        numbersImage[i_first] = numbersImage[i_second]; // Меняем местами порядковые номера
        numbersImage[i_second] = numberBuffer;
        clickerCounter = clickerCounter + 1;
    }
}