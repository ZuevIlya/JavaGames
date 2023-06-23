import java.awt.*;
public class Menu{
    public static void MenuFunction1 (Graphics g, int menu1_counter, int dot_size) {
        g.setColor(Color.WHITE);
        switch (menu1_counter) {
            case 1:
                g.drawString("Начать игру <--", 9 * dot_size, 150);
                g.drawString("Выбрать цвет платформы", 9 * dot_size, 200);
                g.drawString("Выбрать цвет шарика", 9 * dot_size, 250);
                g.drawString("Информация об авторе", 9 * dot_size, 300);
                break;
            case 2:
                g.drawString("Начать игру", 9 * dot_size, 150);
                g.drawString("Выбрать цвет платформы <--", 9 * dot_size, 200);
                g.drawString("Выбрать цвет шарика", 9 * dot_size, 250);
                g.drawString("Информация об авторе", 9 * dot_size, 300);
                break;
            case 3:
                g.drawString("Начать игру", 9 * dot_size, 150);
                g.drawString("Выбрать цвет платформы", 9 * dot_size, 200);
                g.drawString("Выбрать цвет шарика <--", 9 * dot_size, 250);
                g.drawString("Информация об авторе", 9 * dot_size, 300);
                break;
            case 4:
                g.drawString("Начать игру", 9 * dot_size, 150);
                g.drawString("Выбрать цвет платформы", 9 * dot_size, 200);
                g.drawString("Выбрать цвет шарика", 9 * dot_size, 250);
                g.drawString("Информация об авторе <--", 9 * dot_size, 300);

        }
    }

    public static void MenuFunction2 (Graphics g, int menu2_counter, int menu2_enter, int dot_size) {
            g.setColor(Color.WHITE);
            g.drawString("Выберите цвет платформы", 8 * dot_size, 50);
            switch (menu2_counter) {
                case 1:
                if (menu2_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий <--", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9 * dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9 * dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9 * dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9 * dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9 * dot_size, 350);
                    break;
                case 2:
                    if (menu2_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный <--", 9 * dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9 * dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9 * dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9 * dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9 * dot_size, 350);
                    break;
                case 3:
                    if (menu2_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9 * dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный <--", 9 * dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9 * dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9 * dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9 * dot_size, 350);
                    break;
                case 4:
                    if (menu2_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9 * dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9 * dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый <--", 9 * dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9 * dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9 * dot_size, 350);
                    break;
                case 5:
                    if (menu2_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9 * dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9 * dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9 * dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый <--", 9 * dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9 * dot_size, 350);
                    break;
                case 6:
                    if (menu2_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9 * dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9 * dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9 * dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu2_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9 * dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню <--", 9 * dot_size, 350);
                    break;
            }
        }
    public static void MenuFunction3 (Graphics g, int menu3_counter, int menu3_enter, int dot_size) {
            g.setColor(Color.WHITE);
            g.drawString("Выберите цвет шарика", 8*dot_size, 50);
            switch (menu3_counter) {
                case 1:
                    if (menu3_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий <--", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9*dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9*dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9*dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9*dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9*dot_size, 350);
                    break;
                case 2:
                    if (menu3_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный <--", 9*dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9*dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9*dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9*dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9*dot_size, 350);
                    break;
                case 3:
                    if (menu3_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9*dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный <--", 9*dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9*dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9*dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9*dot_size, 350);
                    break;
                case 4:
                    if (menu3_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9*dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9*dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый <--", 9*dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9*dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9*dot_size, 350);
                    break;
                case 5:
                    if (menu3_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9*dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9*dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9*dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый <--", 9*dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню", 9*dot_size, 350);
                    break;
                case 6:
                    if (menu3_enter == 1) {
                        g.setColor(Color.BLUE);
                    }
                    g.drawString("Синий", 9 * dot_size, 100);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 2) {
                        g.setColor(Color.GREEN);
                    }
                    g.drawString("Зелёный", 9*dot_size, 150);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 3) {
                        g.setColor(Color.RED);
                    }
                    g.drawString("Красный", 9*dot_size, 200);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 4) {
                        g.setColor(Color.ORANGE);
                    }
                    g.drawString("Оранжевый", 9*dot_size, 250);
                    g.setColor(Color.WHITE);
                    if (menu3_enter == 5) {
                        g.setColor(Color.YELLOW);
                    }
                    g.drawString("Жёлтый", 9*dot_size, 300);
                    g.setColor(Color.WHITE);
                    g.drawString("Выход в основное меню <--", 9*dot_size, 350);
                    break;
            }
    }

    public static void MenuFunction4 (Graphics g, int dot_size) {
        g.setColor(Color.WHITE);
        g.drawString("Вконтакте автора: @ilyazyev", 3 * dot_size, 150);
        g.drawString("Телеграм автора: @Zuev2000", 3 * dot_size, 200);
        g.drawString("Нажмите кнопку ENTER чтобы вернуться в основное меню", 3 * dot_size, 250);
    }

    public static void menuGameOver(Graphics g){
        String str1 = "Game Over";
        String str2 = "Нажмите кнопку ENTER чтобы начать новую игру";
        g.setColor(Color.RED);
        g.drawString(str1, 205, 200);
        g.setColor(Color.WHITE);
        g.drawString(str2, 90, 250);
    }
    public static void menuGameWin(Graphics g){
        String str1 = "Победа!";
        String str2 = "Нажмите кнопку ENTER чтобы начать новую игру";
        g.setColor(Color.WHITE);
        g.drawString(str1, 205, 200);
        g.drawString(str2, 80, 250);
    }
}
